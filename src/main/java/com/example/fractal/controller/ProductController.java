package com.example.fractal.controller;

import com.example.fractal.persistence.entity.ProductEntity;
import com.example.fractal.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts(){
        List<ProductEntity> productList = this.productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable("id") Long id){
        ProductEntity product = this.productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Guardar un nuevo producto
    @PostMapping
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity productToSave){
        ProductEntity product = this.productService.saveProduct(productToSave);
        return new ResponseEntity<>(product, HttpStatus.CREATED );
    }

    // Editar un producto
    @PutMapping
    public ResponseEntity<Void> updateProduct(@RequestBody ProductEntity productToUpdate){
        this.productService.updateProduct(productToUpdate);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
