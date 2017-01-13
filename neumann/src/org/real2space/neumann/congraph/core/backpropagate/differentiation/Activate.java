package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.data.NumberData;
import org.real2space.neumann.congraph.core.function.Activation;
import org.real2space.neumann.congraph.core.function.ActivationFunction;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */

/*

    Activate differentiation

    return own * F'(A)

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

    public Tensor execute(Tensor own, Tensor a) {
        return own.multiply(a.activateDiff(this.func));
    }
}
