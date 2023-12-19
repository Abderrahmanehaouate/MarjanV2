package com.youcode.marjanv2.Models.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.marjanv2.Enum.Status;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tbl_products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long quantity;
    private String imageUrl;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

}
