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
 
public class VectorC64 implements Vector<Complex64>{
    private Complex64[] vector;
    
    public VectorC64 (Complex64[] vector) {
        for (int i = 0, n = vector.length; i < n; i++) {
            this.vector[i] = vector[i].deepCopy();
        }
    }
    
    private void checkDimension (VectorC64 other) {
        if (this.vector.length != other.vector.length) {
            throw new ArithmeticException ("Wrong Dimension");
        }
    }
    
    /**
     * Add other to this.
     * @param other Vector<Complex64>
     * @return void
     */
    public void add (Vector<Complex64> other) {
        VectorC64 temp = (VectorC64)other;
        this.checkDimension(temp);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].add(temp.vector[i]);
        }
    }
    
    /**
     * Subtract other to this.
     * @param other Vector<Complex64>
     * @return void
     */
    public void subtract (Vector<Complex64> other) {
        VectorC64 temp = (VectorC64)other;
        this.checkDimension(temp);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].subtract(temp.vector[i]);
        }
    }
    
    /**
     * Multiply this scalar value to this.
     * @param scalar Complex64
     * @return void
     */
    public void multiply (Complex64 scalar) {
        Complex64 temp = scalar;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].multiply(temp);
        }
    }
    
    /**
     * Divide this vector by a scalar.
     * @param scalar Complex64
     * @return void
     */
    public void divide (Complex64 scalar) {
        Complex64 temp = new Complex64(1.0, 0.0);
        temp.divide(scalar);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].multiply(temp);
        }
    }
    
    /**
     *  Get eulidian norm.
     * @return Complex64
     */
    public Complex64 norm () {
        return null;
    }
    
    /**
     * Divide this by other.
     * @return void
     */
    public MatrixC64 toMatrix () {
        Complex64[][] mat = new Complex64[1][];
        mat[0] = this.vector;
        return new MatrixC64(mat);
    }

    public VectorC64 deepCopy () {
        return new VectorC64(this.vector);
    }

    public String toString () {
        return Arrays.toString(this.vector);
    }
}