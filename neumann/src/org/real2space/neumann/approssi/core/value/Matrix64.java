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

    public Matrix64(int row, int column) {
        this.matrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.matrix[i][j] = 0.0;
            }
        }
    }

    private void checkDimensionAdd (Matrix64 other) {
        if (this.matrix.length != other.matrix.length || this.matrix[0].length != other.matrix[0].length) {
            throw new ArithmeticException("Wrong Dimension");
        }
    }

    private void checkDimensionMult (Matrix64 other) {
        if (this.matrix[0].length != other.matrix.length) {
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
        this.checkDimensionAdd(temp);

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
        this.checkDimensionAdd(temp);

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
        this.checkDimensionMult(temp);

        int N = this.matrix.length;
        int K = this.matrix[0].length;
        int M = temp.matrix[0].length;
        double[][] mat = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
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
     * @return void
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

    public int getRow() {
        return this.matrix.length;
    }

    public int getColumn() {
        return this.matrix[0].length;
    }

    public double[][] get() {
        return this.matrix;
    }

    public double get(int row, int column) {
        return this.matrix[row][column];
    }

    public Matrix64 deepCopy () {
        return new Matrix64(this.matrix);
    }

    public String toString () {
        StringBuffer output = new StringBuffer();

        int N = matrix.length;
        int M = matrix[0].length;
        output.append("[[");
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                output.append(" [");
            }

            for (int j = 0; j < M; j++) {
                output.append(matrix[i][j]);

                if (j != M - 1) {
                    output.append(", ");
                }
                else {
                    if (i != N - 1) {
                        output.append("],\n");
                    }

                }
            }
        }
        output.append("]]");
        return output.toString();
    }
    /*

    String output = "{{";

		for (int i = 0; i < matrix.length; i++) {
			if (i != 0) {
				output += " {";
			}

			for (int j = 0; j < matrix[0].length; j++) {
				output += matrix[i][j];
				if (j != matrix[0].length - 1) {
					output += ", ";
				}
				else {
					if (i != matrix.length - 1) {
						output += "},\n";
					}
					else {
						output += "}}";
					}
				}
			}
		}

		return output;
     */
}