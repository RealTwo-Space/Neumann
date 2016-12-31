package org.real2space.neumann.congraph.core.backpropagate.differentiation;


import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.data.NumberData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Add implements BinomialDifferentiation {
    public Data[] execute(Data own, Data a, Data b) {
        return new Data[] {own.deepCopy(), own.deepCopy()};
    }
}
