package com.youcode.marjanv2.Services;

import com.youcode.marjanv2.Models.Dto.ProductDto;
import com.youcode.marjanv2.Models.Entity.Product;
import com.youcode.marjanv2.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        Mockito.when(productRepository.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(new ProductDto());

        List<ProductDto> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testCreateProduct() {
        ProductDto productDto = new ProductDto();
        Product product = new Product();
        Mockito.when(modelMapper.map(productDto, Product.class)).thenReturn(product);

        productService.createProduct(productDto);
    }

    @Test
    public void testDeleteProductById() {
        Long productId = 1L;

        productService.deleteProductById(productId);
    }

    @Test
    public void testUpdateProduct() {
        ProductDto productDto = new ProductDto();
        Product product = new Product();
        Mockito.when(modelMapper.map(productDto, Product.class)).thenReturn(product);

        productService.updateProduct(productDto);

    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;
        Optional<Product> optionalProduct = Optional.of(new Product());
        Mockito.when(productRepository.findById(productId)).thenReturn(optionalProduct);
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(new ProductDto());

        ProductDto result = productService.getProductById(productId);

        assertNotNull(result);
    }
}

