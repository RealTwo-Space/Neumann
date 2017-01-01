package org.real2space.neumann.congraph.core.data;

import org.real2space.neumann.congraph.core.function.Activation;
import org.real2space.neumann.congraph.core.function.ActivationFunction;

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

    @Override
    public Data<Float> ZERO() {
        return new FloatData(0f);
    }

    @Override
    public Data<Float> ONE() {
        return new FloatData(1.0f);
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

    public Data<Float> activate(ActivationFunction func) {
        return new FloatData((float)func.activate(this.data));
    }

    public Data<Float> activateDiff(ActivationFunction func) {
        return new FloatData((float)func.activateDiff(this.data));
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