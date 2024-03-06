package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.Test;

import static id.ac.ui.cs.advprog.eshop.model.PaymentData.isStringEmpty;
import static id.ac.ui.cs.advprog.eshop.model.PaymentData.checkVoucherCode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentDataTest {

    @Test
    void testCheckVoucherCode(){
        assertTrue(checkVoucherCode("ESHOP12345678abc"));
    }
    @Test
    void testCheckVoucherCodeIfNot16Characters(){
        assertFalse(checkVoucherCode("ESHOP12345678"));
        assertFalse(checkVoucherCode("ESHOP12345678aaaa"));

    }

    @Test
    void testCheckVoucherCodeIfDoesNotStartWithESHOP(){
        assertFalse(checkVoucherCode("12345678abcdefgh"));
    }


    @Test
    void testCheckVoucherCodeIfDoesNotContain8NumericalCharacters(){
        assertFalse(checkVoucherCode("ESHOP1234567aaaa"));
        assertFalse(checkVoucherCode("ESHOP123456789aa"));
    }


    @Test
    void testIsStringEmpty(){
        assertFalse(isStringEmpty("a"));
    }

    @Test
    void testIsStringEmptyIfNull(){
        assertTrue(isStringEmpty(null));
    }

    @Test
    void testIsStringEmptyIfEmpty(){
        assertTrue(isStringEmpty(""));
    }


}