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
public class NeumannCondition64 implements BoundaryCondition64 {
    private double dx;
    public NeumannCondition64 (double dx) {
        this.dx = dx;
    }

    public void executeNabla (Matrix64 u, Matrix64 newU) {
        // maybe possible. need to research
        throw new ArithmeticException("Under construction");
    }

    public void executeLaplacian(Matrix64 u, Matrix64 newU) {
        int n = newU.getRow();
        int m = newU.getColumn();
        double invdx = 1.0 / (dx * dx);
        double temp;

        // j = 0, m - 1
        for (int i = 1; i < n - 1; i++) {
            temp = 0.0;
            temp += 2.0 * u.get(i, 1) + u.get(i + 1, 0) + u.get(i - 1, 0);
            temp -= 4.0 * u.get(i, 0);
            temp *= invdx;
            newU.set(i, 0, temp);

            temp = 0.0;
            temp += 2.0 * u.get(i, m - 2) + u.get(i + 1, m - 1) + u.get(i - 1, m - 1);
            temp -= 4.0 * u.get(i, m - 1);
            temp *= invdx;
            newU.set(i, m - 1, temp);
        }

        // i = 0, n - 1
        for (int j = 1; j < m - 1; j++) {
            temp = 0.0;
            temp += 2.0 * u.get(1, j) + u.get(0, j + 1) + u.get(0, j - 1);
            temp -= 4.0 * u.get(0, j);
            temp *= invdx;
            newU.set(0, j, temp);

            temp = 0.0;
            temp += 2.0 * u.get(n - 2, j) + u.get(n - 1, j + 1) + u.get(n - 1, j - 1);
            temp -= 4.0 * u.get(n - 1, j);
            temp *= invdx;
            newU.set(n - 1, j, temp);
        }

        // i = 0, j = 0
        temp = 0.0;
        temp += 2.0 * (u.get(0, 1) + u.get(1, 0)) - 4.0 * u.get(0, 0);
        temp *= invdx;
        newU.set(0, 0, temp);

        // i = 0, j = m - 1
        temp = 0.0;
        temp += 2.0 * (u.get(0, m - 2) + u.get(1, m - 1)) - 4.0 * u.get(0, m - 1);
        temp *= invdx;
        newU.set(0, m - 1, temp);

        // i = n - 1, j = 0
        temp = 0.0;
        temp += 2.0 * (u.get(n - 2, 0) + u.get(n - 1, 1)) - 4.0 * u.get(n - 1, 0);
        temp *= invdx;
        newU.set(n - 1, 0, temp);

        // i = n - 1, j = m - 1
        temp = 0.0;
        temp += 2.0 * (u.get(n - 2, m - 1) + u.get(n - 1, m - 2)) - 4.0 * u.get(n - 1, m - 1);
        temp *= invdx;
        newU.set(n - 1, m - 1, temp);
    }
}
