package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Multiply implements BinomialDifferentiation {
    public Data[] execute(Data a, Data b) {
        return new Data[] {b.deepCopy(), a.deepCopy()};
    }
}
