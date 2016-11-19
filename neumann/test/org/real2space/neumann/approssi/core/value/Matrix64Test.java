package org.real2space.neumann.approssi.core.value;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          create      2016/11/18
 */
public class Matrix64Test {
    @Test
    public void multiply() throws Exception {

    }

    public void performanceTestAdd() throws Exception {
        long start = System.currentTimeMillis();
        Matrix64 a, b;
        double[][] c = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        double[][] d = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        a = new Matrix64(c);
        b = new Matrix64(d);
        for (int i = 0; i < 100000000; i++) {
            a.add(b);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

    public void performanceTestMultiply() throws Exception {
        long start = System.currentTimeMillis();
        Matrix64 a, b;
        double[][] c = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        double[][] d = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        a = new Matrix64(c);
        b = new Matrix64(d);
        for (int i = 0; i < 100000000; i++) {
            a.multiply(b);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

}