package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Dto.CategoryDto;
import com.youcode.marjanv2.Models.Entity.Category;
import com.youcode.marjanv2.Repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public void saveAdmin(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepository.save(category);
    }
}
