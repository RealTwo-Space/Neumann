package org.real2space.neumann.approssi.core.value;

import static org.junit.Assert.*;

import org.junit.*;
import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/08
 */
public class Int16Test {

    @Test
    public void constantValue() throws  Exception {
        Int16 zero = Int16.ZERO();
        zero.add ((short)1);
        assertEquals(zero.getValue(), (short)1);
        assertEquals(Int16.ZERO().getValue(), (short)0);
    }

    @Test
    public void getValue() throws Exception {
        Int16 actual = new Int16((short)11);
        short expected = (short)11;
        boolean isSame = actual.getValue() == expected;
        assertTrue(isSame);
    }

    @Test
    public void opposite() throws Exception {
        Int16 val = new Int16((short)10);
        Int16 actual = val.opposite();
        Int16 expecteed = new Int16((short)-10);
        boolean isSame = actual.getValue() == expecteed.getValue();
        assertTrue(isSame);

    }

    @Test
    public void add() throws Exception {
        Int16 a = new Int16((short)10);
        Int16 b = new Int16((short)5);
        a.add (b);
        assertEquals(a.getValue(), (short)15);

        Int16 c = new Int16((short)10);
        c.add((short)5);
        assertEquals(c.getValue(), (short)15);

        Int16 d = Int16.add((short)10, (short)5);
        assertEquals(d.getValue(), (short)15);

        Int16 e = Int16.add(new Int16((short)10), new Int16((short)5));
        assertEquals(d.getValue(), (short)15);
    }

    @Test
    public void subtract() throws Exception {
        Int16 a = new Int16((short)10);
        a.subtract(new Int16((short)5));
        assertEquals(a.getValue(), (short)5);

        Int16 b = new Int16((short)10);
        b.subtract((short)5);
        assertEquals(b.getValue(), (short)5);

        Int16 c = Int16.subtract(new Int16((short)10), new Int16((short)5));
        assertEquals(c.getValue(), (short)5);

        Int16 d = Int16.subtract((short)10, (short)5);
        assertEquals(d.getValue(), (short)5);
    }

    @Test
    public void multiply() throws Exception {
        Int16 a = new Int16((short)10);
        a.multiply(new Int16((short)5));
        assertEquals(a.getValue(), (short)50);

        Int16 b = new Int16((short)10);
        b.multiply((short)5);
        assertEquals(b.getValue(), (short)50);

        Int16 c = Int16.multiply(new Int16((short)10), new Int16((short)5));
        assertEquals(c.getValue(), (short)50);

        Int16 d = Int16.multiply((short)10, (short)5);
        assertEquals(d.getValue(), (short)50);

    }

    @Test
    public void divide() throws Exception {
        Int16 a = new Int16((short)15);
        a.divide(new Int16((short)2));
        assertEquals(a.getValue(), (short)7);

        Int16 b = new Int16((short)15);
        b.divide((short)2);
        assertEquals(b.getValue(), (short)7);

        Int16 c = Int16.divide(new Int16((short)15), new Int16((short)2));
        assertEquals(c.getValue(), (short)7);

        Int16 d = Int16.divide((short)15, (short)2);
        assertEquals(d.getValue(), (short)7);

    }

    @Test
    public void mod() throws Exception {
        Int16 a = new Int16((short)99);
        a.mod(new Int16((short)30));
        assertEquals(a.getValue(), (short)9);

        Int16 b = new Int16((short)99);
        b.mod((short)30);
        assertEquals(b.getValue(), (short)9);

        Int16 c = Int16.mod(new Int16((short)99), new Int16((short)30));
        assertEquals(c.getValue(), (short)9);

        Int16 d = Int16.mod((short)99, (short)30);
        assertEquals(d.getValue(), (short)9);

    }

    @Test
    public void pow() throws Exception {
        Int16 a = new Int16((short)2);
        a.pow((short)10);
        assertEquals(a.getValue(), (short)1024);

        Int16 b = new Int16((short)2);
        b.pow((short)10);
        assertEquals(b.getValue(), (short)1024);

        Int16 c = Int16.pow(new Int16((short)2), new Int16((short)10));
        assertEquals(c.getValue(), (short)1024);

        Int16 d = Int16.pow((short)2, (short)10);
        assertEquals(d.getValue(), (short)1024);

        try {
            Int16 e = new Int16((short)2);
            e.pow(new Int16((short)-2));
            fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void isET() throws Exception {
        Int16 a = new Int16((short)100);
        Int16 b = new Int16((short)999);
        Int16 c = new Int16((short)100);

        assertFalse(a.isET(b));
        assertFalse(a.isET((short)999));
        assertFalse(Int16.isET(a, b));
        assertFalse(Int16.isET((short)100,(short)999));
        assertTrue(a.isET(c));
        assertTrue(a.isET((short)100));
        assertTrue(Int16.isET(a, c));
        assertTrue(Int16.isET((short)100, (short)100));
    }

    @Test
    public void isGT() throws Exception {
        Int16 a = new Int16((short)100);
        Int16 b = new Int16((short)999);
        Int16 c = new Int16((short)90);

        assertFalse(a.isGT(b));
        assertFalse(a.isGT((short)999));
        assertFalse(Int16.isGT(a, b));
        assertFalse(Int16.isGT((short)100,(short)999));
        assertTrue(a.isGT(c));
        assertTrue(a.isGT((short)90));
        assertTrue(Int16.isGT(a, c));
        assertTrue(Int16.isGT((short)100, (short)90));
    }

    @Test
    public void isGE() throws Exception {
        Int16 a = new Int16((short)100);
        Int16 b = new Int16((short)999);
        Int16 c = new Int16((short)100);

        assertFalse(a.isGE(b));
        assertFalse(a.isGE((short)999));
        assertFalse(Int16.isGE(a, b));
        assertFalse(Int16.isGE((short)100,(short)999));
        assertTrue(a.isGE(c));
        assertTrue(a.isGE((short)100));
        assertTrue(Int16.isGE(a, c));
        assertTrue(Int16.isGE((short)100, (short)100));
    }

    @Test
    public void isLT() throws Exception {
        Int16 a = new Int16((short)100);
        Int16 b = new Int16((short)90);
        Int16 c = new Int16((short)999);

        assertFalse(a.isLT(b));
        assertFalse(a.isLT((short)90));
        assertFalse(Int16.isLT(a, b));
        assertFalse(Int16.isLT((short)100,(short)90));
        assertTrue(a.isLT(c));
        assertTrue(a.isLT((short)999));
        assertTrue(Int16.isLT(a, c));
        assertTrue(Int16.isLT((short)100, (short)999));
    }

    @Test
    public void isLE() throws Exception {
        Int16 a = new Int16((short)100);
        Int16 b = new Int16((short)90);
        Int16 c = new Int16((short)100);

        assertFalse(a.isLE(b));
        assertFalse(a.isLE((short)90));
        assertFalse(Int16.isLE(a, b));
        assertFalse(Int16.isLE((short)100,(short)90));
        assertTrue(a.isLE(c));
        assertTrue(a.isLE((short)100));
        assertTrue(Int16.isLE(a, c));
        assertTrue(Int16.isLE((short)100, (short)100));
    }

    @Test
    public void deepCopy() throws Exception {
        Int16 a = new Int16((short)100);
        Int16 b = a.clone();

        assertEquals(a.getValue(), b.getValue());

        a.add ((short)10);

        assertFalse(Int16.isET(a, b));
    }

    @Test
    public void outputString() throws Exception {
        Int16 a = new Int16((short)10);
        assertEquals(a.toString(), "10(Int16)");
    }

}
