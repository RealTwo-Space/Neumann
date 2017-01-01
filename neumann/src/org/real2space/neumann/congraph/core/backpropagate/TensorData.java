package org.real2space.neumann.congraph.core.backpropagate;

import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.NumberData;
import org.real2space.neumann.congraph.core.function.Activation;
import org.real2space.neumann.congraph.core.function.ActivationFunction;

import java.util.concurrent.TimeoutException;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */

public class TensorData implements Data<Tensor64> {
    Tensor64 data;

    public TensorData(Tensor64 data) {
        this.data = data;
    }

    public TensorData(Matrix64[][] data) {
        this.data = new Tensor64(data);
    }

    public TensorData(Matrix64 data) {
        this.data = new Tensor64(data);
    }

    public TensorData(int row, int column) {
        this.data = new Tensor64(row, column);
    }

    public Data<Tensor64> ZERO() {
        return null;
    }

    public Data<Tensor64> add(Data a) {
        return new TensorData(this.data.add((Tensor64)a.get()));
    }

    public Data<Tensor64> subtract(Data a) {
        return new TensorData(this.data.subtract((Tensor64)a.get()));
    }
    public Data<Tensor64> multiply(Data a) {
        Tensor64 output;
        if (a instanceof NumberData) {
            NumberData t = (NumberData)a;
            output = this.data.multiply((double)t.get());
        } else {
            output = this.data.multiply((Tensor64)a.get());
        }
        return new TensorData(output);
    }
    public Data<Tensor64> divide(Data a) {
        Tensor64 output;
        output = this.data.divide((double)a.get());
        return new TensorData(output);
    }

    @Override
    public Data<Tensor64> activate(ActivationFunction func) {
        return null;
    }

    @Override
    public Data<Tensor64> activateDiff(ActivationFunction func) {
        return null;
    }

    public Tensor64 get() {
        return this.data;
    }
    public Data<Tensor64> deepCopy() {
        return new TensorData(this.data.deepCopy());
    }
}
