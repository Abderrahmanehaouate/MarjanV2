package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.Product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long quantity;
    private String imageUrl;
    private String productStatus;
    private CategoryDto category;
    private PromotionDto promotion;

    public static ProductDto fromEntity(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .category(CategoryDto.fromEntity(product.getCategory()))
                .promotion(PromotionDto.fromEntity(product.getPromotion()))
                .build();
    }
}
