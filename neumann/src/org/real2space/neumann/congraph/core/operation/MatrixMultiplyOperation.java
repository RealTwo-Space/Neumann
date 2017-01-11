package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.graph.BinomialArgument;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */
public class MatrixMultiplyOperation extends Operation {
    private BinomialArgument args;

    public MatrixMultiplyOperation(Node a, Node b) {
        this.args = new BinomialArgument(a, b);
    }
    @Override
    public Data execute() {
        MatrixData matA = (MatrixData) this.args.getDataAt(0);
        return matA.matrixMultiply(this.args.getDataAt(1));
    }
}
