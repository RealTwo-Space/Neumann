package org.real2space.neumann.congraph.core.data;

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
    
    public Double get() {
        return this.data;
    }
}