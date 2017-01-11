package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Subtract implements BinomialDifferentiation {
    public Tensor[] execute(Tensor own, Tensor a, Tensor b) {
        Tensor neg = new Tensor(-1.0);
        return new Tensor[] {own, own.multiply(neg.expand(own.shape()))};
    }
}
