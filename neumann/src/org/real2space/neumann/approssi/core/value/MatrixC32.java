package org.real2space.neumann.approssi.core.value;

import org.real2space.neumann.approssi.core.structure.Matrix;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/20
 */
 
public class MatrixC32 implements Matrix<Complex32> {
    private Complex32[][] matrix;
    
    public MatrixC32 (Complex32[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        this.matrix = new Complex32[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.matrix[i][j] = matrix[i][j].deepCopy();
            }
        }
    }
    
    private void checkDimensionAdd (MatrixC32 other) {
        if (this.matrix.length != other.matrix.length || this.matrix[0].length != other.matrix[0].length) {
            throw new ArithmeticException("Wrong Dimension");
        }
    }

    private void checkDimensionMult (MatrixC32 other) {
        if (this.matrix[0].length != other.matrix.length) {
            throw new ArithmeticException("Wrong Dimension");
        }
    }

    public int getRow() {
        return this.matrix.length;
    }

    public int getColumn() {
        return this.matrix[0].length;
    }

    public Complex32 get(int row, int column) {
        return this.matrix[row][column];
    }

    @Override
    public void set(int row, int column, Complex32 value) {

    }

    /**
     * Add other matrix to this
     * @param other Matrix<Complex32>
     * @return void
     */
    public void add (Matrix<Complex32> other) {
        MatrixC32 temp = (MatrixC32)other;
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
     * @param other Matrix<Complex32>
     * @return void
     */
    public void subtract (Matrix<Complex32> other) {
        MatrixC32 temp = (MatrixC32)other;
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
     * @param other Matrix<Complex32>
     * @return void
     */
    public void multiply (Matrix<Complex32> other) {
        MatrixC32 temp = (MatrixC32)other;
        this.checkDimensionMult(temp);
        int N = this.matrix.length;
        int M = temp.matrix[0].length;
        Complex32[][] mat = new Complex32[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = new Complex32(0f, 0f);
                for (int k = 0; k < M; k++) {
                    mat[i][j].add(Complex32.multiply(this.matrix[i][k], temp.matrix[k][j]));
                }
            }
        }
        this.matrix = mat;
    }
    
    /**
     * Multiply scalar to this matrix
     * @param scalar Complex32
     * @return void
     */
    public void multiply (Complex32 scalar) {
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
     * @param scalar Complex32
     * @return MatrixC32
     */
    public void divide (Complex32 scalar) {
        Complex32 sca = new Complex32(1f, 0f);
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
     * @return Complex32
     */
    public Complex32 det () {
        return null;
    }
    
    /**
     * Get the trace of this matrix
     * @return Complex32
     */
    public Complex32 trace () {
        return null;
    }
    
    /**
     * Transpose this matrix
     * @return void
     */
    public void transpose () {
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        Complex32[][] mat = new Complex32[M][N];
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

    public MatrixC32 deepCopy () {
        return new MatrixC32(this.matrix);
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