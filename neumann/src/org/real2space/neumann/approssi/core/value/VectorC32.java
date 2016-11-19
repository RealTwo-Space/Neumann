package org.real2space.neumann.approssi.core.value;

import java.util.Arrays;
import org.real2space.neumann.approssi.core.structure.Vector;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/20
 */
 
public class VectorC32 implements Vector<Compelex32>{
    private Complex32[] vector;
    
    public VectorC32 (Complex32[] vector) {
        for (int i = 0, n = vector.length; i < n; i++) {
            this.vector[i] = vector.deepCopy();
        }
    }
    
    private void checkDimension (VectorC32 other) {
        if (this.vector.length != other.vector.length) {
            throw new ArithmeticException ("Wrong Dimension");
        }
    }
    
    /**
     * Add other to this.
     * @param other Vector<Complex32>
     * @return void
     */
    public void add (Vector<Complex32> other) {
        VectorC32 temp = (VectorC32)other;
        this.checkDimension(temp);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].add(temp.vector[i]);
        }
    }
    
    /**
     * Subtract other to this.
     * @param other Vector<Complex32>
     * @return void
     */
    public void subtract (Vector<Complex32> other) {
        VectorC32 temp = (VectorC32)other;
        this.checkDimension(temp);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].subtract(temp.vector[i]);
        }
    }
    
    /**
     * Multiply this scalar value to this.
     * @param scalar Complex32
     * @return void
     */
    public void multiply (Complex32 scalar) {
        Complex32 temp = scalar;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].multiply(temp);
        }
    }
    
    /**
     * Divide this vector by a scalar.
     * @param scalar Complex32
     * @return void
     */
    public void divide (Complex32 scalar) {
        Complex32 temp = new Complex32(1f, 0f);
        temp.divide(scalar);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].multiply(temp);
        }
    }
    
    /**
     *  Get eulidian norm.
     * @return Complex32
     */
    public Complex32 norm () {
        return null;
    }
    
    /**
     * Divide this by other.
     * @return void
     */
    public Matrix32 toMatrix () {
        Complex32[][] mat = new Complex32[1][];
        mat[0] = this.vector;
        return new Matrix32(mat);
    }

    public VectorC32 deepCopy () {
        return new VectorC32(this.vector);
    }

    public String toString () {
        return Arrays.toString(this.vector);
    }
}