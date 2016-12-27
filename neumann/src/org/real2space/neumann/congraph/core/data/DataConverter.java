package org.real2space.neumann.congraph.core.data;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/28/16
 */
 
public class DataConverter {
    public static Data<Double> convert(double value) {
        return new DoubleData(value);
    }
    
    public static Data<Float> convert(float value) {
        return new FloatData(value);
    }
    
    public static Data<Matrix> convert(Matrix value) {
        return new MatrixData(value);
    }
    
    public static Data<Vector> convert(Vector value) {
        return new VectorData(value);
    }
}