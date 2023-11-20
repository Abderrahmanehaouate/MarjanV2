package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.Admin;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto {
    private Long id;
    private String name;
    private String email;
    private String password;

    public static AdminDto fromEntity(Admin admin) {
        return AdminDto.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .build();
    }
}
