package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.function.Activation;
import org.real2space.neumann.congraph.core.graph.MonomialArgument;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class CosOperation extends Operation {
    private MonomialArgument arg;

    public CosOperation(Node node) {
        this.arg = new MonomialArgument(node);
    }

    @Override
    public Data execute() {
        return this.arg.getDataAt(0).activate(Activation.COS.get());
    }
}
