package org.real2space.neumann.congraph.core.function;

import org.real2space.neumann.congraph.core.data.Data;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public interface ActivationFunction {
    double activate(double value);
    double activateDiff(double value);
}
