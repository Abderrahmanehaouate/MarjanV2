package com.youcode.marjanv2.Models.Dto;

import com.youcode.marjanv2.Models.Entity.Center;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CenterDto {
    private Long id;
    private String name;
    private String city;
    private String description;
    private Long responsableCenterId;

    public static CenterDto fromEntity(Center center) {
        return CenterDto.builder()
                .id(center.getId())
                .name(center.getName())
                .city(center.getCity())
                .description(center.getDescription())
                .responsableCenterId(
                        center.getResponsableCenter() != null ? center.getResponsableCenter().getId() : null
                )
                .build();
    }
}
