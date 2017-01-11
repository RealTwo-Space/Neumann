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
public class Sum implements MonomialDifferentiation {
    @Override
    public Tensor execute(Tensor own, Tensor a) {
        Tensor res = own.expand(a.shape());
        return res;
    }
}
