package org.real2space.neumann.approssi.core.value;

import java.util.Arrays;
import org.real2space.neumann.approssi.core.structure.Matrix;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/14
 */ 

public class Matrix64 implements Matrix<Double>{
    private double[][] matrix;

    public Matrix64 (double[][] matrix) {
        int N = matrix.length;
        this.matrix = new double[N][];
        for (int i = 0, M = matrix[0].length; i < N; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], M);
        }
    }

    private void checkDimensionAdd (Matrix64 b) {
        if (this.matrix.length != b.matrix.length || this.matrix[0].length != b.matrix[0].length) {
            throw new ArithmeticException("Wrong Dimension");
        }
    }

    private void checkDimensionMult (Matrix64 b) {
        if (this.matrix[0].length != b.matrix.length) {
            throw new ArithmeticException("Wrong Dimension");
        }
    }

    /**
     * Add other matrix to this
     * @param other Matrix<Double>
     * @return void
     */
    public void add (Matrix<Double> other) {
        Matrix64 temp = (Matrix64)other;
        checkDimensionAdd(temp);

        int N = this.matrix.length;
        int M = this.matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j] += temp.matrix[i][j];
            }
        }
    }

    /**
     * Subtract other matrix from this
     * @param other Matrix<Double>
     * @return void
     */
    public void subtract (Matrix<Double> other) {
        Matrix64 temp = (Matrix64)other;
        checkDimensionAdd(temp);

        int N = this.matrix.length;
        int M = this.matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j] -= temp.matrix[i][j];
            }
        }
    }

    /**
     * Multiply other matrix
     * @param other Matrix<Double>
     * @return void
     */
    public void multiply (Matrix<Double> other) {
        Matrix64 temp = (Matrix64)other;
        checkDimensionMult(temp);

        int N = this.matrix.length;
        int M = temp.matrix[0].length;
        double[][] mat = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    mat[i][j] += this.matrix[i][k] * temp.matrix[k][j];
                }
            }
        }
        this.matrix = mat;
    }

    /**
     * Multiply scalar to this matrix
     * @param scalar Double
     * @return void
     */
    public void multiply (Double scalar) {
        double sca = scalar;
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j] *= sca;
            }
        }
    }

    /**
     * Divide this matrix by scalar
     * @param scalar Double
     * @return Double
     */
    public void divide (Double scalar) {
        double sca = 1 / scalar;
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j] *= sca;
            }
        }
    }

    /**
     * Calculate (this matrix)^(non-negative integer)
     * @param exponent int
     * @return void
     */
    public void power (int exponent) {
        for (int i = 0; i < exponent; i++) {
            this.multiply(this);
        }
    }

    /**
     * Get the determinant of this matrix.
     * @return Double
     */
    public Double det () {
        return 0.0;
    }

    /**
     * Get the trace of this matrix
     * @return Double
     */
    public Double trace () {
        return 0.0;
    }

    /**
     * Transpose this matrix
     * @return void
     */
    public void transpose () {
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        double[][] mat = new double[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[j][i] = this.matrix[i][j];
            }
        }
        this.matrix = mat;
    }

    /**
     * Transpose this matrix
     * @return void
     */
    public void inverse () {

    }

    public Matrix64 deepCopy () {
        return new Matrix64(this.matrix);
    }

    public String toString () {
        StringBuffer output = new StringBuffer();

        int N = matrix.length;
        int M = matrix[0].length;
        for (int i = 0; i < N; i++) {
            output.append("| ");
            for (int j = 0; j < M; j++) {
                output.append(matrix[i][j]);
                if (j != M - 1) {
                    output.append("\t");
                }
            }
            output.append(" |\n");
        }
        return output.toString();
    }
}