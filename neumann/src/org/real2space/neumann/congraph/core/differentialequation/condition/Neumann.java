package org.real2space.neumann.congraph.core.differentialequation.condition;

import org.real2space.neumann.approssi.analysis.differentialequation.BoundaryCondition64;
import org.real2space.neumann.approssi.analysis.differentialequation.NeumannCondition64;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */
class Neumann implements DECondition {
    private NeumannCondition64 cond;
    Neumann (double dx) {
        this.cond = new NeumannCondition64(dx);
    }

    public BoundaryCondition64 getCondition () {
        return this.cond;
    }
}
