package com.youcode.marjanv2.Models.Dto.CategoryDto;

import com.youcode.marjanv2.Models.Dto.PromotionDto;
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
    private PromotionDto promotion;
}
