package com.youcode.marjanv2.Repositories;

import com.youcode.marjanv2.Models.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
