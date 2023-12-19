package com.youcode.marjanv2.Repositories;

import com.youcode.marjanv2.Models.Entity.Promotion;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    @Override
    Page<Promotion> findAll(Pageable pageable);

}
