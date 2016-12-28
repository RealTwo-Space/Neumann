package org.real2space.neumann.congraph.core.data;

import org.real2space.neumann.approssi.core.structure.DualNumber;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/28/16
 */

public class DualNumberData<F> implements Data<DualNumber<F>> {
    private DualNumber<F> data;
    
    public DualNumberData (DualNumber<F> data) {
        this.data = data;
    }
    
    public Data<DualNumber<F>> add(Data a) {
        DualNumber output = this.data.deepCopy();
        output.add((DualNumber)a.get());
        return new DualNumberData<F>(output);
    }
    
    public Data<DualNumber<F>> subtract(Data a) {
        DualNumber output = this.data.deepCopy();
        output.subtract((DualNumber)a.get());
        return new DualNumberData<F>(output);
    }
    
    public Data<DualNumber<F>> multiply(Data a) {
        DualNumber output = this.data.deepCopy();
        output.multiply((DualNumber)a.get());
        return new DualNumberData<F>(output);   
    }
    
    public Data<DualNumber<F>> divide(Data a) {
        DualNumber output = this.data.deepCopy();
        output.divide((DualNumber)a.get());
        return new DualNumberData<F>(output);
    }
    
    public DualNumber<F> get () {
        return this.data;
    }
    
    public Data<DualNumber<F>> deepCopy() {
        return new DualNumberData(this.data.deepCopy());
    }

    public String toString() {
        return this.data.toString();
    }
}