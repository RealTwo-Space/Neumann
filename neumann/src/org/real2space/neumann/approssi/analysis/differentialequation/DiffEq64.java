package org.real2space.neumann.approssi.analysis.differentialequation;

import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/10/17
 */
public class DiffEq64 {
    // all of these are considering only "boundary"
    // need to consider broader meaning of boundary

    // do nabla for matrix
    // central difference
    public static Matrix64 nabla(Matrix64 u, double dx, BoundaryCondition64 cond) {
        Matrix64 newU = u.deepCopy();
        double invdx = 0.5 / dx;
        double temp;

        for (int i = 1, n = newU.getRow() - 1; i < n; i++) {
            for (int j = 1, m = newU.getColumn() - 1; j < m; j++) {
                temp = 0.0;
                // add row
                temp += u.get(i + 1, j) - u.get(i - 1, j);
                // add column
                temp += u.get(i, j + 1) - u.get(i, j - 1);
                newU.set(i, j, temp * invdx);
            }
        }

        cond.executeNabla(u, newU);
        return newU;
    }

    // do laplacian for matrix
    public static Matrix64 laplacian (Matrix64 u, double dx, BoundaryCondition64 cond) {
        Matrix64 newU = u.deepCopy();
        double invdx = 1.0 / (dx * dx);
        double temp;

        for (int i = 1, n = newU.getRow() - 1; i < n; i++) {
            for (int j = 1, m = newU.getColumn() - 1; j < m; j++) {
                temp = 0.0;
                // add row
                temp += u.get(i + 1, j) + u.get(i - 1, j);
                // add column
                temp += u.get(i, j + 1) + u.get(i, j - 1);
                // add middle
                temp -= 4.0 * u.get(i, j);

                newU.set(i, j, temp * invdx);
            }
        }

        cond.executeLaplacian(u, newU);
        return newU;
    }

    // entrywise
    public static Matrix64 entrywiseMultiply (Matrix64 a, Matrix64 b) {
        dimensionCheck(a, b);

        Matrix64 res = a.deepCopy();

        for (int i = 0, n = a.getRow(); i < n; i++) {
            for (int j = 0, m = a.getColumn(); j < m; j++) {
                res.set(i, j, a.get(i, j) * b.get(i, j));
            }
        }

        return res;
    }

    public static Matrix64 entrywiseDivide (Matrix64 a, Matrix64 b) {
        dimensionCheck(a, b);

        Matrix64 res = a.deepCopy();

        for (int i = 0, n = a.getRow(); i < n; i++) {
            for (int j = 0, m = a.getColumn(); j < m; j++) {
                res.set(i, j, a.get(i, j) / b.get(i, j));
            }
        }

        return res;
    }

    private static void dimensionCheck (Matrix64 a, Matrix64 b) {
        if (a.getRow() != b.getRow() || a.getColumn() != b.getColumn()) {
            throw new ArrayIndexOutOfBoundsException("Wrong dimension");
        }
    }

    /*
    // make vec Version here.
    // do nabla for vec
    public static Vector64 nabla(Vector64 u) {
        return null;
    }
    */
}
