package org.real2space.neumann.congraph.core.function;

import org.real2space.neumann.congraph.core.data.Data;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */



/*
    Activation Function


 */
public interface ActivationFunction {

    /**
     * return f(x)
     * @param value double
     * @return double
     */
    double activate(double value);

    /**
     * return f'(x)
     * @param value double
     * @return double
     */
    double activateDiff(double value);
}
