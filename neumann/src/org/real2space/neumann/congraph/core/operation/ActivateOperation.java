package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.function.Activation;
import org.real2space.neumann.congraph.core.function.ActivationFunction;
import org.real2space.neumann.congraph.core.graph.MonomialArgument;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class ActivateOperation extends Operation {
    private MonomialArgument arg;
    private ActivationFunction func;
    public ActivateOperation(Node node) {
        this.arg = new MonomialArgument(node);
    }
    public ActivateOperation(Node node, ActivationFunction func) {
        this.arg = new MonomialArgument(node);
        this.func = func;
    }


    public void setActivationFunction(ActivationFunction func) {
        this.func = func;
    }

    public ActivationFunction getActivationFunction() {
        return this.func;
    }


    @Override
    public Data execute() {
        return this.arg.getDataAt(0).activate(func);
    }
}
