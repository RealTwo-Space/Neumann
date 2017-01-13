package org.real2space.neumann.congraph.core.backpropagate.tensor;

import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixMutiplyInterface;
import org.real2space.neumann.congraph.core.function.ActivationFunction;

/**
 * Project Neumann
 * created 2017/01/12
 *
 * @author RealTwo-Space
 * @version 0
 */
public class TensorData implements Data<Tensor>, MatrixMutiplyInterface<Tensor> {
    private Tensor data;

    public TensorData (Tensor data) {
        this.data = data;
    }

    public Data<Tensor> ZERO() {
        Tensor output = new Tensor(0.0, this.data.shape());
        return new TensorData(output);
    }

    public Data<Tensor> add(Data a) {
        Tensor output = this.data.add((Tensor) a.get());
        return new TensorData(output);
    }

    public Data<Tensor> subtract(Data a) {
        Tensor output = this.data.subtract((Tensor) a.get());
        return new TensorData(output);
    }

    public Data<Tensor> multiply(Data a) {
        Tensor output = this.data.multiply((Tensor) a.get());
        return new TensorData(output);
    }

    public Data<Tensor> divide(Data a) {
        Tensor output = this.data.divide((Tensor) a.get());
        return new TensorData(output);
    }

    public Data<Tensor> matrixMultiply(Data a) {
        Tensor output = this.data.matrixMultiply((Tensor) a.get());
        return new TensorData(output);
    }

    public Data<Tensor> activate(ActivationFunction a) {
        Tensor output = this.data.activate(a);
        return new TensorData(output);
    }

    public Data<Tensor> activateDiff(ActivationFunction a) {
        Tensor output = this.data.activate(a);
        return new TensorData(output);
    }

    public Data<Tensor> transpose() {
        Tensor output = this.data.transpose();
        return new TensorData(output);
    }

    public Data<Double> toScalar() {
        Tensor output = this.data.reduceSum();
        return null;
    }

    public Data<Tensor> deepCopy() {
        return new TensorData(new Tensor(this.data.get(), this.data.shape()));
    }

    public Tensor get() {
        return this.data;
    }

    public String toString() {
        return this.data.toString();
    }
}
