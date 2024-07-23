package com.example.usedrecycling.product;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public ResponseEntity<?> registerProduct(@RequestBody ProductRegisterPostRequest productRegisterPostRequest, HttpSession session) {
        productService.registerProduct(productRegisterPostRequest, session);
        return ResponseEntity.status(HttpStatus.OK).body("product registered");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id, HttpSession session) {
        if (productService.isUserPermittedToDeleteOrUpdateProduct(id, session)) {
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK).body("delete successfully");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("no permission");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateProduct(Product product, HttpSession session) {
        if (productService.isUserPermittedToDeleteOrUpdateProduct(product.getId(), session)) {
            Product newProduct = productService.updateProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body(newProduct);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("no permission");
        }
    }
}
