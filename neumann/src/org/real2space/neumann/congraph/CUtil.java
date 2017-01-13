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

    CUtil(Congraph cg, Random random) {
        this.cg = cg;
        this.rand = random;
    }

    public double zero() {
        return 0.0;
    }

    public double[][] zeros(int row, int column) {
        double[][] mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = 0.0;
            }
        }
        return mat;
    }

    public double[][] fills(int row, int column, double value) {
        double[][] mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = value;
            }
        }
        return mat;
    }

    public double normalRandom() {
        return rand.nextGaussian();
    }

    public double normalRandom(double mean, double stdev) {
        return rand.nextGaussian() * stdev + mean;
    }

    public double[][] normalRandoms(int row, int column) {
        double[][] mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = normalRandom();
            }
        }
        return mat;
    }

    public double[][] normalRandoms(int row, int column, double mean, double stdev) {
        double[][] mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = normalRandom(mean, stdev);
            }
        }
        return mat;
    }
}
