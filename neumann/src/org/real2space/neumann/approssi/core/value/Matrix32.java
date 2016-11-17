package org.real2space.neumann.approssi.core.value;

import java.util.Arrays;
import org.real2space.neumann.approssi.core.structure.Matrix;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/16
 */ 

public class Matrix32 implements Matrix<Float> {

    private float[][] matrix;
    
    public Matrix32 (float[][] matrix) {
        int N = matrix.length;
        this.matrix = new float[N][];
        for (int i = 0, M = matrix[0].length; i < N; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], M);
        }
    }

    /**
     * Add other matrix to this
     * @param other Matrix<Float>
     * @return void
     */
    public void add (Matrix<Float> other) {
        Matrix32 temp = (Matrix32)other;
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
     * @param other Matrix<Float>
     * @return void
     */
    public void subtract (Matrix<Float> other) {
        Matrix32 temp = (Matrix32)other;
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
     * @param other Matrix<Float>
     * @return void
     */
    public void multiply (Matrix<Float> other) {
        Matrix32 temp = (Matrix32)other;
        int N = this.matrix.length;
        int M = temp.matrix[0].length;
        float[][] mat = new float[N][M];
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
     * @param scalar Float
     * @return void
     */
    public void multiply (Float scalar) {
        float sca = scalar;
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
     * @param scalar Float
     * @return Float
     */
    public void divide (Float scalar) {
        float sca = 1f / scalar;
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
     * @return Float
     */
    public Float det () {
        return 0f;
    }
    
    /**
     * Get the trace of this matrix
     * @return Float
     */
    public Float trace () {
        return 0f;
    }
    
    /**
     * Transpose this matrix
     * @return void
     */
    public void transpose () {
        int N = this.matrix.length;
        int M = this.matrix[0].length;
        float[][] mat = new float[M][N];
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

     public Matrix32 deepCopy () {
         return new Matrix32(this.matrix);
     }
}