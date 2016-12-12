package org.real2space.neumann.approssi.analysis.differentiation;

import org.real2space.neumann.approssi.core.function.*;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          <p>
 *          created 12/12/16
 */
public class Differentiation32Test {
    private class MyFunction extends Function<Double> {

        public MyFunction () {
            super();
            result = new Variable<Double>();
            setDouble("x");
            setDouble("y");
        }

        @Override
        public void execute() {
            result.set(getDouble("x") * getDouble("y"));
        }

    }

    @Test
    public void test () {
        Differentiation64 diff64 = new Differentiation64();
        MyFunction mf = new MyFunction();
        double x = 200.0;
        double y = -999.9;
        double h = 0.00000001;
        diff64.changeArgument(mf);
        diff64.substitute("x", x);
        diff64.substitute("y", y);
        diff64.execute("x", h);
        System.out.println("with x " + diff64.getResult());
        diff64.execute("y", h);
        System.out.println("with y " + diff64.getResult());

    }
}