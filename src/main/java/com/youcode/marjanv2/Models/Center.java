package com.youcode.marjanv2.Models;

import jakarta.persistence.*;

@Table
@Entity(name = "tbl_centers")
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "center_id")
    private Long id;
    private String name;
    private String description;

}
