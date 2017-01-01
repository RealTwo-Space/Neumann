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
 
public class DoubleData implements NumberData<Double> {
    private double data;
    
    public DoubleData (double data) {
        this.data = data;
    }

    public DoubleData(Double data) {
        this.data = data;
    }

    public Data<Double> ZERO() {
        return new DoubleData(0.0);
    }

    public Data<Double> ONE() {
        return new DoubleData(1.0);
    }
    
    public Data<Double> add(Data a) {
        double output = this.data;
        output += (double)a.get();
        return new DoubleData(output);
    }
    
    public Data<Double> subtract(Data a) {
        double output = this.data;
        output -= (double)a.get();
        return new DoubleData(output);
    }
    
    public Data<Double> multiply(Data a) {
        double output = this.data;
        output *= (double)a.get();
        return new DoubleData(output);
    }
    
    public Data<Double> divide(Data a) {
        double output = this.data;
        output /= (double)a.get();
        return new DoubleData(output);
    }

    public Data<Double> activate(ActivationFunction func) {
        return new DoubleData(func.activate(this.data));
    }

    public Data<Double> activateDiff(ActivationFunction func) {
        return new DoubleData(func.activateDiff(this.data));
    }
    
    public Double get() {
        return this.data;
    }
    
    public Data<Double> deepCopy() {
        return new DoubleData(this.data);
    }

    public String toString() {
        return "" + this.data;
    }
}