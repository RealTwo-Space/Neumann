package org.real2space.neumann.congraph.core.function;

/**
 * Created by ryosukesuzuki on 2017/01/01.
 */

/*

    This class may be deleted.
 */

public enum Activation {
    SIN(new Sin()),
    COS(new Cos()),
    TAN(new Tan()),
    COSH(new Cosh()),
    SINH(new Sinh()),
    TANH(new Tanh());

    private final ActivationFunction func;
    private Activation(ActivationFunction func) {
        this.func = func;
    }

    public ActivationFunction get() {
        return this.func;
    }
}
