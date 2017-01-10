package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.backpropagate.differentiation.NormSquared;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.data.NumberData;
import org.real2space.neumann.congraph.core.graph.MonomialArgument;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class NormSquaredOperation extends Operation {

    private MonomialArgument arg;

    public NormSquaredOperation(Node node) {
        this.arg = new MonomialArgument(node);
    }

    @Override
    public Data execute() {
        Data temp = this.arg.getDataAt(0);
        if (temp instanceof NumberData) {
            return temp.multiply(temp);
        }
        MatrixData data = (MatrixData) temp;
        if (data.getRow() != 1) {
            return data.transpose().multiply(data);
        }
        return data.multiply(data.transpose());
    }
}
