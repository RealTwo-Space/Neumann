package org.real2space.neumann.approssi.core.value;

import org.junit.Test;
import org.real2space.neumann.approssi.core.structure.Complex;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          <p>
 *          created 11/14/16
 */
public class Complex32Test {
    @Test
    public void createInstance () {
        Complex a = new Complex32 (1f, 2f);
        Complex32 b = new Complex32 (1f, 2f);
        System.out.println(a.re() + " " + a.im());
        System.out.println(b.re() + " " + b.im());
    }

    @Test
    public void add () {
        Complex a = new Complex32 (1f, 2f);
        Complex32 b = new Complex32 (3f, 10f);
        Complex32 c = new Complex32 (4f, -5f);

        c.add(a);
        System.out.println(c.re());
    }

    public void performanceTestAdd () {
        long start = System.currentTimeMillis();

        Complex32 b = new Complex32(1f, 1f);
        Complex32 a;
        for (int i = 0; i < 10000; i++) {
            a = new Complex32(10f, 10f);
            for (int j = 0; j < 100000; j++) {
                a.add(b);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

    public void performanceTestSubtract () {
        long start = System.currentTimeMillis();

        Complex32 b = new Complex32(1f, 1f);
        Complex32 a;
        for (int i = 0; i < 10000; i++) {
            a = new Complex32(10f, 10f);
            for (int j = 0; j < 100000; j++) {
                a.subtract(b);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }


    public void performanceTestDivide () {
        long start = System.currentTimeMillis();

        Complex32 b = new Complex32(1f, 1f);
        Complex32 a;
        for (int i = 0; i < 10000; i++) {
            a = new Complex32(10f, 10f);
            for (int j = 0; j < 100000; j++) {
                a.divide(b);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

    public void performanceTestMult () {
        long start = System.currentTimeMillis();

        Complex32 b = new Complex32(1f, 1f);
        Complex32 a;
        for (int i = 0; i < 10000; i++) {
            a = new Complex32(10f, 10f);
            for (int j = 0; j < 100000; j++) {
                a.multiply(b);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

}