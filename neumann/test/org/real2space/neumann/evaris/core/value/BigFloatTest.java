package org.real2space.neumann.evaris.core.value;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 11/9/16
 */
public class BigFloatTest {
    @Test
    public void testConstantValues() throws Exception {
        BigFloat zero = BigFloat.ZERO();
        BigFloat one = BigFloat.ONE();
        BigFloat negone = BigFloat.NEGATIVE_ONE();

        zero.add (new BigFloat("1"));

        assertFalse(zero.isET("0"));
        assertTrue (zero.isET(one));
        assertTrue (negone.isET(negone));
    }


    @Test
    public void getValue() throws Exception {
        BigFloat actual = new BigFloat("11.0000101001010");
        BigDecimal expected = new BigDecimal("11.0000101001010");
        assertTrue(actual.isET(expected));
    }


    @Test
    public void opposite() throws Exception {
        BigFloat value = new BigFloat ("0.3");
        BigFloat actual = value.opposite();
        BigFloat expected = new BigFloat ("-0.3");

        assertTrue(actual.isET(expected));
    }


    @Test
    public void inverse() throws Exception {
        /*
        BigFloat value1 = new BigFloat (0.12);
        BigFloat actual1 = value1.inverse();
        BigFloat expected1 = new BigFloat (8.3333333333333333);

        assertEquals (actual1.getValue(), expected1.getValue(), 0.0000000001);
        */
    }



    @Test
    public void add() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("0.000000000000001");
        BigFloat val3 = new BigFloat ("-0.4");
        BigFloat val4 = new BigFloat ("0.5");

        val1.add(new BigFloat("-2"));
        assertTrue (val1.isET("-2.0"));

        val2.add(new BigDecimal ("0.5"));
        assertTrue(val2.isET("0.500000000000001"));

        val2.add("1");
        assertTrue(val2.isET("1.500000000000001"));

        BigFloat val5 = BigFloat.add(val3, val4);
        assertTrue (val5.isET("0.1"));

        BigFloat val6 = BigFloat.add(new BigDecimal("1"), new BigDecimal("0.00001"));
        assertTrue(val6.isET("1.00001"));

