package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.graph.Graph;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.BackPropagation;
import org.real2space.neumann.congraph.core.graph.BackPropagationPool;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class PartialDifferentiateOperation extends Operation {

    private Node target;
    private BackPropagationPool pool;
    private static BackPropagation backprop = BackPropagation.getInstance();
    private Graph graph;

    public PartialDifferentiateOperation(Node target, BackPropagationPool pool, Graph graph) {
        this.target = target;
        this.pool = pool;
        this.graph = graph;
    }

    @Override
    public Data execute() {
        this.backprop.execute(this.pool, this.graph);
        return this.pool.getData(this.target);
    }
}
