package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Subtract implements BinomialDifferentiation {
    public Data[] execute(Data own, Data a, Data b) {
        Data outA = own.deepCopy();
        Data outB = outA.multiply(new DoubleData(-1.0));
        return new Data[] {outA, outB};
    }
}
