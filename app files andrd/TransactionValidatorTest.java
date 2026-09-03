package com.example.fintech;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TransactionValidatorTest {

    @Test
    public void validAmount_withinRange_returnsTrue() {
        assertTrue(TransactionValidator.isValidAmount(500));
    }

    @Test
    public void validAmount_negative_returnsFalse() {
        assertFalse(TransactionValidator.isValidAmount(-10));
    }

    @Test
    public void validAmount_overLimit_returnsFalse() {
        assertFalse(TransactionValidator.isValidAmount(10001));
    }

    @Test
    public void applyFee_addsCorrectPercentage() {
        double result = TransactionValidator.applyFee(100, 5);
        assertEquals(105.0, result, 0.001);
    }

    @Test
    public void hasSufficientBalance_enoughFunds_returnsTrue() {
        assertTrue(TransactionValidator.hasSufficientBalance(200, 150));
    }

    @Test
    public void hasSufficientBalance_notEnoughFunds_returnsFalse() {
        assertFalse(TransactionValidator.hasSufficientBalance(100, 150));
    }
}
