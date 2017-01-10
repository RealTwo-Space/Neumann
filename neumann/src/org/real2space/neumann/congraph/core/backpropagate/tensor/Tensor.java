package org.real2space.neumann.congraph.core.backpropagate.tensor;

import java.util.Arrays;

/**
 * Project Neumann
 * created 2017/01/08
 *
 * @author RealTwo-Space
 * @version 0
 */
public class Tensor {
    private double[] values;
    private Shape shape;

    public Tensor(double scalar) {
        this.values = new double[]{scalar};
        this.shape = new Shape(1);
    }

    public Tensor(double scalar, Shape shape) {
        this.values = new double[shape.elementSize()];
        Arrays.fill(this.values, scalar);
        this.shape = shape;

    }

    public Tensor(double[] vector) {
        this.values = vector;
        this.shape = new Shape(vector.length);
    }

    public Tensor(double[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        this.shape = new Shape(N, M);

        this.values = new double[N * M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.values[j * N + i] = matrix[i][j];
            }
        }
    }

    public Tensor(double[] values, Shape shape) {
        this.values = values;
        this.shape = shape;
    }

    public Tensor add(Tensor tensor) {
        if (!this.shape.isET(tensor.shape)) {
            throw new ArithmeticException("shape is not match");
        }
        int N = this.values.length;
        double[] res = Arrays.copyOf(this.values, N);
        for (int i = 0; i < N; i++) {
            res[i] += tensor.values[i];
        }
        return new Tensor(res, this.shape);
    }

    public Tensor subtract(Tensor tensor) {
        if (!this.shape.isET(tensor.shape)) {
            throw new ArithmeticException("shape is not match");
        }
        int N = this.values.length;
        double[] res = Arrays.copyOf(this.values, N);
        for (int i = 0; i < N; i++) {
            res[i] -= tensor.values[i];
        }
        return new Tensor(res, this.shape);
    }

    public Tensor multiply(Tensor tensor) {
        if (!this.shape.isET(tensor.shape)) {
            throw new ArithmeticException("shape is not match");
        }
        int N = this.values.length;
        double[] res = Arrays.copyOf(this.values, N);
        for (int i = 0; i < N; i++) {
            res[i] *= tensor.values[i];
        }
        return new Tensor(res, this.shape);
    }

    public Tensor divide(Tensor tensor) {
        if (!this.shape.isET(tensor.shape)) {
            throw new ArithmeticException("shape is not match");
        }
        int N = this.values.length;
        double[] res = Arrays.copyOf(this.values, N);
        for (int i = 0; i < N; i++) {
            res[i] /= tensor.values[i];
        }
        return new Tensor(res, this.shape);
    }

    public Tensor matrixMultiply(Tensor tensor) {
        if (!this.shape.canMatrixMultiply(tensor.shape)) {
            throw new ArithmeticException("matrix only");
        }
        double[] res = new double[this.values.length];
        int N = this.shape.get(0);
        int K = this.shape.get(1);
        int M = tensor.shape.get(1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    res[j * N + i] += this.values[k * N + i] * tensor.values[j * K + k];
                }
            }
        }
        return new Tensor(res, new Shape(N, M));
    }

    public Tensor expand(Shape shape) {
        return null;
    }

    // [ [[1, 2]],[[2, 3]] ]2x1x2
    public Tensor reduce() {
        return null;
    }

}
