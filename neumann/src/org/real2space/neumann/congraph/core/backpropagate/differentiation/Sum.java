package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import jdk.internal.dynalink.MonomorphicCallSite;
import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */

/*
    Sum Differentiation

    d(sum of A's elements)/dA = tensor whose elements are all "1"
    dE/dA = tensor whose elements are all "own" because own is 0-rank tensor).
    return dE/dA
 */

public class Sum implements MonomialDifferentiation {
    @Override
    public Tensor execute(Tensor own, Tensor a) {
        Tensor res = own.expand(a.shape());
        return res;
    }
}
