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

    // members which are already defined elsewhere

    public final ActivationFunction SIN = new Sin();

    public final ActivationFunction COS = new Cos();

    public final ActivationFunction TAN = new Tan();

    public final ActivationFunction SINH = new Sinh();

    public final ActivationFunction COSH = new Cosh();

    public final ActivationFunction TANH = new Tanh();

    // members which will be defined

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
            return 2.0 * value;
        }
    };

    public final ActivationFunction ABS = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return Math64.abs(value);
        }

        @Override
        public double activateDiff(double value) {
            if (value > 0.0) {
                return 1.0;
            } else if (value == 0.0) {
                return 0.0;
            }
            return -1.0;
        }
    };

    public final ActivationFunction IDENTITY = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return value;
        }

        @Override
        public double activateDiff(double value) {
            return 1.0;
        }
    };

    public final ActivationFunction ARCTAN = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return Math64.arctan(value);
        }

        @Override
        public double activateDiff(double value) {
            double temp = this.activate(value);
            return 1.0 / (temp * temp + 1.0);
        }
    };


    // methods

    public ActivationFunction POW(double exponent) {
        return new ActivationFunction() {
            @Override
            public double activate(double value) {
                return Math64.pow(value, exponent);
            }

            @Override
            public double activateDiff(double value) {
                return exponent * Math64.pow(value, exponent - 1.0);
            }
        };
    }


    // peculiar functions | members

    public final ActivationFunction BINARY_STEP = new ActivationFunction() {
        @Override
        public double activate(double value) {
            if (value < 0.0) {
                return 0.0;
            }
            return 1.0;
        }

        @Override
        public double activateDiff(double value) {
            return 0.0;
        }
    };

    public final ActivationFunction SIGMOID = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return 1.0 / (1.0 + Math64.exp(value));
        }

        @Override
        public double activateDiff(double value) {
            double temp = this.activate(value);
            return temp * (1.0 - temp);
        }
    };

    public final ActivationFunction SOFT_SIGN = new ActivationFunction() {
        @Override
        public double activate(double value) {
            return value / (1.0 + Math64.abs(value));
        }

        @Override
        public double activateDiff(double value) {
            double temp = 1.0 / (1.0 + Math64.abs(value));
            return temp * temp;
        }
    };

    public final ActivationFunction RELU = new ActivationFunction() {
        @Override
        public double activate(double value) {
            if (value < 0.0) return 0.0;
            return value;
        }

        @Override
        public double activateDiff(double value) {
            if (value < 0.0) return 0.0;
            return 1.0;
        }
    };

    // peculiar funtions | methods

    public ActivationFunction ELU(double alpha) {
        return new ActivationFunction() {
            @Override
            public double activate(double value) {
                if (value < 0.0) {
                    return alpha * (Math64.exp(value) - 1.0);
                }
                return value;
            }

            @Override
            public double activateDiff(double value) {
                return alpha * Math64.exp(value);
            }
        };
    }

}
