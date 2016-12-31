package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.data.NumberData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Multiply implements BinomialDifferentiation {
    public Data[] execute(Data own, Data a, Data b) {
        Data outA, outB, operandA;

        if (own instanceof NumberData) {
            outA = b.multiply(own);
            outB = a.multiply(own);
        } else {
            if (b instanceof MatrixData) {
                MatrixData mat = (MatrixData)b;
                operandA = mat.transpose();

                mat = (MatrixData)a;
                Data operandB = mat.transpose();
                outB = operandB.multiply(own);
            } else {
                operandA = b;
                outB = own.multiply(a);
            }
            outA = own.multiply(operandA);
        }

        return new Data[] {outA, outB};
    }
}
