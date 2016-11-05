package org.real2space.neumann.approssi.core.value;

import static org.junit.Assert.*;
import org.junit.*;
/**
 * @author Ryosuke Suzuki
 * @author Ryu Fujiwara
 * @version 0.0
 * @created 2016/11/05
 * @see None
 * @since 0.0
 */
public class Int64Test {
    @Test
    public void constantValue() throws  Exception {
        Int64 zero = Int64.ZERO();
        zero.add (1l);
        assertEquals(zero.getValue(), 1l);
        assertEquals(Int64.ZERO().getValue(), 0l);
    }

    @Test
    public void getValue() throws Exception {
        Int64 actual = new Int64(11l);
        long expected = 1l;
        boolean isSame = actual.getValue() == expected;
        assertTrue(isSame);
    }

    @Test
    public void opposite() throws Exception {
        Int64 val = new Int64(10l);
        Int64 actual = val.opposite();
        Int64 expecteed = new Int64(-10l);
        boolean isSame = actual.getValue() == expecteed.getValue();
        assertTrue(isSame);

    }

    @Test
    public void add() throws Exception {
        Int64 a = new Int64(10l);
        Int64 b = new Int64(5l);
        a.add (b);
        assertEquals(a.getValue(), 15l);

        Int64 c = new Int64(10l);
        c.add(5l);
        assertEquals(c.getValue(), 15l);

        Int64 d = Int64.add(10l, 5l);
        assertEquals(d.getValue(), 15l);

        Int64 e = Int64.add(new Int64(10l), new Int64(5l));
        assertEquals(d.getValue(), 15l);
    }

    @Test
    public void subtract() throws Exception {
        Int64 a = new Int64(10l);
        a.subtract(new Int64(5l));
        assertEquals(a.getValue(), 5l);

        Int64 b = new Int64(10l);
        b.subtract(5l);
        assertEquals(b.getValue(), 5l);

        Int64 c = Int64.subtract(new Int64(10l), new Int64(5l));
        assertEquals(c.getValue(), 5l);

        Int64 d = Int64.subtract(10l, 5l);
        assertEquals(d.getValue(), 5l);
    }

    @Test
    public void multiply() throws Exception {
        Int64 a = new Int64(10l);
        a.multiply(new Int64(5l));
        assertEquals(a.getValue(), 50l);

        Int64 b = new Int64(10l);
        b.multiply(5l);
        assertEquals(b.getValue(), 50l);

        Int64 c = Int64.multiply(new Int64(10l), new Int64(5l));
        assertEquals(c.getValue(), 50l);

        Int64 d = Int64.multiply(10l, 5l);
        assertEquals(d.getValue(), 50l);

    }

    @Test
    public void divide() throws Exception {
        Int64 a = new Int64(15l);
        a.divide(new Int64(2l));
        assertEquals(a.getValue(), 7l);

        Int64 b = new Int64(15l);
        b.divide(2l);
        assertEquals(b.getValue(), 7l);

        Int64 c = Int64.divide(new Int64(15l), new Int64(2l));
        assertEquals(c.getValue(), 7l);

        Int64 d = Int64.divide(15l, 2l);
        assertEquals(d.getValue(), 7l);

    }

    @Test
    public void mod() throws Exception {
        Int64 a = new Int64(99l);
        a.mod(new Int64(30l));
        assertEquals(a.getValue(), 9l);

        Int64 b = new Int64(99l);
        b.mod(30l);
        assertEquals(b.getValue(), 9l);

        Int64 c = Int64.mod(new Int64(99l), new Int64(30l));
        assertEquals(c.getValue(), 9l);

        Int64 d = Int64.mod(99l, 30l);
        assertEquals(d.getValue(), 9l);

    }

    @Test
    public void pow() throws Exception {
        Int64 a = new Int64(2l);
        a.pow(10l);
        assertEquals(a.getValue(), 1024l);

        Int64 b = new Int64(2l);
        b.pow(10l);
        assertEquals(b.getValue(), 1024l);

        Int64 c = Int64.pow(new Int64(2l), new Int64(10l));
        assertEquals(c.getValue(), 1024l);

        Int64 d = Int64.pow(2l, 10l);
        assertEquals(d.getValue(), 1024l);

        try {
            Int64 e = new Int64(2l);
            e.pow(new Int64(-2l));
            fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void isET() throws Exception {
        Int64 a = new Int64(100l);
        Int64 b = new Int64(999l);
        Int64 c = new Int64(100l);

        assertFalse(a.isET(b));
        assertFalse(a.isET(999l));
        assertFalse(Int64.isET(a, b));
        assertFalse(Int64.isET(100l,999l));
        assertTrue(a.isET(c));
        assertTrue(a.isET(100l));
        assertTrue(Int64.isET(a, c));
        assertTrue(Int64.isET(100l, 100l));
    }

    @Test
    public void isGT() throws Exception {
        Int64 a = new Int64(100l);
        Int64 b = new Int64(999l);
        Int64 c = new Int64(90l);

        assertFalse(a.isGT(b));
        assertFalse(a.isGT(999l));
        assertFalse(Int64.isGT(a, b));
        assertFalse(Int64.isGT(100l,999l));
        assertTrue(a.isGT(c));
        assertTrue(a.isGT(90l));
        assertTrue(Int64.isGT(a, c));
        assertTrue(Int64.isGT(100l, 90l));
    }

    @Test
    public void isGE() throws Exception {
        Int64 a = new Int64(100l);
        Int64 b = new Int64(999l);
        Int64 c = new Int64(100l);

        assertFalse(a.isGE(b));
        assertFalse(a.isGE(999l));
        assertFalse(Int64.isGE(a, b));
        assertFalse(Int64.isGE(100l,999l));
        assertTrue(a.isGE(c));
        assertTrue(a.isGE(100l));
        assertTrue(Int64.isGE(a, c));
        assertTrue(Int64.isGE(100l, 100l));
    }

    @Test
    public void isLT() throws Exception {
        Int64 a = new Int64(100l);
        Int64 b = new Int64(90l);
        Int64 c = new Int64(999l);

        assertFalse(a.isLT(b));
        assertFalse(a.isLT(90l));
        assertFalse(Int64.isLT(a, b));
        assertFalse(Int64.isLT(100l,90l));
        assertTrue(a.isLT(c));
        assertTrue(a.isLT(999l));
        assertTrue(Int64.isLT(a, c));
        assertTrue(Int64.isLT(100l, 999l));
    }

    @Test
    public void isLE() throws Exception {
        Int64 a = new Int64(100l);
        Int64 b = new Int64(90l);
        Int64 c = new Int64(100l);

        assertFalse(a.isLE(b));
        assertFalse(a.isLE(90l));
        assertFalse(Int64.isLE(a, b));
        assertFalse(Int64.isLE(100l,90l));
        assertTrue(a.isLE(c));
        assertTrue(a.isLE(100l));
        assertTrue(Int64.isLE(a, c));
        assertTrue(Int64.isLE(100l, 100l));
    }

    @Test
    public void deepCopy() throws Exception {
        Int64 a = new Int64(100l);
        Int64 b = a.clone();

        assertEquals(a.getValue(), b.getValue());

        a.add (10l);

        assertFalse(Int64.isET(a, b));
    }

    @Test
    public void outputString() throws Exception {
        Int64 a = new Int64(10);
        assertEquals(a.toString(), "10(Int64)");
    }


}