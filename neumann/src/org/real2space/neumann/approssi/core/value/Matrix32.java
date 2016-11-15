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
    
    public Matrix32 () {
        
    }

    /**
     * Add other matrix to this
     * @param other Matrix<Float>
     * @return void
     */
    public void add (Matrix<Float> other) {
        
    }
    
    /**
     * Subtract other matrix from this
     * @param other Matrix<Float>
     * @return void
     */
    public void subtract (Matrix<Float> other) {
        
    }
    
    /**
     * Multiply other matrix
     * @param other Matrix<Float>
     * @return void
     */
    public void multiply (Matrix<Float> other) {
        
    }
    
    /**
     * Multiply scalar to this matrix
     * @param scalar Float
     * @return void
     */
    public void multiply (Float scalar) {
        
    }
    
    /**
     * Divide this matrix by scalar
     * @param scalar Float
     * @return Float
     */
    public void divide (Float scalar) {
        
    }
    
    /**
     * Calculate (this matrix)^(non-negative integer)
     * @param exponent int
     * @return void
     */
    public void power (int exponent) {
        
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
        
    }
    
    /**
     * Transpose this matrix
     * @return void
     */
     public void inverse () {
         
     }

     public Matrix32 deepCopy () {
         return new Matrix32();
     }
}