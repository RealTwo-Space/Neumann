package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.function.Activation;
import org.real2space.neumann.congraph.core.graph.Operation;
import org.real2space.neumann.congraph.core.operation.*;


/**
 * Created by ryosukesuzuki on 2016/12/30.
 */

public enum Diff {
    DIFINITION(new Activate(), new ActivateOperation(null)),
    ADD(new Add(), new AddOperation(null, null)),
    SUBTRACT(new Subtract(), new SubtractOperation(null, null)),
    MULTIPLY(new Multiply(), new MultiplyOperation(null, null)),
    DIVIDE(new Divide(), new DivideOperation(null, null)),
    NORM_SQUARED(new NormSquared(), new NormSquaredOperation(null)),
    SIN(new Activate(Activation.SIN), new SinOperation(null)),
    COS(new Activate(Activation.COS), new CosOperation(null)),
    TAN(new Activate(Activation.TAN), new TanOperation(null));

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
        if (op instanceof ActivateOperation) {
            Activate act = (Activate)DIFINITION.monoDiff;
            ActivateOperation actop = (ActivateOperation)op;

            act.setActivate(actop.getActivationFunction());

            return DIFINITION;
        }
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

    public Data[] execute(Data own, Data... datas) {

        if (this.size == 1) {
            return new Data[] {this.monoDiff.execute(own, datas[0])};
        } else if (this.size == 2) {
            return this.biDiff.execute(own, datas[0], datas[1]);
        }

        return null;
    }

    public int getSize() {
        return this.size;
    }

}
