package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Dto.PromotionDto;
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
    private final ModelMapper modelMapper;
    @Autowired
    public PromotionService(PromotionRepository promotionRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.promotionRepository = promotionRepository;
        this.categoryRepository = categoryRepository;
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
        return modelMapper.map(promotionRepository.save(promotion), PromotionDto.class);
    }
    public void deletePromotion(Long id) {
        promotionRepository.deleteById(id);
    }
}
