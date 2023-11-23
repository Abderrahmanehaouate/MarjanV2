package com.youcode.marjanv2.Models.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table
@Getter
@Setter
@Entity
public class CashierAgent extends BaseUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cashierAgent")
    @JsonIgnore
    private List<Customer> customers;
}