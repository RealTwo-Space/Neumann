package org.real2space.neumann.congraph;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
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
        c.execute();

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
    public void gradientTest() {
        Congraph cg = new Congraph(999L);
        CNode x = cg.constant(cg.util.normalRandoms(10, 3));
        CNode beta = cg.variable(cg.util.normalRandoms(3, 1));
        CNode bias = cg.variable(cg.util.normalRandoms(10, 1));
        CNode y = x.matMultiply(beta).add(bias);
        CNode yd = cg.variable(cg.util.normalRandoms(10, 1));
        CNode E = y.subtract(yd).activate(cg.func.SQ).sum();
        CNode r = cg.constant(0.03);
        CNode batch = cg.batch(
                beta.decrementalSubstitute(E.partialDiff(beta).multiply(r)),
                bias.decrementalSubstitute(E.partialDiff(bias).multiply(r))
        );
        for (int i = 0; i < 100; i++) {
            cg.execute(batch);
            System.out.println(E);
        }
        System.out.println(beta);
        System.out.println(bias);
    }

    @Test
    public void gradientTest2() {
        Congraph cg = new Congraph(999L);
        CNode x = cg.constant(cg.tUtil.normalRandoms(cg.tUtil.shape(10, 3)));
        CNode beta = cg.variable(cg.tUtil.normalRandoms(cg.tUtil.shape(3, 1)));

        CNode bias = cg.variable(cg.tUtil.normalRandoms(cg.tUtil.shape()));
        System.out.println(bias);
        CNode y = x.matMultiply(beta).add(bias);
        CNode yd = cg.variable(cg.tUtil.normalRandoms(cg.tUtil.shape(10, 1)));
        CNode E = y.subtract(yd).activate(cg.func.SQ).sum();
        CNode r = cg.constant(cg.tUtil.tensor(0.03));
        CNode batch = cg.batch(
                beta.decrementalSubstitute(E.partialDiff(beta).multiply(r)),
                bias.decrementalSubstitute(E.partialDiff(bias).multiply(r))
        );
        for (int i = 0; i < 100; i++) {
            cg.execute(batch);
            System.out.println(E);
        }
        System.out.println(beta);
        System.out.println(bias);
    }
}