package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAll() {
        List<Transaction> transactions =  transactionRepository.findAll();
        transactions.sort(Comparator.comparing(Transaction::getDate));
        return transactions;
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findAll()
                .stream().filter(transaction -> transaction.getId().equals(id))
                .findFirst();

//        List<Transaction> transactions =  transactionRepository.findAll();
//        for (Transaction transaction: transactions) {
//            if (transaction.getId().equals(id)) {
//                return Optional.of(transaction);
//            }
//        }
//        return Optional.empty();
    }
}
