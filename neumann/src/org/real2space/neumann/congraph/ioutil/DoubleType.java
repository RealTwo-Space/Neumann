package org.real2space.neumann.congraph.ioutil;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */
public class DoubleType implements DataType<Double> {
    private double data;
    public DoubleType(double value) {
        this.data = value;
    }
    public Double get() {
        return data;
    }
}
