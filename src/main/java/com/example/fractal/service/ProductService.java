package com.example.fractal.service;

import com.example.fractal.exception.BaseException;
import com.example.fractal.persistence.entity.ProductEntity;
import com.example.fractal.persistence.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // Obtener todos los productos existentes
    public List<ProductEntity> getAllProducts(){
        return this.productRepository.findAll();
    }

    // Obtener un producto por su ID
    public ProductEntity getProductById(Long id) {
        return this.productRepository.findById(id).orElseThrow( () ->
            new BaseException("No existe el producto con el ID brindado", HttpStatus.NOT_FOUND)
        );
    }

    // Guardar un nuevo producto
    public ProductEntity saveProduct(ProductEntity product){
        return this.productRepository.save(product);
    }

    // Actualizar la información de un producto
    public void updateProduct(ProductEntity product) {
        Optional<ProductEntity> optProduct = this.productRepository.findById(product.getId());
        if(!optProduct.isPresent())
            throw new BaseException("No existe el producto con el ID brindado", HttpStatus.NOT_FOUND);
        this.productRepository.save(product);
    }
}
