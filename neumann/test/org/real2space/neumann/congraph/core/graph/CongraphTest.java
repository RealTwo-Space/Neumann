package org.real2space.neumann.congraph.core.graph;

import org.junit.Test;
import org.real2space.neumann.approssi.core.value.Matrix64;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 12/24/16
 */
public class CongraphTest {
    @Test
    public void superTest() {
        Congraph cg = new Congraph();
        Node a = cg.doubleConstant(3.0);

        Matrix64 m = new Matrix64(new double[][]{{1.0, 0.0}, {0.0, 1.0}});
        Node b = cg.matrixConstant(m);

        Node mulC = cg.multiply(b, a);

        Node va = cg.doubleVariable(-4.0);
        Node d = cg.doubleConstant(2.0);
        Node mulB = cg.multiply(va, d);
        Node sub = cg.substitute(va, mulB);

        /*
        for (int i = 0; i < 10; i++) {
            cg.execute(sub);
        }
        */

        Node n1 = cg.doubleVariable(0.0);
        Node n2 = cg.doubleConstant(1.0);
        Node n3 = cg.add(n1, n2);
        Node n4 = cg.substitute(n1, n3);
        Node n5 = cg.matrixConstant(m);
        Node n6 = cg.multiply(n5, n4);

        /*
        for (int i = 0; i < 10; i++) {
            cg.execute(n6);
        }
        */



    }

    @Test
    public void goldenRatioTest () {

        Congraph cg = new Congraph();

        Node ren1 = cg.doubleVariable(1.0); // n - 1
        Node ren2 = cg.doubleVariable(1.0); // n
        Node ren3 = cg.add(ren1, ren2);
        Node ren4 = cg.add(ren3, ren2);
        Node ren5 = cg.substitute(ren1, ren3);
        Node ren6 = cg.substitute(ren2, ren4);
        Node ren7 = cg.divide(ren6, ren5);
        long start = System.currentTimeMillis();

        /*
        Node ren1 = cg.floatVariable(1.0f); // n - 1
        Node ren2 = cg.floatVariable(1.0f); // n
        Node ren3 = cg.add(ren1, ren2);
        Node ren4 = cg.add(ren3, ren2);
        Node ren5 = cg.substitute(ren1, ren3);
        Node ren6 = cg.substitute(ren2, ren4);
        Node ren7 = cg.divide(ren6, ren5);
        */

        for (int i = 0; i < 2000; i++) {
            cg.execute(ren7);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");
    }

    @Test
    public void oneNodeTest () {
        Congraph cg = new Congraph();
        Node a = cg.floatConstant(1.0f);

        cg.execute(a);
    }

}