        BigFloat val7 = BigFloat.add("10.5", "-4.245");
        assertTrue(val7.isET("6.255"));
    }


    @Test
    public void subtract() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("0.000000000000001");
        BigFloat val3 = new BigFloat ("-0.4");
        BigFloat val4 = new BigFloat ("0.5");

        val1.subtract(new BigFloat("-2"));
        assertTrue (val1.isET("2.0"));

        val2.subtract(new BigDecimal ("0.5"));
        assertTrue(val2.isET("-0.499999999999999"));

        val2.subtract("1");
        assertTrue(val2.isET("-1.499999999999999"));

        BigFloat val5 = BigFloat.subtract(val3, val4);
        assertTrue (val5.isET("-0.9"));

        BigFloat val6 = BigFloat.subtract(new BigDecimal("1"), new BigDecimal("0.00001"));
        assertTrue(val6.isET("0.99999"));

        BigFloat val7 = BigFloat.subtract("10.5", "-4.245");
        assertTrue(val7.isET("14.745"));
    }


    @Test
    public void multiply() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("1.5");
        BigFloat val3 = new BigFloat ("-0.4");
        BigFloat val4 = new BigFloat ("0.5");

        val1.multiply(new BigFloat("-2"));
        assertTrue (val1.isET("0"));

        val2.multiply(new BigDecimal ("0.5"));
        assertTrue(val2.isET("0.75"));

        val2.multiply("1");
        assertTrue(val2.isET("0.75"));

        BigFloat val5 = BigFloat.multiply(val3, val4);
        assertTrue (val5.isET("-0.2"));

        BigFloat val6 = BigFloat.multiply(new BigDecimal("1"), new BigDecimal("0.00001"));
        assertTrue(val6.isET("0.00001"));

        BigFloat val7 = BigFloat.multiply("10.5", "-4.245");
        assertTrue(val7.isET("-44.5725"));
    }


    @Test
    public void divide() throws Exception {

    }


    @Test
    public void negativeModTest () throws Exception {

    }


    @Test
    public void mod() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("0.000000000000001");
        BigFloat val3 = new BigFloat ("0.12");
        BigFloat val4 = new BigFloat ("0.345");

        val1.mod(new BigFloat("22"));
        assertTrue (val1.isET("0"));

        val2.mod(new BigDecimal ("0.5"));
        assertTrue(val2.isET("0.000000000000001"));

        val2.mod("2.4");
        assertTrue(val2.isET("0.000000000000001"));

        BigFloat val5 = BigFloat.mod(val3, val4);
        assertTrue (val5.isET("0.12"));

        BigFloat val6 = BigFloat.mod(new BigDecimal("1"), new BigDecimal("0.00001"));
        assertTrue(val6.isET("0"));

        BigFloat val7 = BigFloat.mod("10.5", "4.245");
        assertTrue(val7.isET("2.01"));
    }
    /*
    @Test
    public void pow() throws Exception {
        BigFloat val1 = new BigFloat (0.12);
        BigFloat val2 = new BigFloat (0.555);
        BigFloat val3 = new BigFloat (1.02);
        BigFloat val4 = new BigFloat (0);

        val1.pow(new BigFloat(2));
        assertEquals (val1.getValue(), 0.0144, 0.0000000001);

        val2.pow(0.442);
        assertEquals(val2.getValue(), 0.7708635284141141, 0.0000000001);

        BigFloat val5 = BigFloat.pow(val3, val4);
        assertEquals(val5.getValue(), 1, 0.0000000001);

        BigFloat val6 = BigFloat.pow(0, 0);
        assertEquals(val6.getValue(), 1, 0.0000000001);
    }
    */

    @Test
    public void isET() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("0.000000000000001");

        assertFalse (val1.isET(val2));
        assertTrue (val1.isET(new BigDecimal("0")));
        assertTrue (val2.isET("0.000000000000001"));
        assertFalse (BigFloat.isET(val1, val2));
        assertTrue (BigFloat.isET(new BigDecimal("1.0"), new BigDecimal("1")));
        assertFalse (BigFloat.isET("0.0000000000000000000000001", "0"));
    }


    @Test
    public void isGT() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("0.000000000000001");

        assertFalse (val1.isGT(val2));
        assertFalse (val1.isGT(new BigDecimal("0")));
        assertFalse (val2.isGT("0.000000000000001"));
        assertTrue (BigFloat.isGT(val2, val1));
        assertFalse (BigFloat.isGT(new BigDecimal("1.0"), new BigDecimal("1")));
        assertTrue (BigFloat.isGT("0.0000000000000000000000001", "0"));
    }


    @Test
    public void isGE() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("0.000000000000001");

        assertFalse (val1.isGE(val2));
        assertTrue (val1.isGE(new BigDecimal("0")));
        assertTrue (val2.isGE("0.000000000000001"));
        assertTrue (BigFloat.isGE(val2, val1));
        assertTrue (BigFloat.isGE(new BigDecimal("1.0"), new BigDecimal("1")));
        assertTrue (BigFloat.isGE("0.0000000000000000000000001", "0"));
    }


    @Test
    public void isLT() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("0.000000000000001");

        assertTrue (val1.isLT(val2));
        assertFalse (val1.isLT(new BigDecimal("0")));
        assertFalse (val2.isLT("0.000000000000001"));
        assertFalse (BigFloat.isLT(val2, val1));
        assertFalse (BigFloat.isLT(new BigDecimal("1.0"), new BigDecimal("1")));
        assertTrue (BigFloat.isLT("-0.0000000000000000000000001", "0"));
    }


    @Test
    public void isLE() throws Exception {
        BigFloat val1 = new BigFloat ("0");
        BigFloat val2 = new BigFloat ("0.000000000000001");

        assertTrue (val1.isLE(val2));
        assertTrue (val1.isLE(new BigDecimal("0")));
        assertTrue (val2.isLE("0.000000000000001"));
        assertFalse (BigFloat.isLE(val2, val1));
        assertTrue (BigFloat.isLE(new BigDecimal("1.0"), new BigDecimal("1")));
        assertFalse (BigFloat.isLE("0.0000000000000000000000001", "0"));
    }


    @Test
    public void deepCopyTest () throws Exception {
        BigFloat val1 = new BigFloat ("1.0");
        BigFloat val2 = val1.clone();

        assertTrue (val1.isET(val2));
        assertNotEquals(val1, val2);
    }


    @Test
    public void stringTest () throws Exception {
        BigFloat val = new BigFloat ("1.0");

        assertEquals(val.toString(), "1.0(BigFloat)");
    }

}