package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.graph.BinomialArgument;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class EntrywizeDivideOperation extends Operation {
    private BinomialArgument arg;

    public EntrywizeDivideOperation(Node a, Node b) {
        this.arg = new BinomialArgument(a, b);
    }

    public Data execute() {
        MatrixData a = (MatrixData) arg.getDataAt(0);
        return a.entrywizeDivide(arg.getDataAt(1));
    }
}
