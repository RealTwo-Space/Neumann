package org.real2space.neumann.congraph.core.differentialequation.condition;

import org.real2space.neumann.approssi.analysis.differentialequation.BoundaryCondition64;
import org.real2space.neumann.approssi.analysis.differentialequation.PeriodicalBoundaryCondition64;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */
class Periodic implements DECondition {
    private PeriodicalBoundaryCondition64 cond;
    Periodic(double dx) {
        this.cond = new PeriodicalBoundaryCondition64(dx);
    }

    public BoundaryCondition64 getCondition () {
        return this.cond;
    }
}