package org.real2space.neumann.congraph.core.backpropagate.tensor;

/**
 * Project Neumann
 * created 2017/01/08
 *
 * @author RealTwo-Space
 * @version 0
 */
public class Shape {
    private final int[] shapes;
    private final int rank;

    public Shape(int... sizes) {
        this.shapes = sizes;
        int N = sizes.length;
        if (N == 1 && sizes[0] == 1) {
            this.rank = 0;
        } else {
            this.rank = N;
        }
    }

    public boolean isET(Shape shape) {
        int N = this.shapes.length;
        for (int i = 0; i < N; i++) {
            if (this.shapes[i] != shape.shapes[i]) {
                return false;
            }
        }
        return true;
    }

    // 2 x 2 x 1 -> 2 x 2 x 2
    // 111(0), 121(1), 211(2), 221(3) -> 111(0) 112(1) 121(2) 122(3)
    public int getIndexWhichCanExpand(Shape shape) {
        int N = this.shapes.length;
        int match = 0;
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (this.shapes[i] != shape.shapes[i]) {
                if (this.shapes[i] == 1) {
                    match++;
                    index = i;
                }
                return -1;
            }
        }
        if (match == 1) {
            return index;
        }
        return -1;
    }

    // 3 x 2 x 4 (i*YMAX+j)*XMAX+k
    //  111, 112, 113, 114, 121, 122, 123, 124, 211, 212, 214, ...
    //    0    1    2    3    4    5    6    7    8    9   10
    //
    public int getTensorIndex(int... indexes) {
        int res = 0;
        int N, M, L;
        int base;
        L = indexes.length;
        for (int i = L - 1; i >= 0; i--) {
            N = this.get(i);
            base = 1;
            M = L - i - 1;
            for (int j = 0; j < M; j++) {
                base *= N;
            }
            res += (indexes[i] - 1) * base;
        }
        return res;
    }

    public int elementSize() {
        int res = 1;
        for (int i = 0, N = this.shapes.length; i < N; i++) {
            res *= this.shapes[i];
        }
        return res;
    }

    public boolean canMatrixMultiply(Shape shape) {
        if (this.rank() != 2 || shape.rank() != 2) {
            return false;
        }

        if (this.get(1) == shape.get(0))  {
            return true;
        }
        return false;
    }

    public int get(int index) {
        return this.shapes[index];
    }

    public int rank() {
        return this.rank;
    }

    public String toString() {
        String res = "rank : "+ this.rank + "[";
        for (int i = 0; i < this.rank; i++) {
            if (i != 0) {
                res += ",";
            }
            res += " " + this.get(i);
        }
        res += " ]";
        return res;
    }
}
