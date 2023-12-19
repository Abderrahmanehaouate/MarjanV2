package com.youcode.marjanv2.Repositories;

import com.youcode.marjanv2.Models.Entity.ResponsableCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableCenterRepository extends JpaRepository<ResponsableCenter, Long> {

}
