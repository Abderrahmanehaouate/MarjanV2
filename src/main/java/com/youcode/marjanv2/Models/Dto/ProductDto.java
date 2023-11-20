package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.Category;
import com.youcode.marjanv2.Models.Entity.Promotion;
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
    private Category category;
    private Promotion promotion;
}
