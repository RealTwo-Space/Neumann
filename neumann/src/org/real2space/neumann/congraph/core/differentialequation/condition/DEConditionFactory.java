package org.real2space.neumann.congraph.core.differentialequation.condition;

import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */

public class DEConditionFactory {
    // condition factory

    public static DECondition DIRICHRET (Matrix64 cond) {
        return new Dirichlet(cond);
    }

    public static DECondition PERIODIC (double dx) {
        return new Periodic(dx);
    }

    public static DECondition NEUMANN (double dx) {
        return new Neumann(dx);
    }
}
