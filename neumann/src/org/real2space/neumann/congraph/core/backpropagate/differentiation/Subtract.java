package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Subtract implements BinomialDifferentiation {
    public Data[] execute(Data a, Data b) {
        return new Data[] {new DoubleData(1.0), new DoubleData(-1.0) };
    }
}
