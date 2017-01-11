package playground.Util;

import org.real2space.neumann.congraph.core.data.DoubleData;

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
