package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Exceptions.CustomException;
import com.youcode.marjanv2.Models.Dto.PromotionDto;
import com.youcode.marjanv2.Models.Entity.Category;
import com.youcode.marjanv2.Models.Entity.Product;
import com.youcode.marjanv2.Models.Entity.Promotion;
import com.youcode.marjanv2.Repositories.CategoryRepository;
import com.youcode.marjanv2.Repositories.ProductRepository;
import com.youcode.marjanv2.Repositories.PromotionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public PromotionService(PromotionRepository promotionRepository, ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.promotionRepository = promotionRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    public List<PromotionDto> getPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        return promotions.stream()
                .map(PromotionDto::fromEntity)
                .collect(Collectors.toList());
    }

    public PromotionDto getPromotionById(Long id) {
        Optional<Promotion> promotion = promotionRepository.findById(id);
        return promotion.map(PromotionDto::fromEntity)
                .orElse(null);
    }

    public Promotion applyPromotionToCategory(PromotionDto promotionDto) {
        Promotion promotion = modelMapper.map(promotionDto, Promotion.class);

        LocalTime currentTime = LocalTime.now();
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(23, 0);

        if (currentTime.isBefore(startTime) || currentTime.isAfter(endTime)) {
            throw new CustomException("Promotions can only be applied between 8:00 AM and 12:00 PM.");
        }
//        if (promotion.getDiscountPercentage() > 50) {
//            throw new CustomException("Promotion percentage exceeds 50%");
//        }

        Category category = categoryRepository.findById(promotionDto.getCategoryId())
                .orElseThrow(() -> new CustomException("Category not found"));

        List<Product> products = category.getProducts();
        for (Product product : products) {
            if (product.getQuantity() < 20 && promotion.getDiscountPercentage() > 70) {
                throw new CustomException("Promotion percentage exceeds 70% for products with quantity < 20");
            }
        }

        double loyaltyPoints = promotion.getDiscountPercentage() / 5 * 3;

        Promotion savedPromotion = promotionRepository.save(promotion);

        for (Product product : products) {
            product.setPromotion(savedPromotion);
            productRepository.save(product);
        }

        savedPromotion.setCategory(category);
        savedPromotion.setLoyaltyPoints(loyaltyPoints);

        return promotionRepository.save(savedPromotion);
    }
}
