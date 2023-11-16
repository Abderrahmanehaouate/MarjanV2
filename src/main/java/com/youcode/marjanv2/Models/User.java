package com.youcode.marjanv2.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_users")
public class User extends BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Getters and setters
    @Override
    public Long getId() {
        return this.id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
