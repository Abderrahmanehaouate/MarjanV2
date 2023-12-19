package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Dto.ProductDto;
import com.youcode.marjanv2.Models.Entity.Product;
import com.youcode.marjanv2.Repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public ProductDto createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepository.save(product);
        return modelMapper.map(product, ProductDto.class);
    }


    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long productId, Product product) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        existingProduct.setStatus(product.getStatus());
        return productRepository.save(existingProduct);

    }

    public ProductDto getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(p -> modelMapper.map(p, ProductDto.class)).orElse(null);
    }

}