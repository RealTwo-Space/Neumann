package org.real2space.neumann.congraph.core.function;
import org.real2space.neumann.approssi.analysis.math.Math32;
import org.real2space.neumann.approssi.analysis.math.Math64;
import org.real2space.neumann.congraph.core.function.ActivationFunction;

import org.real2space.neumann.approssi.analysis.math.Math32;
import org.real2space.neumann.approssi.analysis.math.Math64;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class Tanh implements ActivationFunction {
    @Override
    public double activate(double value) {
        return Math64.tanh(value);
    }

    @Override
    public double activateDiff(double value) {
        double out = 1.0 / Math64.cosh(value);
        return out * out;
    }
}
