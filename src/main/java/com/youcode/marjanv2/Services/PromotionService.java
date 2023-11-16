package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }
    public void applyPromotionToCategory(Long categoryId, Long promotionId) {
        promotionRepository.addPromotionToCategory(categoryId, promotionId);
    }
}
