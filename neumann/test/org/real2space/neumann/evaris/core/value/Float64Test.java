package org.real2space.neumann.evaris.core.value;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 11/8/16
 */
public class Float64Test {
    @Test
    public void testConstantValues() throws Exception {
        Float64 zero = Float64.ZERO();
        zero.add (1.0);
        assertEquals(zero.getValue(), 1.0, 0.0000000001);
        assertEquals(Float64.ZERO().getValue(), 0, 0.0000000001);
    }

    @Test
    public void infinityTest () throws Exception {
        Float64 infty = Float64.POSITIVE_INFINITY();
        Float64 neginfty = Float64.NEGATIVE_INFINITY();

        assertTrue(infty.isET(Double.POSITIVE_INFINITY));
        assertTrue(neginfty.isET(Double.NEGATIVE_INFINITY));
    }

    @Test
    public void nanTest () throws Exception {
        Float64 nan = Float64.NaN();

        assertTrue(new Double(nan.getValue()).isNaN());
    }

    @Test
    public void getValue() throws Exception {
        Float64 actual = new Float64(11.0);
        double expected = 11;
        assertEquals(actual.getValue(), expected, 0.0000000001);
    }

    @Test
    public void opposite() throws Exception {
        Float64 value = new Float64 (0.3);
        Float64 actual = value.opposite();
        Float64 expected = new Float64 (-0.3);

        assertEquals(actual.getValue(), expected.getValue(), 0.0000000001);
    }

    @Test
    public void inverse() throws Exception {
        Float64 value1 = new Float64 (0.12);
        Float64 actual1 = value1.inverse();
        Float64 expected1 = new Float64 (8.3333333333333333);

        assertEquals (actual1.getValue(), expected1.getValue(), 0.0000000001);
    }

    @Test
    public void add() throws Exception {
        Float64 val1 = new Float64 (0);
        Float64 val2 = new Float64 (0.000000000000001);
        Float64 val3 = new Float64 (-0.4);
        Float64 val4 = new Float64 (0.5);

        val1.add(new Float64(-2));
        assertEquals (val1.getValue(), -2, 0.0000000001);

        val2.add(1);
        assertEquals(val2.getValue(), 1, 0.0000000001);

        Float64 val5 = Float64.add(val3, val4);
        assertEquals(val5.getValue(), 0.1, 0.0000000001);

        Float64 val6 = Float64.add(0.1, 0.05);
        assertEquals(val6.getValue(), 0.15, 0.0000000001);
    }

    @Test
    public void subtract() throws Exception {
        Float64 val1 = new Float64 (0);
        Float64 val2 = new Float64 (0.000000000000001);
        Float64 val3 = new Float64 (-0.4);
        Float64 val4 = new Float64 (-0.5);

        val1.subtract(new Float64(-2));
        assertEquals (val1.getValue(), 2, 0.0000000001);

        val2.subtract(-1);
        assertEquals(val2.getValue(), 1, 0.0000000001);

        Float64 val5 = Float64.subtract(val3, val4);
        assertEquals(val5.getValue(), 0.1, 0.0000000001);

        Float64 val6 = Float64.subtract(0.1, -0.05);
        assertEquals(val6.getValue(), 0.15, 0.0000000001);
    }

    @Test
    public void multiply() throws Exception {
        Float64 val1 = new Float64 (0);
        Float64 val2 = new Float64 (0.000000000000001);
        Float64 val3 = new Float64 (-0.4);
        Float64 val4 = new Float64 (-0.5);

        val1.multiply(new Float64(-2));
        assertEquals (val1.getValue(), 0, 0.0000000001);

        val2.multiply(-1);
        assertEquals(val2.getValue(), 0, 0.0000000001);

        Float64 val5 = Float64.multiply(val3, val4);
        assertEquals(val5.getValue(), 0.2, 0.0000000001);

        Float64 val6 = Float64.multiply(0.1, -0.05);
        assertEquals(val6.getValue(), -0.005, 0.0000000001);
    }

    @Test
    public void divide() throws Exception {
        Float64 val1 = new Float64 (0);
        Float64 val2 = new Float64 (0.000000000000001);
        Float64 val3 = new Float64 (-0.4);
        Float64 val4 = new Float64 (-0.5);

        val1.divide(new Float64(-2));
        assertEquals (val1.getValue(), 0, 0.0000000001);

        val2.divide(-1);
        assertEquals(val2.getValue(), -1.0E-15, 0.0000000001);

        Float64 val5 = Float64.divide(val3, val4);
        assertEquals(val5.getValue(), 0.8, 0.0000000001);

        Float64 val6 = Float64.divide(0.1, -0.05);
        assertEquals(val6.getValue(), -2, 0.0000000001);
    }

