package org.real2space.neumann.congraph.core.bbackpropagate;

import org.real2space.neumann.approssi.analysis.math.MathMat64;

import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Created by ryosukesuzuki on 2016/12/29.
 */

public class Tensor {
    private final Matrix64[][] tensor;
    private final int rank;

    public Tensor(Matrix64[][] tensor) {
        int N = tensor.length;
        int M = tensor[0].length;
        if (N != 1 || M != 1) {
            this.rank = 4;
        } else {
            this.rank = 2;
        }

        this.tensor = new Matrix64[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                this.tensor[i][j] = tensor[i][j].deepCopy();
            }
        }
    }

    public Tensor(Matrix64 mat) {
        this.tensor = new Matrix64[1][1];
        this.tensor[0][0] = mat.deepCopy();
        this.rank = 2;
    }

    public Tensor(int row, int column) {
        if (row != 1 || column != 1) {
            this.rank = 4;
        } else {
            this.rank = 2;
        }
        this.tensor = new Matrix64[row][column];
    }

    public void set(int row, int column, Matrix64 mat) {
        this.tensor[row][column] = mat.deepCopy();
    }

    public void setOrAdd(int row, int column, Matrix64 mat) {
        if (this.tensor[row][column] == null) {
            set(row, column, mat);
        } else {
            this.tensor[row][column].add(mat);
        }
    }

    public Matrix64 get(int row, int column) {
        return this.tensor[row][column];
    }

    public Tensor divide(double other) {
        int N = this.tensor.length;
        int M = this.tensor[0].length;
        Tensor tensor = new Tensor(this.tensor);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tensor.tensor[i][j].divide(other);
            }
        }
        return tensor;
    }

    public Tensor multiply(double other) {
        int N = this.tensor.length;
        int M = this.tensor[0].length;
        Tensor tensor = new Tensor(this.tensor);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tensor.tensor[i][j].multiply(other);
            }
        }
        return tensor;
    }
    // tensor * tensor
    public Tensor multiply(Tensor other) {
        if (this.rank == 2) {
            if (other.rank == 2) {
                return multiplyWithRank2AndRank2(other);
            } else if (other.rank == 4) {
                return multiplyWithRank2AndRank4(other);
            }
        } else if (this.rank == 4) {
            if (other.rank == 2) {
                return multiplyWithRank4AndRank2(other);
            } else if (other.rank == 4) {
                return multiplyWithRank4AndRank4(other);
            }
        }
        return null;
    }

    // this(matrix) * other(tensor)
    private Tensor multiplyWithRank2AndRank2(Tensor other) {
        Matrix64 matA = this.tensor[0][0].deepCopy();
        matA.multiply(other.tensor[0][0]);
        return new Tensor(matA);
    }

    // this(matrix) * other(tensor)
    private Tensor multiplyWithRank2AndRank4(Tensor other) {
        Matrix64 mat = this.tensor[0][0];
        // mat   (n, k)
        // other (k, m)
        // out   (n, m)
        int N = mat.getRow();
        int K = mat.getColumn();
        int M = other.tensor[0].length;
        Matrix64[][] tensor = new Matrix64[N][M]; // out (n , m)
        Matrix64 otherMat;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tensor[i][j] = MathMat64.toZero(other.tensor[0][j]); // out ij = other.km
                for (int k = 0; k < K; k++) {
                    otherMat = other.tensor[k][j].deepCopy();
                    otherMat.multiply(mat.get(i, k));
                    tensor[i][j].add(otherMat);
                }
            }
        }
        return new Tensor(tensor);
    }

    // this(tensor) * other(matrix)
    private Tensor multiplyWithRank4AndRank2(Tensor other) {
        Matrix64 mat = other.tensor[0][0];

        int N = this.tensor.length;
        int K = this.tensor[0].length;
        int M = mat.getColumn();

        Matrix64[][] tensor = new Matrix64[N][M]; // out (n , m)
        Matrix64 otherMat;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tensor[i][j] = MathMat64.toZero(this.tensor[i][0]); // out ij = other.km
                for (int k = 0; k < K; k++) {
                    otherMat = this.tensor[i][k].deepCopy();
                    otherMat.multiply(mat.get(k, j));
                    tensor[i][j].add(otherMat);
                }
            }
        }
        return new Tensor(tensor);
    }

    private Tensor multiplyWithRank4AndRank4(Tensor other) {
        int N = this.tensor.length;
        int K = this.tensor[0].length;
        int M = other.getColumn();
        Tensor tensor = new Tensor(N, M);
        Matrix64 mat;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < K; k++) {
                    mat = this.get(i, k).deepCopy();
                    mat.multiply(other.get(k, j));
                    tensor.setOrAdd(i, j, mat);
                }
            }
        }
        return tensor;
    }

    public Tensor add(Tensor other) {

        int N = this.tensor.length;
        int M = this.tensor[0].length;
        Tensor tensor = new Tensor(this.tensor);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tensor.tensor[i][j].add(other.tensor[i][j]);
            }
        }
        return tensor;
    }

    public Tensor subtract(Tensor other) {
        int N = this.tensor.length;
        int M = this.tensor[0].length;
        Tensor tensor = new Tensor(this.tensor);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tensor.tensor[i][j].subtract(other.tensor[i][j]);
            }
        }
        return tensor;
    }

    public Tensor transpose() {
        if (this.rank == 4) {
            return transposeRank4();
        } else if (this.rank == 2) {
            return transposeRank2();
        }
        return null;
    }

    private Tensor transposeRank4() {
        int N = this.tensor.length;
        int M = this.tensor[0].length;
        Matrix64[][] tensor = new Matrix64[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tensor[j][i] = this.tensor[i][j];
            }
        }
        return new Tensor(tensor);
    }

    private Tensor transposeRank2() {
        Tensor tensor = new Tensor(this.tensor);
        tensor.tensor[0][0].transpose();
        return tensor;
    }


    public int getRow() {
        return this.tensor.length;
    }

    public int getColumn() {
        return this.tensor[0].length;
    }

    public int getRank() {
        return this.rank;
    }

    public Tensor deepCopy() {
        return new Tensor(this.tensor);
    }

    public String toString() {
        StringBuffer output = new StringBuffer();

        int N = tensor.length;
        int M = tensor[0].length;
        output.append("[[ ");
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                output.append(" [ ");
            }
            for (int j = 0; j < M; j++) {
                output.append(tensor[i][j]);

                if (j != M - 1) {
                    output.append(", ");
                }
                else {
                    if (i != N - 1) {
                        output.append(" ],\n");
                    }

                }
            }
        }
        output.append(" ]]");
        return output.toString();
    }
}
