package com.youcode.marjanv2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class GeneralAdminController {
    @GetMapping("/")
    public String greeting(){
        return "Hello, World!";
    }
}