package com.youcode.marjanv2.Models.Dto.CategoryDto;

import com.youcode.marjanv2.Models.Entity.Category;

import com.youcode.marjanv2.Models.Entity.Promotion;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryPromotionDto {
    private Long id;
    private String name;
    private String description;
}
