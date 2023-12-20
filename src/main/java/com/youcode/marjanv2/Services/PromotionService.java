package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Dto.CategoryDto.CategoryPromotionDto;
import com.youcode.marjanv2.Models.Dto.PromotionDto.PromotionDto;
import com.youcode.marjanv2.Models.Entity.Category;
import com.youcode.marjanv2.Models.Entity.Promotion;
import com.youcode.marjanv2.Observer.Observer;
import com.youcode.marjanv2.Repositories.CategoryRepository;
import com.youcode.marjanv2.Repositories.PromotionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromotionService {
    private List<Observer> observers = new ArrayList<>();
    private final PromotionRepository promotionRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    @Autowired
    public PromotionService(PromotionRepository promotionRepository, CategoryRepository categoryRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.promotionRepository = promotionRepository;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    public List<PromotionDto> getPromotions(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Slice<Promotion> promotionSlice = promotionRepository.findAll(pageRequest);

        List<PromotionDto> promotionDtos = promotionSlice.getContent().stream()
                .map(promotion -> modelMapper.map(promotion, PromotionDto.class))
                .collect(Collectors.toList());
        return promotionDtos;
    }

    public PromotionDto getPromotionById(Long id) {
        Optional<Promotion> promotion = promotionRepository.findById(id);
        return promotion.map(p -> modelMapper.map(p, PromotionDto.class)).orElse(null);
    }

    public PromotionDto createPromotion(PromotionDto promotionDto) {
        Promotion promotion = modelMapper.map(promotionDto, Promotion.class);

        // Create a new list to store the managed Category entities
        List<Category> managedCategories = new ArrayList<>();

        for (CategoryPromotionDto categoryDto : promotionDto.getCategories()) {
            Category category = categoryRepository.findById(categoryDto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Category with ID " + categoryDto.getId() + " not found"));

            // Set the promotion for the category
            category.setPromotion(promotion);

            // Add the managed category to the list
            managedCategories.add(category);
        }

        // Set the categories for the promotion
        promotion.setCategories(managedCategories);

        // Save the promotion and let cascade settings handle the associated categories
        Promotion savedPromotion = promotionRepository.save(promotion);

        return modelMapper.map(savedPromotion, PromotionDto.class);
    }



    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }
}
