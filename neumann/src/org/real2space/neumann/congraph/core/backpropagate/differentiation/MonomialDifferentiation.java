package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public interface MonomialDifferentiation {
    Tensor execute(Tensor own, Tensor a);
}
