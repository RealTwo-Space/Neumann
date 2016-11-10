package org.real2space.neumann.approssi.core.value;

import org.junit.Test;

import java.math.BigInteger;
import java.util.BitSet;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/08
 */
public class BigIntTest {

    @Test
    public void constTest() throws Exception {
        BigInt z = BigInt.ZERO();
        BigInt o = BigInt.ONE();
        BigInt no = BigInt.NEGATIVE_ONE();

        assertTrue(z.isET("0"));
        assertTrue(o.isET("1"));
        assertTrue(no.isET("-1"));

        z.add("1");
        assertFalse(z.isET(BigInt.ZERO()));


    }

    @Test
    public void opposite() throws Exception {
        BigInt a = new BigInt("1000");
        BigInt b = a.opposite();
        assertTrue(BigInt.isET(b, new BigInt("-1000")));
    }

    @Test
    public void add() throws Exception {
        BigInt a = new BigInt("10");
        a.add(new BigInt("10"));
        a.add("10");
        a.add(new BigInteger("10"));
        assertTrue(a.isET("40"));
    }

    @Test
    public void subtract() throws Exception {
        BigInt b = new BigInt("0");
        b.subtract("10");
        b.subtract(new BigInt("10"));
        b.subtract(new BigInteger("10"));
        assertTrue(b.isET("-30"));
    }

    @Test
    public void multiply() throws Exception {
        BigInt a = new BigInt("10");
        a.multiply("10");
        assertTrue(a.isET("100"));

        a.multiply("0");
        assertTrue(a.isET(BigInt.ZERO()));
    }

    @Test
    public void divide() throws Exception {
        BigInt a = new BigInt("10");
        try {
            a.divide("0");
            fail();
        } catch (Exception e) {
        }
        a.divide("4");
        assertTrue(a.isET("2"));
    }

    @Test
    public void mod() throws Exception {
        BigInt a = new BigInt("10");
        try {
            a.mod("0");
            fail();
        } catch (Exception e) {
        }

        a.mod("3");
        assertTrue(a.isET("1"));

    }

    @Test
    public void pow() throws Exception {
    }

    @Test
    public void isET() throws Exception {
        BigInt a = new BigInt("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInt b = new BigInt("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInt c = new BigInt("19191919191919191919191919191919191919191919191919191919191919191918");
        assertTrue(a.isET(b));
        assertTrue(BigInt.isET(a, b));
        assertFalse(a.isET(c));
        assertFalse(BigInt.isET(a, c));

        BigInteger aa = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInteger bb = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInteger cc = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191918");
        assertTrue(BigInt.isET(aa, bb));
        assertTrue(a.isET(bb));
        assertFalse(BigInt.isET(aa, cc));
        assertFalse(a.isET(c));


    }

    @Test
    public void isGT() throws Exception {
        BigInt a = new BigInt("19191919191919191919191919191919191919191919191919191919191919191918");
        BigInt b = new BigInt("19191919191919191919191919191919191919191919191919191919191919191917");
        BigInt c = new BigInt("19191919191919191919191919191919191919191919191919191919191919191919");
        assertTrue(a.isGT(b));
        assertTrue(BigInt.isGT(a, b));
        assertFalse(a.isGT(c));
        assertFalse(BigInt.isGT(a, c));

        BigInteger aa = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191918");
        BigInteger bb = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191917");
        BigInteger cc = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191919");
        assertTrue(BigInt.isGT(aa, bb));
        assertTrue(a.isGT(bb));
        assertFalse(BigInt.isGT(aa, cc));
        assertFalse(a.isGT(c));
    }

    @Test
    public void isGE() throws Exception {
        BigInt a = new BigInt("19191919191919191919191919191919191919191919191919191919191919191918");
        BigInt b = new BigInt("19191919191919191919191919191919191919191919191919191919191919191917");
        BigInt c = new BigInt("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInt d = new BigInt("19191919191919191919191919191919191919191919191919191919191919191918");
        assertTrue(a.isGE(b));
        assertTrue(a.isGE(d));
        assertTrue(BigInt.isGE(a, b));
        assertFalse(a.isGE(c));
        assertFalse(BigInt.isGE(a, c));

        BigInteger aa = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191918");
        BigInteger bb = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191917");
        BigInteger cc = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInteger dd = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191918");
        assertTrue(BigInt.isGE(aa, bb));
        assertTrue(BigInt.isGE(aa, dd));
        assertTrue(a.isGE(bb));
        assertTrue(a.isGE(dd));
        assertFalse(BigInt.isGE(aa, cc));
        assertFalse(a.isGE(c));
    }

    @Test
    public void isLT() throws Exception {
        BigInt a = new BigInt("19191919191919191919191919191919191919191919191919191919191919191918");
        BigInt b = new BigInt("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInt c = new BigInt("19191919191919191919191919191919191919191919191919191919191919191917");
        assertTrue(a.isLT(b));
        assertTrue(BigInt.isLT(a, b));
        assertFalse(a.isLT(c));
        assertFalse(BigInt.isLT(a, c));

        BigInteger aa = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191918");
        BigInteger bb = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInteger cc = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191917");
        assertTrue(BigInt.isLT(aa, bb));
        assertTrue(a.isLE(bb));
        assertFalse(BigInt.isLT(aa, cc));
        assertFalse(a.isLT(c));
    }

    @Test
    public void isLE() throws Exception {
        BigInt a = new BigInt("19191919191919191919191919191919191919191919191919191919191919191918");
        BigInt b = new BigInt("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInt c = new BigInt("19191919191919191919191919191919191919191919191919191919191919191917");
        BigInt d = new BigInt("19191919191919191919191919191919191919191919191919191919191919191918");
        assertTrue(a.isLE(b));
        assertTrue(a.isLE(d));
        assertTrue(BigInt.isLE(a, b));
        assertTrue(BigInt.isLE(a, d));
        assertFalse(a.isLE(c));
        assertFalse(BigInt.isET(a, c));

        BigInteger aa = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191918");
        BigInteger bb = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191919");
        BigInteger cc = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191917");
        BigInteger dd = new BigInteger("19191919191919191919191919191919191919191919191919191919191919191918");
        assertTrue(BigInt.isLE(aa, bb));
        assertTrue(BigInt.isLE(aa, dd));
        assertTrue(a.isLE(bb));
        assertTrue(a.isLE(dd));
        assertFalse(BigInt.isLE(aa, cc));
        assertFalse(a.isLE(c));
    }

    @Test
    public void deepCopy() throws Exception {
        BigInt a = new BigInt ("100");
        BigInt b = a.clone();

        assertTrue (BigInt.isET(a, b));

        a.add ("100");

        assertFalse (BigInt.isET(a, b));

    }

    @Test
    public void outputString() throws Exception {
        BigInt a = new BigInt("123456789123456789");
        assertEquals(a.toString(), "123456789123456789(BigInt)");

    }

}