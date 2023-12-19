package com.youcode.marjanv2.Controllers;

import com.youcode.marjanv2.Models.Entity.ResponsableCenter;
import com.youcode.marjanv2.Services.ResponsableCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("/api/v1/responsables")
public class ResponsableCenterController {
    private final ResponsableCenterService service;
    @Autowired
    public ResponsableCenterController(ResponsableCenterService service) {
        this.service = service;
    }
    @GetMapping
    public List<ResponsableCenter> getAllResponsables(){
        return service.getAllResponsables();
    }

    @GetMapping("/{id}")
    public Optional<ResponsableCenter> getResponsable(@PathVariable Long id){
        return service.getResponsableById(id);
    }

    @PostMapping("/create")
    public ResponsableCenter createResponsable(@RequestBody ResponsableCenter responsableCenter){
        return service.createResponsable(responsableCenter);
    }
    @DeleteMapping("/{id}")
    public void deleteResponsableById(@PathVariable Long id) {
        service.deleteResponsableById(id);
    }

    @PatchMapping("/update/{ResponsableId}")
    public ResponsableCenter updateResponsable(@PathVariable Long ResponsableId, @RequestBody ResponsableCenter responsable) {
        return service.updateResponsable(ResponsableId, responsable);
    }
}
