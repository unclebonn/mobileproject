package com.example.endproject.api.Transaction;

public class TransactionRequestModel {
    private Transaction transaction;

    public TransactionRequestModel(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
