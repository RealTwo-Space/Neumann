package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.graph.*;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */
public class PartialDifferentiateOperation extends Operation {
    private BackPropagationPool pool;
    private Node target;

    public PartialDifferentiateOperation(Node target, BackPropagationPool pool) {
        this.pool = pool;
        this.target = target;
    }

    @Override
    public Data execute() {
        return this.pool.getData(this.target);
    }
}
