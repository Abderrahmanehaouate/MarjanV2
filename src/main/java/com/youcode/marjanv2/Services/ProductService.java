package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Dto.ProductDto;
import com.youcode.marjanv2.Models.Entity.Product;
import com.youcode.marjanv2.Repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(p -> modelMapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
    }

    public void createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public ProductDto getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(p -> modelMapper.map(p, ProductDto.class)).orElse(null);
    }

}