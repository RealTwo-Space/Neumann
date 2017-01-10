package org.real2space.neumann.congraph;

import org.real2space.neumann.approssi.core.value.Matrix64;

import java.util.Random;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class CUtil {
    private final Congraph cg;
    private final Random rand;

    CUtil(Congraph cg) {
        this.cg = cg;
        this.rand = new Random();
    }

    CUtil(Congraph cg, long seed) {
        this.cg = cg;
        this.rand = new Random(seed);
    }

    public double zero() {
        return 0.0;
    }

    public Matrix64 zeros(int row, int column) {
        return new Matrix64(row, column);
    }

    public double normalRandom() {
        return rand.nextGaussian();
    }

    public double normalRandom(double mean, double stdev) {
        return rand.nextGaussian() * stdev + mean;
    }

    public Matrix64 normalRandoms(int row, int column) {
        double[][] mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = normalRandom();
            }
        }
        return new Matrix64(mat);
    }

    public Matrix64 normalRandoms(int row, int column, double mean, double stdev) {
        double[][] mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = normalRandom(mean, stdev);
            }
        }
        return new Matrix64(mat);
    }
}
