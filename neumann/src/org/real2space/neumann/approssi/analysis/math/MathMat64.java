package org.real2space.neumann.approssi.analysis.math;

import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class MathMat64 {
    public static Matrix64 ZERO(int row, int column) {
        return new Matrix64(row, column);
    }

    public static Matrix64 toZero(Matrix64 mat) {
        return new Matrix64(mat.getRow(), mat.getColumn());
    }

}
