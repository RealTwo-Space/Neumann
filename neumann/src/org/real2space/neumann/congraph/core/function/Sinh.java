package org.real2space.neumann.congraph.core.function;

import org.real2space.neumann.approssi.analysis.math.Math32;
import org.real2space.neumann.approssi.analysis.math.Math64;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class Sinh implements ActivationFunction {
    @Override
    public double activate(double value) {
        return Math64.sinh(value);
    }

    @Override
    public double activateDiff(double value) {
        return Math64.cosh(value);
    }
}
