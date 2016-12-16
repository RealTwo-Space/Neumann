package org.real2space.neumann.congraph.core.data;

import org.real2space.neumann.approssi.core.structure.Vector;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/17/16
 */

public class VectorData<F> implements Data<Vector<F>> {
    private Vector<F> data;
    
    public VectorData (Vector<F> data) {
        this.data = data;
    }
    
    public Data<Vector<F>> add(Data a) {
        Vector output = this.data.deepCopy();
        output.add((Vector)a.get());
        return new VectorData<F>(output);
    }
    
    public Data<Vector<F>> subtract(Data a) {
        Vector output = this.data.deepCopy();
        output.subtract((Vector)a.get());
        return new VectorData<F>(output);
    }
    
    public Data<Vector<F>> multiply(Data a) {
        Vector output = this.data.deepCopy();
        NumberData t = (NumberData)a;
        output.divide(a.get());
        return new VectorData<F>(output);
    }
    
    public Data<Vector<F>> divide(Data a) {
        Vector output = this.data.deepCopy();
        NumberData t = (NumberData)a;
        output.divide(a.get());
        return new VectorData<F>(output);
    }
    
    public Vector<F> get () {
        return this.data;
    }
}