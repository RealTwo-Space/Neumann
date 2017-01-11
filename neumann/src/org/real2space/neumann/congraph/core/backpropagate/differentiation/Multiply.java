package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.data.NumberData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Multiply implements BinomialDifferentiation {
    public Tensor[] execute(Tensor own, Tensor a, Tensor b) {
        Tensor tempA, tempB;
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
                own.multiply(tempB), own.multiply(tempA)
        };
    }
}
