package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.data.NumberData;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class Multiply implements BinomialDifferentiation {
    public Data[] execute(Data own, Data a, Data b) {
        Data outA, outB, operandA;
        System.out.println("own :\n" + own);
        System.out.println("a : \n" + a);
        System.out.println("b : \n" + b);
        if (own instanceof NumberData) {
            if (b instanceof MatrixData && a instanceof MatrixData) {
                System.out.println("34a");
                outA = b.multiply(own);
                outB = a.multiply(own);
                MatrixData mat = (MatrixData) outA;
                outA = mat.transpose();
                mat = (MatrixData) outB;
                outB = mat.transpose();
                System.out.println("34");
            } else {
                System.out.println("1234a");
                outA = b.multiply(own);
                outB = a.multiply(own);
                System.out.println("1234");
            }
        } else {
            if (b instanceof MatrixData && a instanceof MatrixData) {
                System.out.println("12345a");
                MatrixData mat = (MatrixData)b;
                operandA = mat.transpose();

                mat = (MatrixData)a;
                Data operandB = mat.transpose();
                outB = operandB.multiply(own);
                System.out.println("12345");
            } else {
                System.out.println("123456a");
                operandA = b;
                System.out.println(own);
                System.out.println(a);
                System.out.println(b);
                outB = own.multiply(a);
                System.out.println("123456");
            }
            System.out.println("123");
            outA = own.multiply(operandA);
        }

        return new Data[] {outA, outB};
    }

}
