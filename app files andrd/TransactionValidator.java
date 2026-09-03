package com.example.fintech;

public class TransactionValidator {

    public static boolean isValidAmount(double amount) {
        return amount > 0 && amount <= 10000;
    }

    public static double applyFee(double amount, double feePercent) {
        return amount + (amount * feePercent / 100);
    }

    public static boolean hasSufficientBalance(double balance, double amount) {
        return balance >= amount;
    }
}
