package org.real2space.neumann.congraph.core.backpropagate.tensor;

import com.sun.corba.se.impl.orb.ParserTable;
import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.approssi.core.value.Vector64;
import org.real2space.neumann.congraph.core.data.*;
import org.real2space.neumann.congraph.core.function.ActivationFunction;

import java.util.Arrays;

/**
 * Project Neumann
 * created 2017/01/08
 *
 * @author RealTwo-Space
 * @version 0
 */

/*

    Tensor is like n-d array.


 */
public class Tensor {
    private double[] values;
    private Shape shape;


    //    convert Data to Tensor
    public static Tensor convert(Data data) {
        if (data instanceof NumberData) {
            return new Tensor((double)data.get());
        } else if (data instanceof MatrixData) {
            MatrixData matD = (MatrixData) data;
            Matrix64 mat = (Matrix64)matD.get();
            return new Tensor(mat.get());
        } else {
            throw new ArithmeticException("not implemented for now.");
        }
    }

    // convert tensor to data
    public static Data convert(Tensor tensor) {
        if (tensor.shape().rank() == 0) {
            return new DoubleData(tensor.values[0]);
        } else if (tensor.shape().rank() == 1) {
            return new VectorData<Double>(new Vector64(tensor.values));
        } else if (tensor.shape().rank() == 2) {
            return new MatrixData<Double>(new Matrix64(tensor.toMatrix()));
        }
        return null;
    }

    // convert tensor to data.
    public static Data convert(Data data, Tensor tensor) {
        if (data instanceof NumberData) {
            return new DoubleData(tensor.values[0]);
        } else if (tensor.shape().rank() == 1) {
            return new VectorData<Double>(new Vector64(tensor.values));
        } else if (tensor.shape().rank() == 2) {
            return new MatrixData<Double>(new Matrix64(tensor.toMatrix()));
        }
        return null;
    }

    public static Tensor fill(double scalar, Shape shape) {
        Tensor res = new Tensor(scalar);
        return res.expand(shape);
    }

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

        int N = this.shape.get(0);
        int K = this.shape.get(1);
        int M = tensor.shape.get(1);
        double[] res = new double[N * M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[j * N + i] = 0.0;
                for (int k = 0; k < K; k++) {
                    res[j * N + i] += this.values[k * N + i] * tensor.values[j * K + k];
                }
            }
        }

        return new Tensor(res, new Shape(N, M));
    }


    // only 2 rank tensor for now.
    public Tensor transpose() {
        if (this.shape.rank() != 2) throw new ArithmeticException("only 2 rank tensor for now.");
        int N = this.shape.get(0);
        int M = this.shape.get(1);
        double[] res = new double[N*M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res[j * M + i] += this.values[i * N + j];
            }
        }
        return new Tensor(res, new Shape(M, N));
    }

    public Tensor activate(ActivationFunction func) {
        int N = this.values.length;
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = func.activate(this.values[i]);
        }
        return new Tensor(res, this.shape);
    }

    public Tensor activateDiff(ActivationFunction func) {
        int N = this.values.length;
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = func.activateDiff(this.values[i]);
        }
        return new Tensor(res, this.shape);
    }

    public Tensor expand(Shape shape) {
        int N = shape.elementSize();
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = this.values[0];
        }
        return new Tensor(res, shape);
    }

    // [ [[1, 2]],[[2, 3]] ]2x1x2
    public Tensor reduce() {
        return null;
    }

    // [1, 2, 3] -> [6]. (1+2+3)
    public Tensor reduceSum() {
        double res = 0.0;
        for (int i = 0, N = this.values.length; i < N; i++) {
            res += this.values[i];
        }
        return new Tensor(res);
    }

    // [2, 3, 4] -> [24]. (2*3*4)
    public Tensor reduceMult() {
        double res = 1.0;
        for (int i = 0, N = this.values.length; i < N; i++) {
            res *= this.values[i];
        }
        return new Tensor(res);
    }

    public double toScalar() {
        return this.values[0];
    }

    // not to Matrix class in Approssi.
    public double[][] toMatrix() {
        int N = this.shape.get(0);
        int M = this.shape.get(1);
        double[][] res = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[i][j] = this.values[j * N + i];
            }
        }
        return res;
    }

    public Shape shape() {
        return this.shape;
    }

    public String toString() {
        return this.shape.toString();
    }

}
