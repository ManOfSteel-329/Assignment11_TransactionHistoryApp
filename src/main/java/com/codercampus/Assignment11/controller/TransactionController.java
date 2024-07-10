package com.codercampus.Assignment11.controller;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;

//      http://localhost:8080/transactions
    @GetMapping("/transactions")
    public String getAllTransactions(Model model) {
        List<Transaction> transactions = transactionService.findAll();
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

//      http://localhost:8080/transactions/{transactionId}
    @GetMapping("/transactions/{transactionId}")
    public String getTransactionById(@PathVariable Long transactionId, Model model) {
        Transaction transaction = transactionService.findById(transactionId)
                        .orElseThrow(() -> new IllegalArgumentException("Transaction ID is not valid: " + transactionId));
        model.addAttribute("transaction", transaction);
        System.out.println(transaction.getType());
        return "transaction-detail";
    }

}
