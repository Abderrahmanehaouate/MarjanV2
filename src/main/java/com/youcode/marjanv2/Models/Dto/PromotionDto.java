package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.Product;
import com.youcode.marjanv2.Models.Entity.Promotion;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionDto {
    private Long id;
    private String name;
    private String description;
    private Double discountPercentage;
    private Double loyaltyPoints;
    private Date startTime;
    private Date endTime;
    private String status;
    private Long categoryId;

    private List<Long> productIds;

    public static PromotionDto fromEntity(Promotion promotion) {
        return PromotionDto.builder()
                .id(promotion.getId())
                .name(promotion.getName())
                .loyaltyPoints(promotion.getLoyaltyPoints())
                .startTime(promotion.getStartTime())
                .endTime(promotion.getEndTime())
                .status(promotion.getStatus())
                .description(promotion.getDescription())
                .discountPercentage(promotion.getDiscountPercentage())
                .categoryId(
                        promotion.getCategory() != null ? promotion.getCategory().getId() : null
                )
                .productIds(getProductIds(promotion.getProducts()))
                .build();
    }

    private static List<Long> getProductIds(List<Product> products) {
        return products.stream()
                .map(Product::getId)
                .collect(Collectors.toList());
    }
}