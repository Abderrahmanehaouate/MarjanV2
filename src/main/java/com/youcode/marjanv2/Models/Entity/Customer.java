package com.youcode.marjanv2.Models.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "tbl_customers")
public class Customer extends BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private String address;

    @ManyToOne
    @JoinColumn(name = "cashier_agent_id", nullable = false)
    private CashierAgent cashierAgent;

    @OneToOne(mappedBy = "customer")
    private LoyaltyCard loyaltyCard;
}
