package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Admin;
import com.youcode.marjanv2.Repositories.AdminRepository;
import com.youcode.marjanv2.Services.Exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
        System.out.println(admin);
    }

    public void deleteAdminById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            adminRepository.deleteById(id);
            ResponseEntity.status(HttpStatus.OK).body("Admin deleted successfully");
        } else {
            throw new CustomException("Admin with ID " + id + " not found");
        }
    }

    public Admin getAdminById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return admin.get();
        } else {
            throw new CustomException("Admin with ID " + id + " not found");
        }
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
}
