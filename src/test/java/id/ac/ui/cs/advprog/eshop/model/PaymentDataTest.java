package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentDataTest {

    @Test
    void testTestVoucherCode(){
        assertTrue(testVoucherCode("ESHOP12345678abc"));
    }
    @Test
    void testTestVoucherCodeIfNot16Characters(){
        assertFalse(testVoucherCode("ESHOP12345678"));
        assertFalse(testVoucherCode("ESHOP12345678aaaa"));

    }

    @Test
    void testTestVoucherCodeIfDoesNotStartWithESHOP(){
        assertFalse(testVoucherCode("12345678abcdefgh"));
    }


    @Test
    void testTestVoucherCodeIfDoesNotContain8NumericalCharacters(){
        assertFalse(testVoucherCode("ESHOP1234567aaaa"));
        assertFalse(testVoucherCode("ESHOP123456789aa"));
    }


    @Test
    void testIsStringEmpty(){
        assertTrue(isStringEmpty('a'));
    }

    @Test
    void testIsStringEmptyIfNull(){
        assertFalse(isStringEmpty(null));
    }

    @Test
    void testIsStringEmptyIfEmpty(){
        assertFalse(isStringEmpty(""));
    }


}