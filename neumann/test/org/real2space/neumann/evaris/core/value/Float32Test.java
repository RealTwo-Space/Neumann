package org.real2space.neumann.evaris.core.value;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 11/9/16
 */
public class Float32Test {
    @Test
    public void testConstantValues() throws Exception {
        Float32 zero = Float32.ZERO();
        zero.add (1.0f);
        assertEquals(zero.getValue(), 1.0f, 0.0000001f);
        assertEquals(Float32.ZERO().getValue(), 0f, 0.0000001f);
    }

    @Test
    public void infinityTest () throws Exception {
        Float32 infty = Float32.POSITIVE_INFINITY();
        Float32 neginfty = Float32.NEGATIVE_INFINITY();

        assertTrue(infty.isET(Float.POSITIVE_INFINITY));
        assertTrue(neginfty.isET(Float.NEGATIVE_INFINITY));
    }

    @Test
    public void nanTest () throws Exception {
        Float32 nan = Float32.NaN();

        assertTrue(new Float(nan.getValue()).isNaN());
    }

    @Test
    public void getValue() throws Exception {
        Float32 actual = new Float32(11.0f);
        double expected = 11f;
        assertEquals(actual.getValue(), expected, 0.0000001f);
    }

    @Test
    public void opposite() throws Exception {
        Float32 value = new Float32 (0.3f);
        Float32 actual = value.opposite();
        Float32 expected = new Float32 (-0.3f);

        assertEquals(actual.getValue(), expected.getValue(), 0.0000001f);
    }

    @Test
    public void inverse() throws Exception {
        Float32 value1 = new Float32 (0.12f);
        Float32 actual1 = value1.inverse();
        Float32 expected1 = new Float32 (8.333333f);

        assertEquals (actual1.getValue(), expected1.getValue(), 0.001f);
    }

    @Test
    public void add() throws Exception {
        Float32 val1 = new Float32 (0f);
        Float32 val2 = new Float32 (0.0000001f);
        Float32 val3 = new Float32 (-0.4f);
        Float32 val4 = new Float32 (0.5f);

        val1.add(new Float32(-2f));
        assertEquals (val1.getValue(), -2f, 0.0000001f);

        val2.add(1f);
        assertEquals(val2.getValue(), 1f, 0.001f);

        Float32 val5 = Float32.add(val3, val4);
        assertEquals(val5.getValue(), 0.1f, 0.0000001f);

        Float32 val6 = Float32.add(0.1f, 0.05f);
        assertEquals(val6.getValue(), 0.15f, 0.0000001f);
    }

    @Test
    public void subtract() throws Exception {
        Float32 val1 = new Float32 (0f);
        Float32 val2 = new Float32 (0.0000001f);
        Float32 val3 = new Float32 (-0.4f);
        Float32 val4 = new Float32 (-0.5f);

        val1.subtract(new Float32(-2f));
        assertEquals (val1.getValue(), 2f, 0.0000001f);

        val2.subtract(-1f);
        assertEquals(val2.getValue(), 1f, 0.001f);

        Float32 val5 = Float32.subtract(val3, val4);
        assertEquals(val5.getValue(), 0.1f, 0.0000001f);

        Float32 val6 = Float32.subtract(0.1f, -0.05f);
        assertEquals(val6.getValue(), 0.15f, 0.00000001f);
    }

    @Test
    public void multiply() throws Exception {
        Float32 val1 = new Float32 (0f);
        Float32 val2 = new Float32 (0.0000001f);
        Float32 val3 = new Float32 (-0.4f);
        Float32 val4 = new Float32 (-0.5f);

        val1.multiply(new Float32(-2f));
        assertEquals (val1.getValue(), 0f, 0.0000001f);

        val2.multiply(-1f);
        assertEquals(val2.getValue(), 0f, 0.0000001f);

        Float32 val5 = Float32.multiply(val3, val4);
        assertEquals(val5.getValue(), 0.2f, 0.0000001f);

        Float32 val6 = Float32.multiply(0.1f, -0.05f);
        assertEquals(val6.getValue(), -0.005f, 0.0000001f);
    }

    @Test
    public void divide() throws Exception {
        Float32 val1 = new Float32 (0f);
        Float32 val2 = new Float32 (0.0000001f);
        Float32 val3 = new Float32 (-0.4f);
        Float32 val4 = new Float32 (-0.5f);

        val1.divide(new Float32(-2f));
        assertEquals (val1.getValue(), 0f, 0.0000001f);

        val2.divide(-1f);
        assertEquals(val2.getValue(), -1.0E-15f, 0.0000001f);

        Float32 val5 = Float32.divide(val3, val4);
        assertEquals(val5.getValue(), 0.8f, 0.0000001f);

        Float32 val6 = Float32.divide(0.1f, -0.05f);
        assertEquals(val6.getValue(), -2f, 0.00000001f);
    }

