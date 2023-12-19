package com.youcode.marjanv2.Models.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.youcode.marjanv2.Enum.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "tbl_promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date created_at;
    private Date ending_at;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Double discountPercentage;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "general_Admin_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private GeneralAdmin generalAdmin;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();
}