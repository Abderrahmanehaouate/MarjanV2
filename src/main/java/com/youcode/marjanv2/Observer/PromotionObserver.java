package com.youcode.marjanv2.Observer;

import com.youcode.marjanv2.Models.Entity.Promotion;

public interface PromotionObserver {
    void notifyAdminByPromotion(Promotion promotion);
}