    /*
    @Test
    public void negativeModTest () throws Exception {

    }
    */

    @Test
    public void mod() throws Exception {
        Float64 val1 = new Float64 (0.12);
        Float64 val2 = new Float64 (0.555);
        Float64 val3 = new Float64 (1.02);
        Float64 val4 = new Float64 (0);

        val1.mod(new Float64(2));
        assertEquals (val1.getValue(), 0.12, 0.0000000001);

        val2.mod(0.442);
        assertEquals(val2.getValue(), 0.113, 0.0000000001);

        Float64 val5 = Float64.mod(val3, val4);
        assertEquals(val5.getValue(), Double.NaN, 0.0000000001);

        Float64 val6 = Float64.mod(0.1, 0.05);
        assertEquals(val6.getValue(), 0, 0.0000000001);
    }

    @Test
    public void pow() throws Exception {
        Float64 val1 = new Float64 (0.12);
        Float64 val2 = new Float64 (0.555);
        Float64 val3 = new Float64 (1.02);
        Float64 val4 = new Float64 (0);

        val1.pow(new Float64(2));
        assertEquals (val1.getValue(), 0.0144, 0.0000000001);

        val2.pow(0.442);
        assertEquals(val2.getValue(), 0.7708635284141141, 0.0000000001);

        Float64 val5 = Float64.pow(val3, val4);
        assertEquals(val5.getValue(), 1, 0.0000000001);

        Float64 val6 = Float64.pow(0, 0);
        assertEquals(val6.getValue(), 1, 0.0000000001);
    }

    @Test
    public void isET() throws Exception {
        // check for E, infty, NaN
        Float64 val1 = new Float64(0.01 / 2);
        Float64 val2 = new Float64(0.005);
        Float64 val3 = new Float64(Double.POSITIVE_INFINITY);
        Float64 val4 = new Float64(Double.NEGATIVE_INFINITY);
        Float64 val5 = new Float64(Double.NaN);

        assertTrue (val1.isET (val2));
        assertFalse (val2.isET(0.0049));
        assertFalse (Float64.isET(val3, val4));
        assertFalse (Float64.isET (1.0, 1.0000001));
    }

    @Test
    public void isGT() throws Exception {
        Float64 val1 = new Float64 (1.0);
        Float64 val2 = new Float64 (3.0);

        assertFalse (val1.isGT (val1));
        assertTrue (val2.isGT (-5.0));
        assertFalse (Float64.isGT(val1, val2));
        assertTrue (Float64.isGT(Double.POSITIVE_INFINITY, Double.MAX_VALUE));
    }

    @Test
    public void isGE() throws Exception {
        Float64 val1 = new Float64 (1.0);
        Float64 val2 = new Float64 (3.0);

        assertTrue (val1.isGE (val1));
        assertTrue (val2.isGE (-5.0));
        assertFalse (Float64.isGE (val1, val2));
        assertTrue (Float64.isGE (Double.POSITIVE_INFINITY, Double.MAX_VALUE));
    }

    @Test
    public void isLT() throws Exception {
        Float64 val1 = new Float64 (1.0);
        Float64 val2 = new Float64 (3.0);

        assertFalse (val1.isLT (val1));
        assertFalse (val2.isLT (-5.0));
        assertTrue (Float64.isLT (val1, val2));
        assertFalse (Float64.isLT (Double.POSITIVE_INFINITY, Double.MAX_VALUE));
    }

    @Test
    public void isLE() throws Exception {
        Float64 val1 = new Float64 (1.0);
        Float64 val2 = new Float64 (3.0);

        assertTrue (val1.isLE (val1));
        assertFalse (val2.isLE (-5.0));
        assertTrue (Float64.isLE (val1, val2));
        assertFalse (Float64.isLE (Double.POSITIVE_INFINITY, Double.MAX_VALUE));
    }

    @Test
    public void deepCopyTest () throws Exception {
        Float64 val1 = new Float64 (1.0);
        Float64 val2 = val1.clone();

        assertTrue (val1.isET(val2));
        assertNotEquals(val1, val2);
    }

    @Test
    public void stringTest () throws Exception {
        Float64 val = new Float64 (1);

        assertEquals(val.toString(), "1.0(Float64)");
    }
}