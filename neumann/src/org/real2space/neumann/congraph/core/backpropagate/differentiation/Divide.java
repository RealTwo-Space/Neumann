package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.data.NumberData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Divide implements BinomialDifferentiation {
    public Data[] execute(Data own, Data a, Data b) {
        Data adiff = new DoubleData(1.0);
        adiff = adiff.divide(b);
        Data bdiff = a.deepCopy();
        bdiff = bdiff.multiply(new DoubleData(-1.0)).multiply(adiff).multiply(adiff);
        Data outB;
        if (own instanceof NumberData) {
            outB = bdiff.multiply(own);
        } else {
            outB = own.multiply(bdiff);
        }

        return new Data[] {own.multiply(adiff), outB};
    }
}
