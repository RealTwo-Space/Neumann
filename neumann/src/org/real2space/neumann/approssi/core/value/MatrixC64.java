package org.real2space.neumann.approssi.core.value;

import org.real2space.neumann.approssi.core.structure.Matrix;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/20
 */
 
public class MatrixC64 implements Matrix<Complex64> {
    private Complex64[][] matrix;
    
    public MatrixC64 (Complex64[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        this.matrix = new Complex64[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j] = matrix[i][j].deepCopy();
            }
        }
    }
    
    private void checkDimensionAdd (MatrixC64 other) {
        if (this.matrix.length != other.matrix.length || this.matrix[0].length != other.matrix[0].length) {
            throw new ArithmeticException("Wrong Dimension");
        }
    }

    private void checkDimensionMult (MatrixC64 other) {
        if (this.matrix[0].length != other.matrix.length) {
            throw new ArithmeticException("Wrong Dimension");
        }
    }

    /**
     * Add other matrix to this
     * @param other Matrix<Complex64>
     * @return void
     */
    public void add (Matrix<Complex64> other) {
        MatrixC64 temp = (MatrixC64)other;
        this.checkDimensionAdd(temp);
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j].add(temp.matrix[i][j]);
            }
        }
    }
    
    /**
     * Subtract other matrix from this
     * @param other Matrix<Complex64>
     * @return void
     */
    public void subtract (Matrix<Complex64> other) {
        MatrixC64 temp = (MatrixC64)other;
        this.checkDimensionAdd(temp);
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j].subtract(temp.matrix[i][j]);
            }
        }
    }
    
    /**
     * Multiply other matrix
     * @param other Matrix<Complex64>
     * @return void
     */
    public void multiply (Matrix<Complex64> other) {
        MatrixC64 temp = (MatrixC64)other;
        this.checkDimensionMult(temp);
        int N = this.matrix.length;
        int M = temp.matrix[0].length;
        Complex64[][] mat = new Complex64[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = new Complex64(0.0, 0.0);
                for (int k = 0; k < M; k++) {
                    mat[i][j].add(Complex64.multiply(this.matrix[i][k], temp.matrix[k][j]));
                }
            }
        }
        this.matrix = mat;
    }
    
    /**
     * Multiply scalar to this matrix
     * @param scalar Complex64
     * @return void
     */
    public void multiply (Complex64 scalar) {
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j].multiply(scalar);
            }
        }
    }
    
    /**
     * Divide this matrix by scalar
     * @param scalar Complex64
     * @return MatrixC64
     */
    public void divide (Complex64 scalar) {
        Complex64 sca = new Complex64(1.0, 0.0);
        sca.divide(scalar);
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j].multiply(sca);
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
     * @return Complex64
     */
    public Complex64 det () {
        return null;
    }
    
    /**
     * Get the trace of this matrix
     * @return Complex64
     */
    public Complex64 trace () {
        return null;
    }
    
    /**
     * Transpose this matrix
     * @return void
     */
    public void transpose () {
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        Complex64[][] mat = new Complex64[M][N];
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

    public MatrixC64 deepCopy () {
        return new MatrixC64(this.matrix);
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