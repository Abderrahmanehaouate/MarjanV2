package com.youcode.marjanv2.Models.Dto.PromotionDto;

import com.youcode.marjanv2.Enum.Status;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionResponseDto {
    private Long id;
    private String name;
    private String description;
    private Date created_at;
    private Date ending_at;
    private Double discountPercentage;
    private Status status;
}
