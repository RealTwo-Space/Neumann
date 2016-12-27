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

public class Vector64 implements Vector<Double>{
    private double[] vector;

    public Vector64 (double[] vector) {
        this.vector = Arrays.copyOf(vector, vector.length);
    }


    private void checkDimension (Vector64 other) {
        if (this.vector.length != other.vector.length) {
            throw new ArithmeticException ("Wrong Dimension");
        }
    }

    /**
     * Add other to this.
     * @param other Vector<Double>
     * @return void
     */
    public void add (Vector<Double> other) {
        Vector64 temp = (Vector64) other;
        this.checkDimension(temp);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i] += temp.vector[i];
        }
    }

    /**
     * Subtract other to this.
     * @param other Vector<Double>
     * @return void
     */
    public void subtract (Vector<Double> other) {
        Vector64 temp = (Vector64) other;
        this.checkDimension(temp);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i] -= temp.vector[i];
        }
    }

    /**
     * Multiply this scalar value to this.
     * @param scalar Double
     * @return void
     */
    public void multiply (Double scalar) {
        double temp = scalar;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i] *= temp;
        }
    }

    /**
     * Divide this vector by a scalar.
     * @param scalar Double
     * @return void
     */
    public void divide (Double scalar) {
        double temp = 1 / scalar;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i] *= temp;
        }
    }

    /**
     *  Get eulidian norm.
     * @return Double
     */
    public Double norm () {
        return 0.0;
    }

    /**
     * Divide this by other.
     * @return void
     */
    public Matrix64 toMatrix () {
        double[][] mat = new double[1][];
        mat[0] = this.vector;
        Matrix64 res = new Matrix64(mat);
        res.transpose();
        return new Matrix64(mat);
    }

    public Vector64 deepCopy () {
        return new Vector64(this.vector);
    }

    public String toString () {
        return Arrays.toString(this.vector);
    }
}