package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.State;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */

/*
    Binomial Differentiation

    E = target.
    C = A (operation) B.  (e.g. C = A + B)
    dE/dC = own
    dE/dA = dE/dC * dC/dA
    dE/dB = dE/dC * dC/dB
    return {dE/dA, dE/dB}

 */
public interface BinomialDifferentiation {

    Tensor[] execute(Tensor own, Tensor a, Tensor b);
}
