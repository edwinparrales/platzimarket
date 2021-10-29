package com.platzi.market.web.controller;

import com.platzi.market.dominio.Product;
import com.platzi.market.dominio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductController {
    @Autowired
    private ProductService productService;
    //Retornar la lista de todos los productos http://localhost:8090//api/content/producto/all
    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProducto(int productId){
       return productService.getProduct(productId);
    }

   //Retornar lista de productos por categoria fdf
    public Optional<List<Product>> getByCategory(int categoryId){
        return productService.getByCategory(categoryId);
    }
    public Product save(Product product){
        return productService.save(product);
    }

    public boolean delete(int productId){
      return productService.delete(productId);
    }
}
