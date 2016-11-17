package org.real2space.neumann.approssi.core.value;

import org.junit.Test;
import org.real2space.neumann.approssi.core.structure.Matrix;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          create      2016/11/17
 */
public class Matrix32Test {

    @Test
    public void add() throws Exception {

    }
    @Test
    public void performanceTestConstructor() throws Exception {
        long start = System.currentTimeMillis();
        Matrix32 a;
        float[][] b = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        for (int i = 0; i < 10000000; i++){
            a = new Matrix32(b);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }
    @Test
    public void performanceTestAdd() throws Exception {
        long start = System.currentTimeMillis();
        Matrix32 a, b;
        float[][] c = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        a = new Matrix32(c);
        b = new Matrix32(c);
        for (int i = 0; i < 100000000; i++){
            a.add(b);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

    public void performanceTestSubtract() throws Exception {
        long start = System.currentTimeMillis();
        Matrix32 a, b;
        float[][] c = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        a = new Matrix32(c);
        b = new Matrix32(c);
        for (int i = 0; i < 100000000; i++){
            a.subtract(b);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

    public void performanceTestMultiply() throws Exception {
        long start = System.currentTimeMillis();
        Matrix32 a, b;
        float[][] c = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        float[][] d = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        a = new Matrix32(c);
        b = new Matrix32(d);
        for (int i = 0; i < 10000000; i++){
            a.multiply(b);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

    public void performanceTestTranspose() throws Exception {
        long start = System.currentTimeMillis();
        Matrix32 a;
        float[][] c = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};

        a = new Matrix32(c);
        for (int i = 0; i < 10000000; i++){
            a.transpose();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");
    }

}