package org.real2space.neumann.congraph.core.graph;

import org.junit.Test;
import org.real2space.neumann.approssi.core.function.*;
import org.real2space.neumann.approssi.core.function.Variable;
import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.value.Matrix64;

import java.util.HashMap;

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
        Node a = cg.constant(3.0);

        Matrix64 m = new Matrix64(new double[][]{{1.0, 0.0}, {0.0, 1.0}});
        Node b = cg.constant(m);

        Node mulC = cg.multiply(b, a);

        Node va = cg.variable(-4.0);
        Node d = cg.constant(2.0);
        Node mulB = cg.multiply(va, d);
        Node sub = cg.substitute(va, mulB);

        /*
        for (int i = 0; i < 10; i++) {
            cg.execute(sub);
        }
        */

        Node n1 = cg.variable(0.0);
        Node n2 = cg.constant(1.0);
        Node n3 = cg.add(n1, n2);
        Node n4 = cg.substitute(n1, n3);
        Node n5 = cg.constant(m);
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

        Node ren1 = cg.variable(1.0); // n - 1
        Node ren2 = cg.variable(1.0); // n
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
        Node a = cg.constant(1.0f);

        cg.execute(a);
    }


    private class MyFunction extends Function<Matrix> {
        public MyFunction () {
            super();
            this.setDouble("x");
            this.setDouble("y");
            this.setDouble("z");
            this.setDouble("w");
            this.setMatrix("m");

            result = new Variable<Matrix>();
        }

        @Override
        public void execute() {
            double x = getDouble("x");
            double y = getDouble("y");
            double z = getDouble("z");
            double w = getDouble("w");
            Matrix m = getMatrix("m").deepCopy();
            m.multiply(x + y * z - w);
            result.set(m);
        }
    }

    @Test
    public void functionTest () {
        Congraph cg = new Congraph();
        MyFunction mf = new MyFunction();

        Node x = cg.constant(1.0);
        Node y = cg.constant(2.0);
        Node z = cg.constant(3.0);
        Node w = cg.constant(4.0);
        Matrix64 ma = new Matrix64(new double[][] {{1.0, 2.0}, {3.0, 4.0}});
        Node m = cg.constant(ma);

        HashMap<String, Node> arg = new HashMap<String, Node>();
        arg.put("x", x);
        arg.put("y", y);
        arg.put("z", z);
        arg.put("w", w);
        arg.put("m", m);

        Node fun = cg.function(mf, arg);

        cg.execute(fun);
    }
}