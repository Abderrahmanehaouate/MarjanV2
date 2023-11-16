package com.youcode.marjanv2.Controllers;

import com.youcode.marjanv2.Models.Entity.Admin;
import com.youcode.marjanv2.Services.AdminService;
import com.youcode.marjanv2.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @Autowired
    private EmailService emailService;
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);

        String to = admin.getEmail();
        String subject = "Your Account Admin Created";
        String content = "Username: " + admin.getName() + "\nPassword: " + admin.getPassword();

        emailService.sendEmail(to, subject, content);

        return new ResponseEntity<>("Admin created successfully", HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
        return new ResponseEntity<>("Admin updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdminById(@PathVariable Long id) {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>("Admin deleted successfully", HttpStatus.OK);
    }
}
