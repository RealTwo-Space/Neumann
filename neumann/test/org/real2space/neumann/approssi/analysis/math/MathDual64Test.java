package org.real2space.neumann.approssi.analysis.math;

import org.junit.Test;
import org.real2space.neumann.approssi.core.function.Function;
import org.real2space.neumann.approssi.core.function.Variable;
import org.real2space.neumann.approssi.core.structure.DualNumber;
import org.real2space.neumann.approssi.core.value.DualNumber64;

import static org.junit.Assert.*;

/**
 * Created by ryosukesuzuki on 2016/12/27.
 */
public class MathDual64Test {
    private class MyFunction extends Function<DualNumber64> {

        public MyFunction () {
            super();
            result = new Variable<DualNumber64>();
            setDualNumber("x");
            setDualNumber("y");
        }

        @Override
        public void execute() {
            // sinx * cosy
            DualNumber64 x = (DualNumber64)getDualNumber("x");
            DualNumber64 y = (DualNumber64)getDualNumber("y");
            DualNumber64 out = DualNumber64.multiply(x, y);
            result.set(MathDual64.cos(out));
        }

    }

    private class MyDerivative extends Function<Double> {
        public MyDerivative () {
            super();
            result = new Variable<Double>();
            setDualNumber("x");
        }

        @Override
        public void execute () {
            DualNumber64 x = (DualNumber64)getDualNumber("x");
            result.set(MathDual64.pow(x, 3.0).b());
        }
    }

    @Test
    public void test1() {
        MyFunction func = new MyFunction();
        DualNumber64 xe = new DualNumber64(Math64.PI / 6.0, 1.0);
        DualNumber64 x = new DualNumber64(Math64.PI / 6.0, 0.0);
        DualNumber64 ye = new DualNumber64(Math64.PI / 4.0, 1.0);
        DualNumber64 y = new DualNumber64(Math64.PI / 4.0, 0.0);
        // cosx * cosy -> cos(PI / 6) * cos(PI / 4)
        // cosxy -> - y * sinxy
        // - sinxy - yx * (cosxy) -> - sin(PI / 24) - PI/24 * cos(PI/24)
        // cosxy -> - sinxy
        // f(x*y) -> y * fx(x*y) -> fx(x*y) + y * x * fxy(x*y)

        // f(x + e, y + e') = f(x,y) + (efx(x, y)x + e'fy(x, y)y) + (e^2fxx(x, y)x^2 + 2ee'fxy(x, y)xy + e'^2fyy(x, y)y^2)/2
        func.changeArgument("x", xe);
        func.changeArgument("y", ye);
        func.execute();
        System.out.println(func.getResult());
        System.out.println(- Math64.sin(Math64.PI/6.0 * Math64.PI/4.0));
        System.out.println(- Math64.sin(Math64.PI/6.0 * Math64.PI/4.0) * (Math64.PI/6.0 + Math64.PI/4.0));
        System.out.println(- Math64.sin(Math64.PI/6.0 * Math64.PI/4.0)*Math64.PI/4.0);
        System.out.println(- Math64.sin(Math64.PI/6.0 * Math64.PI/4.0)*Math64.PI/4.0);

    }

    @Test
    public void test2 () {
        // (x + y) * f'(x*y)
        // f(e + x) = f(x) + e*f'(x)
        // f'(e + x) = f'(x) + e*f''(x)

        DualNumber64 x = new DualNumber64(2.0, 1.0);
        DualNumber64 xpow = MathDual64.pow(x, 3.0);
        System.out.println(xpow);
    }

    @Test
    public void test3 () {
        // f(x) = x^3
        // f'(x) = 3 x^2
        MyDerivative md = new MyDerivative();
        DualNumber64 x = new DualNumber64(5.0);
        md.changeArgument("x", x);
        md.execute();
        System.out.println(md.getResult());
    }
}