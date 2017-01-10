package org.real2space.neumann.approssi.analysis.differentialequation;

import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */
public class DirichletCondition64 implements BoundaryCondition64 {
    // defined only on boundary
    private Matrix64 condition;

    public DirichletCondition64(Matrix64 condition) {
        this.condition = condition.deepCopy();
    }

    public void executeNabla (Matrix64 u, Matrix64 newU) {
        dimensionCheck(newU);
        int n = this.condition.getRow();
        int m = this.condition.getColumn();

        for (int i = 0; i < n; i++) {
            newU.set(i, 0, this.condition.get(i, 0));
            newU.set(i, m - 1, this.condition.get(i, m - 1));
        }

        for (int j = 1; j < m - 1; j++) {
            newU.set(0, j, this.condition.get(0, j));
            newU.set(n - 1, j, this.condition.get(n - 1, j));
        }
    }

    public void executeLaplacian (Matrix64 u, Matrix64 newU) {
        executeNabla(u, newU);
    }

    private void dimensionCheck (Matrix64 u) {
        if (this.condition.getRow() != u.getRow() || this.condition.getColumn() != u.getColumn()) {
            throw new ArrayIndexOutOfBoundsException("Wrong dimension");
        }
    }
}
