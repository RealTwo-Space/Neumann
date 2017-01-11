package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DataConverter;
import org.real2space.neumann.congraph.core.graph.MonomialArgument;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */
public class SumOperation extends Operation {
    private MonomialArgument arg;
    public SumOperation(Node node) {
        this.arg = new MonomialArgument(node);
    }
    @Override
    public Data execute() {
        Tensor temp = Tensor.convert(this.arg.getDataAt(0));
        return DataConverter.convert(temp.reduceSum().toScalar());
    }
}
