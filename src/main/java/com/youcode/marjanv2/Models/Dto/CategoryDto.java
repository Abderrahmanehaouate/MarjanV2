package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.Category;
import com.youcode.marjanv2.Models.Entity.Product;
import com.youcode.marjanv2.Models.Entity.Promotion;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private List<Long> productIds;
    private List<Long> promotionIds;

    public static CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .productIds(getProductIds(category.getProducts()))
                .promotionIds(getPromotionIds(category.getPromotions()))
                .build();
    }

    private static List<Long> getProductIds(List<Product> products) {
        return products.stream()
                .map(Product::getId)
                .collect(Collectors.toList());
    }

    private static List<Long> getPromotionIds(List<Promotion> promotions) {
        return promotions.stream()
                .map(Promotion::getId)
                .collect(Collectors.toList());
    }
}
