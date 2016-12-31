package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.data.NumberData;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class NormSquared implements MonomialDifferentiation {
    @Override
    public Data execute(Data own, Data a) {
        return a.multiply(new DoubleData(2.0)).multiply(own);

    }
}
