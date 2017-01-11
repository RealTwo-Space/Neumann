package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.State;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public interface BinomialDifferentiation {
    // ここのexecuteの引数とか色々を考える．２つのNodeを渡してやるのかどうか．．
    Tensor[] execute(Tensor own, Tensor a, Tensor b);
}
