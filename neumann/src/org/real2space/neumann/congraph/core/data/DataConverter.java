package org.real2space.neumann.congraph.core.data;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.structure.Vector;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    public static Data convert (Object value) {
        if (value instanceof Double) {
            return convert((Double)value);
        }
        else if (value instanceof Float) {
            return convert((Float)value);
        }
        else if (value instanceof Matrix) {
            return convert((Matrix)value);
        }
        else if (value instanceof Vector) {
            return convert(value);
        }

        throw new NotImplementedException();
    }
}