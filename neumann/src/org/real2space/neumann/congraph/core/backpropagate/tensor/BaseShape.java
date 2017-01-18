package org.real2space.neumann.congraph.core.backpropagate.tensor;

/**
 * Project Neumann
 * created 2017/01/15
 *
 * @author RealTwo-Space
 * @version 0
 */
public abstract class BaseShape {
    protected final int[] stride;
    protected final int[] shape;
    protected final int dimensions;

    protected BaseShape(int[] shape, int[] stride, int dimensions) {
        this.stride = stride;
        this.shape = shape;
        this.dimensions = dimensions;
    }

    public boolean isET(BaseShape shape) {
        for (int i = 0; i < this.dimensions; i++) {
            if (this.shape[i] != shape.shape[i]) {
                return false;
            }
        }
        return true;
    }

    protected static int[] calcStrides(int[] shape) {
        int dimensions = shape.length;
        int[] stride = new int[dimensions];
        int st=1;
        for (int j = dimensions - 1; j >= 0; j--) {
            stride[j] = st;
            st *= shape[j];
        }
        return stride;
    }

    public int getShape(int dimension) {
        return this.shape[dimension];
    }

    protected int getStride(int dimension) {
        return this.stride[dimension];
    }

    public int getDimensions() {
        return this.dimensions;
    }

    protected int getIndex(int... indexes) {
        int ix = 0;
        for (int i = 0; i < this.dimensions; i++) {
            ix += indexes[i] * getStride(i);
        }
        return ix;
    }

    public int rank() {
        if (this.dimensions == 1 && this.shape[0] == 0) {
            return 0;
        }
        return this.dimensions;
    }

}
