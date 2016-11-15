package org.real2space.neumann.approssi.core.value;

import org.real2space.neumann.approssi.core.structure.Vector;
import java.util.Arrays;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/14
 */

public class Vector32 implements Vector<Float> {
    private float[] vector;
    
    public Vector32 (float[] vector) {
        this.vector = Arrays.copyOf(vector, vector.length);
    }
    
    /**
     * Add other to this.
     * @param other Vector<Float>
     * @return void
     */
    public void add (Vector<Float> other) {
        Vector32 temp = (Vector32) other;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i] += temp.vector[i];
        }
    }
    
    /**
     * Subtract other to this.
     * @param other Vector<E>
     * @return void
     */
    public void subtract (Vector<Float> other) {
        Vector32 temp = (Vector32) other;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i] -= temp.vector[i];
        }
    }
    
    /**
     * Multiply this scalar value to this.
     * @param scalar Float
     * @return void
     */
    public void multiply (Float scalar) {
        float temp = scalar;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i] *= temp;
        }
    }
    
    /**
     * Divide this vector by a scalar.
     * @param scalar Float
     * @return void
     */
    public void divide (Float scalar) {
        float temp = 1f / scalar;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i] *= temp;
        }
    }
    
    /**
     *  Get eulidian norm.
     * @return Float
     */
    public Float norm () {
        return 0f;
    }
    
    /**
     * Divide this by other.
     * @return void
     */
    public Matrix32 toMatrix () {
        return new Matrix32();
    }

    public Vector32 deepCopy () {
        return new Vector32(this.vector);
    }
}