package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.graph.Graph;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.BackPropagation;
import org.real2space.neumann.congraph.core.graph.BackPropagationPool;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class BackPropagateOperation extends Operation {

    private BackPropagationPool pool;
    private static BackPropagation backprop = BackPropagation.getInstance();
    private Graph graph;

    public BackPropagateOperation(BackPropagationPool pool, Graph graph) {
        this.pool = pool;
        this.graph = graph;
    }

    @Override
    public Data execute() {
        this.backprop.execute(this.pool, this.graph);
        return new DoubleData(0.0);
    }
}
