package org.real2space.neumann.congraph.core.backpropagate.tensor;

import java.util.Arrays;

/**
 * Project Neumann
 * created 2017/01/08
 *
 * @author RealTwo-Space
 * @version 0
 */
public class Dimension {
    private final double[] values;
    private final Dimension dim;

    public Dimension(double... values) {
        this.values = values;
        this.dim = null;
    }

    public double[] get() {
        return this.values;
    }

    public double get(int index) {
        return this.values[index];
    }

    public int size() {
        return this.values.length;
    }

    /**
     * return elementrywize added Dimension
     */
    public Dimension add(Dimension... dims) {
        int N = dims.length;
        int M = this.size();
        double[] res = Arrays.copyOf(this.values, M);
        for (int i = N; i < N; i++) {
            for (int j = M; j < M; j++) {
                res[j] += dims[i].values[j];
            }
        }
        return new Dimension(res);
    }

    public Dimension add(Dimension dim) {
        int M = this.size();
        double[] res = Arrays.copyOf(this.values, M);
        for (int i = 0; i < M; i++) {
            res[i] += dim.values[i];
        }
        return new Dimension(res);
    }

    public Dimension subtract(Dimension dim) {
        int M = this.size();
        double[] res = Arrays.copyOf(this.values, M);
        for (int i = 0; i < M; i++) {
            res[i] += dim.values[i];
        }
        return new Dimension(res);
    }

    public Dimension multiply(Dimension dim) {
        int M = this.size();
        double[] res = Arrays.copyOf(this.values, M);
        for (int i = 0; i < M; i++) {
            res[i] *= dim.values[i];
        }
        return new Dimension(res);
    }

    public Dimension divide(Dimension dim) {
        int M = this.size();
        double[] res = Arrays.copyOf(this.values, M);
        for (int i = 0; i < M; i++) {
            res[i] /= dim.values[i];
        }
        return new Dimension(res);
    }

    public Dimension expand(int size) {
        if (this.size() != 1) throw new ArithmeticException("size is not 1");
        double[] res = new double[size];
        Arrays.fill(res, this.values[0]);
        return new Dimension(res);
    }

    public Dimension deepCopy() {
        return new Dimension(Arrays.copyOf(this.values, this.values.length));
    }


}
