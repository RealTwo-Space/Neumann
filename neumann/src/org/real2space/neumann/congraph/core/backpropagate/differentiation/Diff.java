package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.graph.Operation;
import org.real2space.neumann.congraph.core.graph.State;
import org.real2space.neumann.congraph.core.operation.AddOperation;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public enum Diff {
    ADD(new Add(), new AddOperation(null, null));

    private final Differentiation diff;
    private final Operation op;

    private Diff(final Differentiation diff, final Operation op) {
        this.diff = diff;
        this.op = op;
    }

    public static Diff valueOf(Operation op) {
        for (Diff diff : values()) {
            if (diff.getOperation().getClass() == op.getClass()) { // id が一致するものを探す
                return diff;
            }
        }
        throw new IllegalArgumentException("no such operation which implemented partial differentiation");
    }

    private Operation getOperation() {
        return this.op;
    }

    public Differentiation getDifferentiation() {
        return this.diff;
    }

}
