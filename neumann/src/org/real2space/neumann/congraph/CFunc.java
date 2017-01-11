package org.real2space.neumann.congraph;

import org.real2space.neumann.approssi.analysis.math.Math64;
import org.real2space.neumann.congraph.core.function.*;

/**
 * Project Neumann
 * created 2017/01/11
 *
 * @author RealTwo-Space
 * @version 0
 */
public class CFunc {

    public final ActivationFunction SIN = new Sin();

    public final ActivationFunction COS = new Cos();

    public final ActivationFunction TAN = new Tan();

    public final ActivationFunction SINH = new Sinh();

    public final ActivationFunction COSH = new Cosh();

    public final ActivationFunction TANH = new Tanh();

    public final ActivationFunction LN = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return Math64.ln(value);
        }

        @Override
        public double activateDiff(double value) {
            return 1.0 / value;
        }
    };

    public final ActivationFunction EXP = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return Math64.exp(value);
        }

        @Override
        public double activateDiff(double value) {
            return Math64.exp(value);
        }
    };

    public final ActivationFunction SQRT = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return Math64.sqrt(value);
        }
        // (sqrt a )' = 1/2 / a^(-1/2) = 0.5 / sqrt(a)
        @Override
        public double activateDiff(double value) {
            return 0.5 / Math64.sqrt(value);
        }
    };

    public final ActivationFunction SQ = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return Math64.sq(value);
        }

        @Override
        public double activateDiff(double value) {
            return 2 * value;
        }
    };

}
