package org.real2space.neumann.congraph;

import org.junit.Test;

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
    public void findPartials() {
        Congraph cg = new Congraph();
        CNode x = cg.constant(new double[][]{{5}, {6}});
        CNode W = cg.constant(new double[][]{{1, 2}, {2, 3}, {3, 4}});
        CNode b = cg.constant(new double[][]{{-3}, {-2}, {-1}});
        CNode yd = cg.constant(new double[][]{{-3},{22},{-45}});
        CNode y = W.multiply(x);
        //CNode m = y.subtract(yd);
        CNode E = y.normSq();
        //m.execute();
        //E.execute();
        E.partialDiff(W).execute();
        E.partialDiff(x).execute();
    }

}