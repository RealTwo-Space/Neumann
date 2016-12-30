package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Divide implements BinomialDifferentiation {
    public Data[] execute(Data a, Data b) {
        Data adiff = new DoubleData(1.0);
        adiff = adiff.divide(b);
        Data bdiff = a.deepCopy();
        bdiff = bdiff.multiply(new DoubleData(-1.0)).multiply(adiff).multiply(adiff);
        return new Data[] {adiff , bdiff};
    }
}
