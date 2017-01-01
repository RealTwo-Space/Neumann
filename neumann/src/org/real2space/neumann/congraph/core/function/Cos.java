package org.real2space.neumann.congraph.core.function;

import org.real2space.neumann.approssi.analysis.math.Math32;
import org.real2space.neumann.approssi.analysis.math.Math64;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class Cos implements ActivationFunction {
    @Override
    public double activate(double value) {
        return Math64.cos(value);
    }

    @Override
    public double activateDiff(double value) {
        return - Math64.sin(value);
    }
}
