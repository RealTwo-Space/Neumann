package org.real2space.neumann.congraph.core.backpropagate.tensor;

import com.sun.xml.internal.rngom.parse.host.Base;

/**
 * Project Neumann
 * created 2017/01/08
 *
 * @author RealTwo-Space
 * @version 0
 */

/*

This Shape class express Tensor's shape.

e.g.
shape of scalar : rank 0, ()
shape of vetcor : rank 1, (p)
shape of matrix : rank 2, (p, q)
shape of 3d array : rank 3, (p, q, r)

 */
public class Shape extends BaseShape {

    public Shape(int... shape) {
        super(
                shape,
                BaseShape.calcStrides(shape),
                shape.length
        );
    }

    public Shape() {
        this(0);
    }

    public int elementSize() {
        if (this.rank() == 0) return 1;
        int res = 1;
        for (int i = 0, N = this.getDimensions(); i < N; i++) {
            res *= this.shape[i];
        }
        return res;
    }

    public boolean canMatrixMultiply(Shape shape) {
        if (this.rank() != 2 || shape.rank() != 2) {
            return false;
        }
        if (this.getShape(1) == shape.getShape(0))  {
            return true;
        }
        return false;
    }

    public int getIndexWhichCanExpand(Shape shape) {
        int N = this.getDimensions();
        int match = 0;
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (this.getShape(i) != shape.getShape(i)) {
                if (this.getShape(i) == 1) {
                    match++;
                    index = i;
                } else {
                    return -1;
                }
            }
        }
        if (match == 1) {
            return index;
        }
        return -1;
    }

    // TODO : jissou
    public int[] expandIndexes(int index, Shape shape) {
        return null;
    }

    public int get(int index) {
        return this.getShape(index);
    }

    public String toString() {
        String res = "rank : "+ this.rank() + ", (";
        for (int i = 0; i < this.rank(); i++) {
            if (i != 0) {
                res += ",";
            }
            res += " " + this.getShape(i);
        }
        res += " )";
        return res;
    }
}
