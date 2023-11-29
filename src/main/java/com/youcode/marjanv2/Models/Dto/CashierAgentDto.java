package com.youcode.marjanv2.Models.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CashierAgentDto {
    private Long id;
    private String name;
    private String email;
    private String password;
}
