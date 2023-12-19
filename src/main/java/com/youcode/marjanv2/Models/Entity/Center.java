package com.youcode.marjanv2.Models.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Getter
@Setter
@Entity(name = "tbl_centers")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String description;

    @OneToOne(mappedBy = "center")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ResponsableCenter responsableCenter;
}
