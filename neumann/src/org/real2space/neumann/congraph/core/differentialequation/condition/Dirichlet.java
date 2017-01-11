package org.real2space.neumann.congraph.core.differentialequation.condition;

import org.real2space.neumann.approssi.analysis.differentialequation.BoundaryCondition64;
import org.real2space.neumann.approssi.analysis.differentialequation.DirichletCondition64;
import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */
class Dirichlet implements DECondition {
    private DirichletCondition64 cond;
    Dirichlet(Matrix64 condition) {
        this.cond = new DirichletCondition64(condition);
    }

    public BoundaryCondition64 getCondition () {
        return this.cond;
    }
}
