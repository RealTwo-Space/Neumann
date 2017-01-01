package org.real2space.neumann.congraph;

import org.junit.Test;
import org.real2space.neumann.approssi.analysis.math.Math64;
import org.real2space.neumann.congraph.core.function.ActivationFunction;

import static org.junit.Assert.*;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class CongraphTest {

    @Test
    public void notation1() {
        Congraph cg = new Congraph();
        CNode a = cg.constant(8.0);
        CNode b = cg.constant(8.0);
        CNode c = cg.add(a, b);
        cg.execute(c);

    }

    @Test
    public void notation2() {
        Congraph cg = new Congraph();
        CNode a = cg.constant(8.0);
        a.add(cg.constant(8.0)).execute();

    }

    @Test
    public void notation3() {
        Congraph cg = new Congraph();
        cg.constant(8.0).add(cg.constant(8.0)).execute();
    }

    @Test
    public void notation4() {
        Congraph cg = new Congraph();
        cg.constant(2.0).multiply(
                cg.add(cg.constant(2.0), cg.constant(2.0))
        ).multiply(cg.constant(8.0)).divide(cg.constant(4.0))
                .execute();
    }

    @Test
    public void gradientDescentTest() {
        // find W s.t. minimize E = || y - yd ||^2
        Congraph cg = new Congraph(999L);
        CNode x = cg.constant(cg.util.normalRandoms(4, 1));
        CNode W = cg.variable(cg.util.normalRandoms(8, 4));
        CNode b = cg.variable(cg.util.normalRandoms(8, 1, 100.0, 20.0));
        CNode yd = cg.constant(cg.util.normalRandoms(8,1));
        CNode y = W.multiply(x).add(b);
        CNode E = y.subtract(yd).normSq();
        CNode r = cg.constant(0.03);
        CNode newW = cg.subtract(W, E.partialDiff(W).multiply(r));

        CNode out = cg.substitute(W, newW);

        for (int i = 0; i < 300; i++) {
            out.execute();
            if (i % 30 == 0) {
                System.out.println("Error : " + E);
            }
        }
        System.out.println("Error : " + E);
    }

    @Test
    public void gradientDescentTest2() {
        Congraph cg = new Congraph(999L);
        CNode x = cg.constant(cg.util.normalRandoms(4, 1));
        CNode W = cg.variable(cg.util.normalRandoms(8, 4));
        CNode b = cg.variable(cg.util.normalRandoms(8, 1, 100.0, 20.0));
        CNode yd = cg.constant(cg.util.normalRandoms(8,1));
        CNode y = W.multiply(x).add(b);
        CNode E = y.subtract(yd).normSq();
        CNode dEdW = E.partialDiff(W);
        CNode dEdb = E.partialDiff(b);
        CNode r = cg.constant(0.03);
        CNode out = cg.batch(
                cg.decrementalSubstitute(W, dEdW.multiply(r)),
                cg.decrementalSubstitute(b, dEdb.multiply(r))
        );
        for (int i = 0; i < 300; i++) {
            out.execute();
            if (i % 30 == 0) {
                System.out.println(E);
            }
        }
        System.out.println(E);
    }

    @Test
    public void gradientDescentTest3() {
        Congraph cg = new Congraph(999L);
        CNode x = cg.constant(cg.util.normalRandoms(4, 1));
        CNode W = cg.variable(cg.util.normalRandoms(8, 4));
        CNode b = cg.variable(cg.util.normalRandoms(8, 1, 100.0, 20.0));
        CNode yd = cg.constant(cg.util.normalRandoms(8,1));
        CNode y = W.multiply(x).add(b);
        CNode E = y.subtract(yd).normSq();
        CNode r = cg.constant(0.03);
        CNode out = cg.batch(
                W.decrementalSubstitute(E.partialDiff(W).multiply(r)),
                b.decrementalSubstitute(E.partialDiff(b).multiply(r))
        );
        for (int i = 0; i < 300; i++) {
            out.execute();
            if (i % 30 == 0) {
                System.out.println(E);
            }
        }
        System.out.println(E);
    }

    @Test
    public void sinTest() {
        Congraph cg = new Congraph(999L);
        CNode x =  cg.constant(cg.util.normalRandoms(3, 1, 0.0, 3.14));
        CNode out = x.sin();
        CNode norm = out.normSq();
        CNode dx = norm.partialDiff(x);
        dx.execute();
        System.out.println(norm);
    }

    @Test
    public void diffSinTest() {
        Congraph cg = new Congraph(999L);
        CNode x = cg.constant(Math64.PI/6.0);
        CNode sinx = x.sin();
        CNode cosx = x.cos();
        CNode diffsinx = sinx.partialDiff(x);
        cg.batch(
                sinx,
                cosx,
                diffsinx
        ).execute();
        System.out.println("test");
        System.out.println(sinx);
        System.out.println(cosx);
        System.out.println(diffsinx);
    }

    @Test
    public void ActivateOpTest() {
        Congraph cg = new Congraph();
        CNode x = cg.constant(Math64.PI / 6.0);
        CNode sinx = x.activate(new ActivationFunction() {
            @Override
            public double activate(double value) {
                return Math64.sin(value);
            }

            @Override
            public double activateDiff(double value) {
                return Math64.cos(value);
            }
        });
        CNode diff = sinx.partialDiff(x);
        diff.execute();
        System.out.println(diff);
    }



}