package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */
public class MatrixMultiply implements BinomialDifferentiation {
    @Override
    public Tensor[] execute(Tensor own, Tensor a, Tensor b) {

        return new Tensor[]{
                own.matrixMultiply(b.transpose()),
                a.transpose().matrixMultiply(own)
        };
    }
}
