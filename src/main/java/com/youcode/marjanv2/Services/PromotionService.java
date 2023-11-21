package com.youcode.marjanv2.Services;

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
        return promotions.stream().
                map(promotion -> modelMapper.map(promotion, PromotionDto.class))
                .collect(Collectors.toList());
    }

    public PromotionDto getPromotionById(Long id) {
        Optional<Promotion> promotion = promotionRepository.findById(id);
        return promotion.map(promo -> modelMapper.map(promo,PromotionDto.class)).orElse(null);
    }

    public Promotion createPromotion(PromotionDto promotionDto) {
        Promotion promotion = modelMapper.map(promotionDto, Promotion.class);
        return promotionRepository.save(promotion);
    }

    public Promotion applyPromotionToCategory(Long categoryId, PromotionDto promotionDto) {
        Promotion promotion = modelMapper.map(promotionDto, Promotion.class);
        if (promotion.getDiscountPercentage() > 50) {
            throw new IllegalArgumentException("Promotion percentage exceeds 50%");
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        List<Product> products = category.getProducts();
        for (Product product : products) {
            if (product.getQuantity() < 20 && promotion.getDiscountPercentage() > 70) {
                throw new IllegalArgumentException("Promotion percentage exceeds 70% for products with quantity < 20");
            }
        }

        double loyaltyPoints = promotion.getDiscountPercentage() / 5 * 3;

        for (Product product : products) {
            product.setPromotion(promotion);
            productRepository.save(product);
        }

        promotion.setCategory(category);
        promotion.setLoyaltyPoints(loyaltyPoints);
        return promotionRepository.save(promotion);
    }
}
