package com.example.usedrecycling.transaction;

import com.example.usedrecycling.product.Product;
import com.example.usedrecycling.product.ProductService;
import com.example.usedrecycling.user.User;
import com.example.usedrecycling.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TransactionService {
    @Autowired
    TransactionMapper transactionMapper;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    public void processTransaction(Integer productId, String mailLocation, Integer number, HttpSession session) {
        // get product, customer and seller
        User cust = (User) session.getAttribute("user");
        Product product = (Product) productService.getProductById(productId);
        Integer sellerId = product.getSellerId();

        Transaction transaction = new Transaction(product.getId(), 0, sellerId, cust.getId(), mailLocation, 0, number);
        transactionMapper.insertTransaction(transaction);
    }

    public List<Transaction> getMyTransactionAsSeller(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer sellerId = user.getId();

        return transactionMapper.getTransactionsBySellerId(sellerId);
    }

    public List<Transaction> getMyTransactionAsCust(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer custId = user.getId();

        return transactionMapper.getTransactionsByCustId(custId);
    }

    public Boolean isUserAllowedToUpdateTransactionStatus(Integer id, HttpSession session) {
        Transaction transaction = transactionMapper.getTransactionById(id);
        Integer custId = transaction.getCustId();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        return Objects.equals(custId, userId);
    }

    public void setTransactionStatusAsFinished(Integer id, HttpSession session) {
        transactionMapper.setTransactionStatusAsFinished(id);
    }

    public Transaction getTransactionById(Integer id) {
        return transactionMapper.getTransactionById(id);
    }
}
