package com.example.usedrecycling.transaction;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/{id}")
    public ResponseEntity<?> processTransaction(@PathVariable("id") Integer productId, @RequestBody TransactionPostRequest transactionPostRequest, HttpSession session) {
        transactionService.processTransaction(productId, transactionPostRequest.getMailLocation(), transactionPostRequest.getNumber(), session);
        return ResponseEntity.status(HttpStatus.OK).body("Transaction done");
    }

    @GetMapping("/seller")
    public ResponseEntity<?> getMyTransactionsAsSeller(HttpSession session) {
        List<Transaction> transactions = transactionService.getMyTransactionAsSeller(session);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @GetMapping("/cust")
    public ResponseEntity<?> getMyTransactionAsCust(HttpSession session) {
        List<Transaction> transactions = transactionService.getMyTransactionAsCust(session);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<?> setTransactionStatusAsFinished(@PathVariable Integer id, HttpSession session) {
        if (transactionService.isUserAllowedToUpdateTransactionStatus(id, session)) {
            transactionService.setTransactionStatusAsFinished(id, session);
            Transaction newTransaction = transactionService.getTransactionById(id);
            return ResponseEntity.status(HttpStatus.OK).body(newTransaction);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No permission");
        }
    }
}
