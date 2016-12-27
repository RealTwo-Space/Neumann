package org.real2space.neumann.congraph.core.data;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/17/16
 */
 
public class FloatData implements NumberData<Float> {
    private float data;
    
    public FloatData (float data) {
        this.data = data;
    }
    
    public Data<Float> add(Data a) {
        float output = this.data;
        output += (float)a.get();
        return new FloatData(output);
    }
    
    public Data<Float> subtract(Data a) {
        float output = this.data;
        output -= (float)a.get();
        return new FloatData(output);
    }
    
    public Data<Float> multiply(Data a) {
        float output = this.data;
        output *= (float)a.get();
        return new FloatData(output);
    }
    
    public Data<Float> divide(Data a) {
        float output = this.data;
        output /= (float)a.get();
        return new FloatData(output);
    }
    
    public Float get() {
        return this.data;
    }
    
    public Data<Float> deepCopy() {
        return new FloatData(this.data);
    }

    public String toString() {
        return "" + this.data;
    }
}