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
        neg = neg.expand(own.shape());
        Tensor pos = new Tensor(1.0);
        pos = pos.expand(own.shape());

        if (a.shape().rank() == 0) {
            tempA = a.expand(own.shape());
        } else {
            tempA = a;
        }

        if (b.shape().rank() == 0) {
            tempB = b.expand(own.shape());
        } else {
            tempB = b;
        }

        return new Tensor[] {
                own.multiply(pos.divide(tempB)),
                own.multiply(neg.multiply(tempA).divide(tempB.multiply(tempB)))
        };
    }
}
