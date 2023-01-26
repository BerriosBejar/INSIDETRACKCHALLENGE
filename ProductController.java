package com.product.insidetrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.insidetrack.model.Product;
import com.product.insidetrack.service.ProductService;

@CrossOrigin("*")
@Controller
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllproducts() {
      // try {
        List<Product> products = productService.getAllProducts();
  
        if (products.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
  
        return new ResponseEntity<>(products, HttpStatus.OK);
      // } catch (Exception e) {
      //   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      // }
    }
  
}
