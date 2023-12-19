package com.youcode.marjanv2.Models.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JoinColumn(name = "cashier_agent_id")
    private CashierAgent cashierAgent;

    @OneToOne(mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LoyaltyCard loyaltyCard;
}
