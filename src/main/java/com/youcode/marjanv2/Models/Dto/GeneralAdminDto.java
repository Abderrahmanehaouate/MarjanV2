package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.GeneralAdmin;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralAdminDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    public static GeneralAdminDto fromEntity(GeneralAdmin generalAdmin){
        return GeneralAdminDto.builder()
                .id(generalAdmin.getId())
                .name(generalAdmin.getName())
                .email(generalAdmin.getEmail())
                .build();
    }
}
