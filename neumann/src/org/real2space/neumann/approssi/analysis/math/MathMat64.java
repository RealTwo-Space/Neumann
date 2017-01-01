package org.real2space.neumann.approssi.analysis.math;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class MathMat64 {
    public static Matrix64 ZERO(int row, int column) {
        return new Matrix64(row, column);
    }

    public static Matrix64 toZero(Matrix64 mat) {
        return new Matrix64(mat.getRow(), mat.getColumn());
    }

    public static Matrix64 shurProduct(Matrix64 A, Matrix64 B) {
        Matrix64 out = A.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, out.get(i, j) * B.get(i, j));
            }
        }
        return out;
    }

    public static Matrix64 sin(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.sin(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 cos(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.cos(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 tan(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.tan(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 sinh(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.sinh(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 cosh(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.cosh(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 tanh(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.tanh(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 sec(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.sec(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 scs(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.csc(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 cot(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.cot(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 arcsin(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.arcsin(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 arccos(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.arccos(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 arctan(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.arctan(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 exp(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.exp(out.get(i, j)));
            }
        }
        return out;
    }

    public static Matrix64 ln(Matrix64 mat) {
        Matrix64 out = mat.deepCopy();
        int N = out.getRow();
        int M = out.getColumn();
        double[][] c = new double[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.set(i, j, Math64.ln(out.get(i, j)));
            }
        }
        return out;
    }

}
