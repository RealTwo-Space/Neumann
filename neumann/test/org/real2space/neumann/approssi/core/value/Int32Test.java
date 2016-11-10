package org.real2space.neumann.approssi.core.value;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/01
 */
public class Int32Test {

    @Test
    public void constantValue() throws  Exception {
        Int32 zero = Int32.ZERO();
        zero.add (1);
        assertEquals(zero.getValue(), 1);
        assertEquals(Int32.ZERO().getValue(), 0);
    }

    @Test
    public void getValue() throws Exception {
        Int32 actual = new Int32(11);
        int expected = 11;
        boolean isSame = actual.getValue() == expected;
        assertTrue(isSame);
    }

    @Test
    public void opposite() throws Exception {
        Int32 val = new Int32(10);
        Int32 actual = val.opposite();
        Int32 expecteed = new Int32(-10);
        boolean isSame = actual.getValue() == expecteed.getValue();
        assertTrue(isSame);

    }

    @Test
    public void add() throws Exception {
        Int32 a = new Int32(10);
        Int32 b = new Int32(5);
        a.add (b);
        assertEquals(a.getValue(), 15);

        Int32 c = new Int32(10);
        c.add(5);
        assertEquals(c.getValue(), 15);

        Int32 d = Int32.add(10, 5);
        assertEquals(d.getValue(), 15);

        Int32 e = Int32.add(new Int32(10), new Int32(5));
        assertEquals(d.getValue(), 15);
    }

    @Test
    public void subtract() throws Exception {
        Int32 a = new Int32(10);
        a.subtract(new Int32(5));
        assertEquals(a.getValue(), 5);

        Int32 b = new Int32(10);
        b.subtract(5);
        assertEquals(b.getValue(), 5);

        Int32 c = Int32.subtract(new Int32(10), new Int32(5));
        assertEquals(c.getValue(), 5);

        Int32 d = Int32.subtract(10, 5);
        assertEquals(d.getValue(), 5);
    }

    @Test
    public void multiply() throws Exception {
        Int32 a = new Int32(10);
        a.multiply(new Int32(5));
        assertEquals(a.getValue(), 50);

        Int32 b = new Int32(10);
        b.multiply(5);
        assertEquals(b.getValue(), 50);

        Int32 c = Int32.multiply(new Int32(10), new Int32(5));
        assertEquals(c.getValue(), 50);

        Int32 d = Int32.multiply(10, 5);
        assertEquals(d.getValue(), 50);

    }

    @Test
    public void divide() throws Exception {
        Int32 a = new Int32(15);
        a.divide(new Int32(2));
        assertEquals(a.getValue(), 7);

        Int32 b = new Int32(15);
        b.divide(2);
        assertEquals(b.getValue(), 7);

        Int32 c = Int32.divide(new Int32(15), new Int32(2));
        assertEquals(c.getValue(), 7);

        Int32 d = Int32.divide(15, 2);
        assertEquals(d.getValue(), 7);

    }

    @Test
    public void mod() throws Exception {
        Int32 a = new Int32(99);
        a.mod(new Int32(30));
        assertEquals(a.getValue(), 9);

        Int32 b = new Int32(99);
        b.mod(30);
        assertEquals(b.getValue(), 9);

        Int32 c = Int32.mod(new Int32(99), new Int32(30));
        assertEquals(c.getValue(), 9);

        Int32 d = Int32.mod(99, 30);
        assertEquals(d.getValue(), 9);

    }

    @Test
    public void pow() throws Exception {
        Int32 a = new Int32(2);
        a.pow(10);
        assertEquals(a.getValue(), 1024);

        Int32 b = new Int32(2);
        b.pow(10);
        assertEquals(b.getValue(), 1024);

        Int32 c = Int32.pow(new Int32(2), new Int32(10));
        assertEquals(c.getValue(), 1024);

        Int32 d = Int32.pow(2, 10);
        assertEquals(d.getValue(), 1024);

        try {
            Int32 e = new Int32(2);
            e.pow(new Int32(-2));
            fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void isET() throws Exception {
        Int32 a = new Int32(100);
        Int32 b = new Int32(999);
        Int32 c = new Int32(100);

        assertFalse(a.isET(b));
        assertFalse(a.isET(999));
        assertFalse(Int32.isET(a, b));
        assertFalse(Int32.isET(100,999));
        assertTrue(a.isET(c));
        assertTrue(a.isET(100));
        assertTrue(Int32.isET(a, c));
        assertTrue(Int32.isET(100, 100));
    }

    @Test
    public void isGT() throws Exception {
        Int32 a = new Int32(100);
        Int32 b = new Int32(999);
        Int32 c = new Int32(90);

        assertFalse(a.isGT(b));
        assertFalse(a.isGT(999));
        assertFalse(Int32.isGT(a, b));
        assertFalse(Int32.isGT(100,999));
        assertTrue(a.isGT(c));
        assertTrue(a.isGT(90));
        assertTrue(Int32.isGT(a, c));
        assertTrue(Int32.isGT(100, 90));
    }

    @Test
    public void isGE() throws Exception {
        Int32 a = new Int32(100);
        Int32 b = new Int32(999);
        Int32 c = new Int32(100);

        assertFalse(a.isGE(b));
        assertFalse(a.isGE(999));
        assertFalse(Int32.isGE(a, b));
        assertFalse(Int32.isGE(100,999));
        assertTrue(a.isGE(c));
        assertTrue(a.isGE(100));
        assertTrue(Int32.isGE(a, c));
        assertTrue(Int32.isGE(100, 100));
    }

    @Test
    public void isLT() throws Exception {
        Int32 a = new Int32(100);
        Int32 b = new Int32(90);
        Int32 c = new Int32(999);

        assertFalse(a.isLT(b));
        assertFalse(a.isLT(90));
        assertFalse(Int32.isLT(a, b));
        assertFalse(Int32.isLT(100,90));
        assertTrue(a.isLT(c));
        assertTrue(a.isLT(999));
        assertTrue(Int32.isLT(a, c));
        assertTrue(Int32.isLT(100, 999));
    }

    @Test
    public void isLE() throws Exception {
        Int32 a = new Int32(100);
        Int32 b = new Int32(90);
        Int32 c = new Int32(100);

        assertFalse(a.isLE(b));
        assertFalse(a.isLE(90));
        assertFalse(Int32.isLE(a, b));
        assertFalse(Int32.isLE(100,90));
        assertTrue(a.isLE(c));
        assertTrue(a.isLE(100));
        assertTrue(Int32.isLE(a, c));
        assertTrue(Int32.isLE(100, 100));
    }

    @Test
    public void deepCopy() throws Exception {
        Int32 a = new Int32(100);
        Int32 b = a.clone();

        assertEquals(a.getValue(), b.getValue());

        a.add (10);

        assertFalse(Int32.isET(a, b));
    }

    @Test
    public void outputString() throws Exception {
        Int32 a = new Int32(10);
        assertEquals(a.toString(), "10(Int32)");
    }

}