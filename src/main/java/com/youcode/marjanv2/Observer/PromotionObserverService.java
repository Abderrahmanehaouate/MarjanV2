package com.youcode.marjanv2.Observer;

import com.youcode.marjanv2.Models.Entity.Admin;
import com.youcode.marjanv2.Services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionObserverService {

    private final PromotionService promotionService;
    private final Admin admin;

    @Autowired
    public PromotionObserverService(PromotionService promotionService, Admin admin) {
        this.promotionService = promotionService;
        this.admin = admin;

        this.promotionService.addObserver((PromotionObserver) admin);
    }
}
