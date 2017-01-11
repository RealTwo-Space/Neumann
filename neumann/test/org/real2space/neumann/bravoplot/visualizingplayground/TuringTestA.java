package org.real2space.neumann.approssi.analysis.differentialequation;

import org.real2space.neumann.approssi.analysis.math.Math64;
import org.real2space.neumann.approssi.core.value.Matrix64;

import javax.swing.*;
import java.awt.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */
public class Visualize extends JFrame {

    double f = 0.03;
    double k = 0.056;
    double du = 0.12;
    double dv = 0.056;
    double dx = 1.0;
    double dt = 1.0;

    Matrix64 u;
    Matrix64 v;
    Matrix64 c;
    Matrix64 one;

    Matrix64 newU;
    Matrix64 newV;

    BoundaryCondition64 cond;

    Matrix64 lapU, lapV;
    Matrix64 uvv;
    Matrix64 lastU;
    Matrix64 lastV;

    public Visualize() {
        initialize();
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initialize () {
        double[][] uData = new double[200][200];
        double[][] vData = new double[200][200];
        double[][] condData = new double[200][200];
        double[][] ones = new double[200][200];

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                uData[i][j] = 0.9;
                vData[i][j] = 0.0;
                ones[i][j] = 1.0;
            }
        }

        for (int i = 100; i < 140; i++) {
            for (int j = 50; j < 80; j++) {
                uData[i][j] = 1.0;
                vData[i][j] = 0.3;
            }
        }

        u = new Matrix64(uData);
        v = new Matrix64(vData);
        c = new Matrix64(condData);
        one = new Matrix64(ones);

        //cond = new DirichletCondition64(c);
        //cond = new PeriodicalBoundaryCondition64(dx);
        //cond = new NeumannCondition64(dx);
    }

    private void execute() {
        newU = u.deepCopy();
        newV = v.deepCopy();

        lapU = DiffEq64.laplacian(u, dx, cond);
        lapU.multiply(du);
        lapV = DiffEq64.laplacian(v, dx, cond);
        lapV.multiply(dv);

        uvv = DiffEq64.entrywiseMultiply(u, v);
        uvv = DiffEq64.entrywiseMultiply(uvv, v);

        lastU = one.deepCopy();
        lastU.subtract(u);
        lastU.multiply(f);

        lastV = v.deepCopy();
        lastV.multiply(f + k);

        lapU.subtract(uvv);
        lapU.add(lastU);
        lapU.multiply(dt);

        lapV.add(uvv);
        lapV.subtract(lastV);
        lapU.multiply(dt);

        newU.add(lapU);
        newV.add(lapV);

        u = newU.deepCopy();
        v = newV.deepCopy();
    }


    public void paint(Graphics g) {
        while (true) {
            drawMatrix(g);

        }
    }

    private void drawMatrix(Graphics g) {
        repaint();
        Dimension size = getSize();

        execute();

        Matrix64 visV = v.deepCopy();
        visV.multiply(2.0);
        float min;

        for (int i = 0, n = visV.getRow(); i < n; i++) {
            for (int j = 0, m = visV.getColumn(); j < m; j++) {
                min = (float)Math64.min(visV.get(i, j), 1.0);
                if (visV.get(i, j) < 0.0) {
                    g.setColor(Color.black);
                }
                else {
                    g.setColor(new Color(min, min, min));
                }
                g.fillRect(i * 3, j * 3, 3, 3);
            }
        }
    }


    public static void main(String[] args) {
        Visualize v = new Visualize();

        //System.out.println(v.v);
    }
}
