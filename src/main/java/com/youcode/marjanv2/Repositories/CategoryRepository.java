package com.youcode.marjanv2.Repositories;

import com.youcode.marjanv2.Models.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
