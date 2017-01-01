package org.real2space.neumann.congraph.core.function;

import org.real2space.neumann.approssi.analysis.math.Math32;
import org.real2space.neumann.approssi.analysis.math.Math64;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class Tan implements ActivationFunction {
    @Override
    public double activate(double value) {
        return Math64.tan(value);
    }

    @Override
    public double activateDiff(double value) {
        double out = 1.0 / Math64.cos(value);
        return out * out;
    }
}
