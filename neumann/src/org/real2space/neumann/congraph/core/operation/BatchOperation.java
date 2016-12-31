package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.graph.MultinomialArgument;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */

// execute multi node.
public class BatchOperation extends Operation {
    private MultinomialArgument args;

    public BatchOperation(Node... nodes) {
        this.args = new MultinomialArgument(nodes);
    }

    @Override
    public Data execute() {
        return new DoubleData(1.0);
    }
}
