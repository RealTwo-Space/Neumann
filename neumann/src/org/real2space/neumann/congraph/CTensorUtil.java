package org.real2space.neumann.congraph;

import org.real2space.neumann.congraph.core.backpropagate.tensor.Shape;
import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;

import java.util.Random;

/**
 * Project Neumann
 * created 2017/01/13
 *
 * @author RealTwo-Space
 * @version 0
 */
public class CTensorUtil {
    private final Congraph cg;
    private final Random rand;

    CTensorUtil(Congraph cg) {
        this.cg = cg;
        this.rand = new Random();
    }

    CTensorUtil(Congraph cg, Random random) {
        this.cg = cg;
        this.rand = random;
    }

    public double zero() {
        return 0.0;
    }

    public Tensor zeros(Shape shape) {
        return new Tensor(0.0, shape);
    }

    public Tensor fills(double value, Shape shape) {
        return new Tensor(value, shape);
    }

    public Tensor normalRandoms(Shape shape) {
        int N = shape.elementSize();
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = rand.nextGaussian();
        }
        return new Tensor(res, shape);
    }

    public Tensor normalRandoms(double mean, double stdev, Shape shape) {
        int N = shape.elementSize();
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = rand.nextGaussian() * stdev + mean;
        }
        return new Tensor(res, shape);
    }

    public Tensor diagonol() {
        return null;
    }

    public Tensor tensor(double[] values, Shape shape) {
        return new Tensor(values, shape);
    }

    public Tensor tensor(double[] values) {
        return new Tensor(values);
    }

    public Tensor tensor(double[][] matrix) {
        return new Tensor(matrix);
    }

    public Tensor tensor(double value) {
        return new Tensor(value);
    }

    public Shape shape(int... indexes) {
        return new Shape(indexes);
    }

    public Shape shape() {
        return new Shape();
    }
}
