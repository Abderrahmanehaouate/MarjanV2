package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.Customer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoyaltyCardDto {
    private Long id;
    private String cardNumber;
    private int points;
    private CustomerDto customerDto;

}
