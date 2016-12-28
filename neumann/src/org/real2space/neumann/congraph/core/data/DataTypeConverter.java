package org.real2space.neumann.congraph.core.data;

import org.real2space.neumann.approssi.core.value.DualNumber32;
import org.real2space.neumann.approssi.core.value.DualNumber64;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 12/28/16
 */
public class DataTypeConverter {
    // DoubleData -> DualNumberData
    public static DualNumberData convert (DoubleData data) {
        DualNumberData res = new DualNumberData(new DualNumber64(data.get(), 0.0));
        return res;
    }

    // FloatData -> DualNumberData
    public static DualNumberData convert (FloatData data) {
        DualNumberData res = new DualNumberData(new DualNumber32(data.get(), 0.0f));
        return res;
    }

    public static DualNumberData convert (Data data) {
        if (data instanceof DoubleData) {
            return convert((DoubleData)data);
        }
        else if (data instanceof FloatData) {
            return convert((FloatData)data);
        }

        throw new NotImplementedException();
    }
}

/*
 *
 * m - x         <- (x + e, y    , z    )
 *   L m - y     <- (x    , y + e, z    )
 *       L z     <- (x    , y    , z + e)
 *
 * f(x, y, z) = xyz
 *
 *
 */
