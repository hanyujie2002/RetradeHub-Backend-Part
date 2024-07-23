package com.example.usedrecycling.product;

import com.example.usedrecycling.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    public void registerProduct(ProductRegisterPostRequest productRegisterPostRequest, HttpSession session) {
        User user = (User) session.getAttribute("user");

        Integer userId = user.getId();

        productMapper.insertProduct(productRegisterPostRequest, userId);
    }

    public void deleteProduct(Integer id) {
        productMapper.deleteProduct(id);
    }

    public Product updateProduct(Product product) {
        productMapper.updateProduct(product);
        return productMapper.getProductById(product.getId());
    }

    public Boolean isUserPermittedToDeleteOrUpdateProduct(Integer id, HttpSession session) {
        Product product = (Product) productMapper.getProductById(id);
        Integer sellerId = product.getSellerId();

        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        return Objects.equals(sellerId, userId);
    }

    public Product getProductById(Integer id) {
        return productMapper.getProductById(id);
    }
}
