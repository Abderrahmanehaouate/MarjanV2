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
    private String imageUrl;
    private String productStatus;
    private Long categoryId;
    private Long promotionId;

    public static ProductDto fromEntity(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .productStatus(product.getProductStatus())
                .categoryId(product.getCategory() != null ? product.getCategory().getId() : null)
                .promotionId(product.getPromotion() != null ? product.getPromotion().getId() : null)
                .build();
    }
}
