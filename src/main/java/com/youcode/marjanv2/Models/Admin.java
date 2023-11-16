package com.youcode.marjanv2.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_admins")
public class Admin extends BaseUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Override
    public Long getId() {
        return this.id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
