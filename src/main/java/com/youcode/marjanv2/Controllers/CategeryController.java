package com.youcode.marjanv2.Controllers;

import com.youcode.marjanv2.Models.Dto.CategoryDto.CategoryDto;
import com.youcode.marjanv2.Models.Entity.Category;
import com.youcode.marjanv2.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/categories")
public class CategeryController {
    private final CategoryService categoryService;
    
    @Autowired
    public CategeryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Category category) {
        categoryService.saveAdmin(category);
        return new ResponseEntity<>("Category created successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
