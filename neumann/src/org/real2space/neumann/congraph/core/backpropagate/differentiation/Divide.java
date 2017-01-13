package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.data.NumberData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Divide implements BinomialDifferentiation {
    public Tensor[] execute(Tensor own, Tensor a, Tensor b) {
        Tensor tempA, tempB;
        Tensor neg = new Tensor(-1.0);
        Tensor pos = new Tensor(1.0);

        return new Tensor[] {
                own.multiply(pos.divide(b)),
                own.multiply(neg.multiply(a).divide(b.multiply(b)))
        };
    }
}