    /*
    @Test
    public void negativeModTest () throws Exception {

    }
    */

    @Test
    public void mod() throws Exception {
        Float32 val1 = new Float32 (0.12f);
        Float32 val2 = new Float32 (0.555f);
        Float32 val3 = new Float32 (1.02f);
        Float32 val4 = new Float32 (0f);

        val1.mod(new Float32(2f));
        assertEquals (val1.getValue(), 0.12f, 0.0000001f);

        val2.mod(0.442f);
        assertEquals(val2.getValue(), 0.113f, 0.0000001f);

        Float32 val5 = Float32.mod(val3, val4);
        assertEquals(val5.getValue(), Float.NaN, 0.0000001f);

        Float32 val6 = Float32.mod(0.1f, 0.05f);
        assertEquals(val6.getValue(), 0f, 0.0000001f);
    }

    @Test
    public void pow() throws Exception {
        Float32 val1 = new Float32 (0.12f);
        Float32 val2 = new Float32 (0.555f);
        Float32 val3 = new Float32 (1.02f);
        Float32 val4 = new Float32 (0f);

        val1.pow(new Float32(2f));
        assertEquals (val1.getValue(), 0.0144f, 0.0000001f);

        val2.pow(0.442f);
        assertEquals(val2.getValue(), 0.7708635284141141f, 0.0000001f);

        Float32 val5 = Float32.pow(val3, val4);
        assertEquals(val5.getValue(), 1f, 0.0000001f);

        Float32 val6 = Float32.pow(0f, 0f);
        assertEquals(val6.getValue(), 1f, 0.0000000001f);
    }

    @Test
    public void isET() throws Exception {
        // check for E, infty, NaN
        Float32 val1 = new Float32(0.01f / 2f);
        Float32 val2 = new Float32(0.005f);
        Float32 val3 = new Float32(Float.POSITIVE_INFINITY);
        Float32 val4 = new Float32(Float.NEGATIVE_INFINITY);
        Float32 val5 = new Float32(Float.NaN);

        assertTrue (val1.isET (val2));
        assertFalse (val2.isET(0.0049f));
        assertFalse (Float32.isET(val3, val4));
        assertFalse (Float32.isET (1.0f, 1.0000001f));
    }

    @Test
    public void isGT() throws Exception {
        Float32 val1 = new Float32 (1.0f);
        Float32 val2 = new Float32 (3.0f);

        assertFalse (val1.isGT (val1));
        assertTrue (val2.isGT (-5.0f));
        assertFalse (Float32.isGT(val1, val2));
        assertTrue (Float32.isGT(Float.POSITIVE_INFINITY, Float.MAX_VALUE));
    }

    @Test
    public void isGE() throws Exception {
        Float32 val1 = new Float32 (1.0f);
        Float32 val2 = new Float32 (3.0f);

        assertTrue (val1.isGE (val1));
        assertTrue (val2.isGE (-5.0f));
        assertFalse (Float32.isGE (val1, val2));
        assertTrue (Float32.isGE (Float.POSITIVE_INFINITY, Float.MAX_VALUE));
    }

    @Test
    public void isLT() throws Exception {
        Float32 val1 = new Float32 (1.0f);
        Float32 val2 = new Float32 (3.0f);

        assertFalse (val1.isLT (val1));
        assertFalse (val2.isLT (-5.0f));
        assertTrue (Float32.isLT (val1, val2));
        assertFalse (Float32.isLT (Float.POSITIVE_INFINITY, Float.MAX_VALUE));
    }

    @Test
    public void isLE() throws Exception {
        Float32 val1 = new Float32 (1.0f);
        Float32 val2 = new Float32 (3.0f);

        assertTrue (val1.isLE (val1));
        assertFalse (val2.isLE (-5.0f));
        assertTrue (Float32.isLE (val1, val2));
        assertFalse (Float32.isLE (Float.POSITIVE_INFINITY, Float.MAX_VALUE));
    }

    @Test
    public void deepCopyTest () throws Exception {
        Float32 val1 = new Float32 (1.0f);
        Float32 val2 = val1.clone();

        assertTrue (val1.isET(val2));
        assertNotEquals(val1, val2);
    }

    @Test
    public void stringTest () throws Exception {
        Float32 val = new Float32 (1f);

        assertEquals(val.toString(), "1.0(Float32)");
    }
}