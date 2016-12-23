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

        for (int i = 0; i < 10; i++) {
            cg.execute(sub);
        }
    }

}