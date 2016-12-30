package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.Operation;
import org.real2space.neumann.congraph.core.operation.AddOperation;
import org.real2space.neumann.congraph.core.operation.DivideOperation;
import org.real2space.neumann.congraph.core.operation.MultiplyOperation;
import org.real2space.neumann.congraph.core.operation.SubtractOperation;


/**
 * Created by ryosukesuzuki on 2016/12/30.
 */

public enum Diff {
    ADD(new Add(), new AddOperation(null, null)),
    SUBTRACT(new Subtract(), new SubtractOperation(null, null)),
    MULTIPLY(new Multiply(), new MultiplyOperation(null, null)),
    DIVIDE(new Divide(), new DivideOperation(null, null));

    private final BinomialDifferentiation biDiff;
    private final Operation op;
    private final MonomialDifferentiation monoDiff;
    private final int size;

    private Diff(final BinomialDifferentiation diff, final Operation op) {
        this.biDiff = diff;
        this.op = op;
        this.monoDiff = null;
        this.size = 2;
    }

    private Diff(final MonomialDifferentiation diff, final Operation op) {
        this.monoDiff = diff;
        this.op = op;
        this.biDiff = null;
        this.size = 1;
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

    public Data[] execute(Data... datas) {
        if (this.size == 1) {
            return new Data[] {this.monoDiff.execute(datas[0])};
        } else if (this.size == 2) {
            return this.biDiff.execute(datas[0], datas[1]);
        }

        return null;
    }

    public int getSize() {
        return this.size;
    }

}
