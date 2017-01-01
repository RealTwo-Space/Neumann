package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.data.NumberData;
import org.real2space.neumann.congraph.core.function.Activation;
import org.real2space.neumann.congraph.core.function.ActivationFunction;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class Activate implements MonomialDifferentiation {
    private ActivationFunction func;

    public Activate(Activation func) {
        this.func = func.get();
    }

    public Activate() {
    }

    void setActivate(ActivationFunction func) {
        this.func = func;
    }

    public Data execute(Data own, Data a) {
        Data data = a.activateDiff(this.func);
        Data out;
        if (own instanceof NumberData) {
            return data.multiply(own);
        } else {
            if (a instanceof MatrixData) {
                MatrixData mat = (MatrixData) data;
                return mat.entrywizeMultiply(own);
            } else {
                return own.multiply(data);
            }
        }
    }
}
