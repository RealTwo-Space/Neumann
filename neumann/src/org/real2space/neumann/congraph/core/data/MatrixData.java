package org.real2space.neumann.congraph.core.data;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.structure.Vector;
import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/17/16
 */

public class MatrixData<F> implements Data<Matrix<F>> {
    private Matrix<F> data;
    
    public MatrixData (Matrix<F> data) {
        this.data = data;
    }
    
    public MatrixData (Vector<F> data) {
        this.data = data.toMatrix();
    }

    public Data<Matrix<F>> ZERO() {
        Matrix output = this.data.deepCopy();
        output.multiply(0.0);
        return new MatrixData<F>(output);
    }

    public Data<Matrix<F>> add(Data a) {
        Matrix output = this.data.deepCopy();
        output.add((Matrix)a.get());
        return new MatrixData<F>(output);
    }
    
    public Data<Matrix<F>> subtract(Data a) {
        Matrix output = this.data.deepCopy();
        output.subtract((Matrix)a.get());
        return new MatrixData<F>(output);
    }
    
    public Data<Matrix<F>> multiply(Data a) {
        Matrix output = this.data.deepCopy();
        if (a instanceof NumberData) {
            NumberData t = (NumberData)a;
            output.multiply(t.get());
        } else {
            output.multiply((Matrix)a.get());
        }
        return new MatrixData<F>(output);
    }
    
    public Data<Matrix<F>> divide(Data a) {
        Matrix output = this.data.deepCopy();
        NumberData t = (NumberData)a;
        output.divide(a.get());
        return new MatrixData<F>(output);
    }

    public Data<Matrix<F>> transpose() {
        Matrix output = this.data.deepCopy();
        output.transpose();
        return new MatrixData<F>(output);
    }

    public Data<Double> toScalar() {
        if (this.data.getRow() == 1 && this.data.getColumn() == 1) {
            return DataConverter.convert(this.data.get(0, 0));
        }
        return null;
    }
    
    public Matrix<F> get () {
        return this.data;
    }
    
    public Data<Matrix<F>> deepCopy() {
        return new MatrixData(this.data.deepCopy());
    }

    public String toString() {
        return this.data.toString();
    }
}