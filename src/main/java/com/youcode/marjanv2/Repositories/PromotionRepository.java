package com.youcode.marjanv2.Repositories;

import com.youcode.marjanv2.Models.Entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    void addPromotionToCategory(Long categoryId, Long promotionId);
}
