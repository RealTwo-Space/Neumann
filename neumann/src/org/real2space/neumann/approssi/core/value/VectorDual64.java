package org.real2space.neumann.approssi.core.value;

import java.util.Arrays;

import org.real2space.neumann.approssi.core.structure.DualNumber;
import org.real2space.neumann.approssi.core.structure.Vector;
import org.real2space.neumann.approssi.core.structure.Matrix;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/20
 */

public class VectorDual64 implements Vector<DualNumber64>{
    private DualNumber64[] vector;

    public VectorDual64 (DualNumber64[] vector) {
        for (int i = 0, n = vector.length; i < n; i++) {
            this.vector[i] = vector[i].deepCopy();
        }
    }

    private void checkDimension (VectorDual64 other) {
        if (this.vector.length != other.vector.length) {
            throw new ArithmeticException ("Wrong Dimension");
        }
    }

    /**
     * Add other to this.
     * @param other Vector<DualNumber64>
     * @return void
     */
    public void add (Vector<DualNumber64> other) {
        VectorDual64 temp = (VectorDual64)other;
        this.checkDimension(temp);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].add(temp.vector[i]);
        }
    }

    /**
     * Subtract other to this.
     * @param other Vector<DualNumber64>
     * @return void
     */
    public void subtract (Vector<DualNumber64> other) {
        VectorDual64 temp = (VectorDual64)other;
        this.checkDimension(temp);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].subtract(temp.vector[i]);
        }
    }

    /**
     * Multiply this scalar value to this.
     * @param scalar DualNumber64
     * @return void
     */
    public void multiply (DualNumber64 scalar) {
        DualNumber64 temp = scalar;
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].multiply(temp);
        }
    }

    /**
     * Divide this vector by a scalar.
     * @param scalar DualNumber64
     * @return void
     */
    public void divide (DualNumber64 scalar) {
        DualNumber64 temp = new DualNumber64(1f, 0f);
        temp.divide(scalar);
        for (int i = 0, n = vector.length; i < n; i++) {
            vector[i].multiply(temp);
        }
    }

    /**
     *  Get eulidian norm.
     * @return DualNumber64
     */
    public DualNumber64 norm () {
        return null;
    }

    /**
     * Divide this by other.
     * @return void
     */
    public Matrix<DualNumber64> toMatrix () {
        /*
        DualNumber64[][] mat = new DualNumber64[1][];
        mat[0] = this.vector;
        MatrixC32 res = new MatrixC32(mat);
        res.transpose();
        return new MatrixC32(mat);
        */
        return null;
    }

    public VectorDual64 deepCopy () {
        return new VectorDual64(this.vector);
    }

    public void set(int index, DualNumber64 value) {
        this.vector[index] = value;
    }

    public DualNumber64 get(int index) {
        return this.vector[index];
    }

    public int length() {
        return this.vector.length;
    }

    public String toString () {
        return Arrays.toString(this.vector);
    }
}
