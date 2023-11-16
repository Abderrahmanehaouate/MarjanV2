package com.youcode.marjanv2.Repositories;

import com.youcode.marjanv2.Models.Entity.GeneralAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralAdminRepository extends JpaRepository<GeneralAdmin, Long> {

}
