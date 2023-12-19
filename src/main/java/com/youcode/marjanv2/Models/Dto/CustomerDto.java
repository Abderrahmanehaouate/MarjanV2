package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.CashierAgent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private Long id;
    private String name;
    private String description;
    private int cashierAgentId;
    private LoyaltyCardDto loyaltyCardDto;
}
