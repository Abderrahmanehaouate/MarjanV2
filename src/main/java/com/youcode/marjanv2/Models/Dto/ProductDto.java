package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Dto.CategoryDto.CategoryDto;
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
    private Long quantity;
    private boolean status;
    private CategoryDto category;
    private Promotion promotion;
}
