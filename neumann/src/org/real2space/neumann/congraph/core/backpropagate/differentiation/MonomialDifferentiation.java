package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */

/*
    Monomial Differentiation

    E = target.
    C = f(A).  (e.g. C = sin(A), C = sum of A's element)
    dE/dC = own
    dE/dA = dE/dC * dC/dA
    return {dE/dA}

 */
public interface MonomialDifferentiation {
    Tensor execute(Tensor own, Tensor a);
}
