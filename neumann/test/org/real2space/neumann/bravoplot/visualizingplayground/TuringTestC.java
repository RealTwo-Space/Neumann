package org.real2space.neumann.bravoplot.visualizingplayground;

import org.real2space.neumann.approssi.analysis.math.Math64;
import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.CNode;
import org.real2space.neumann.congraph.Congraph;
import org.real2space.neumann.congraph.core.differentialequation.condition.DECondition;
import org.real2space.neumann.congraph.core.differentialequation.condition.DEConditionFactory;

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
public class TuringTestC extends JFrame {
    Congraph cg;
    DECondition condition;


    // interesting to see
    double f = 0.03;
    double k = 0.054;
    double du = 0.11;
    double dv = 0.07;
    double dx = 1.0;
    double dt = 1.0;


    /*
    double f = 0.03;
    double k = 0.056;
    double du = 0.11;
    double dv = 0.07;
    double dx = 1.0;
    double dt = 1.0;
    */

    int size = 200;
    int ratio = (int)(600.0 / (double)size);

    CNode U;
    CNode V;
    CNode batch;

    public TuringTestC() {
        cg = new Congraph();

        initialize();
        this.setSize(size * ratio, size * ratio);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initialize () {
        double[][] uData = cg.util.normalRandoms(size, size, 0.7, 0.2);
        double[][] vData = cg.util.normalRandoms(size, size, 0.3, 0.2);
        double[][] condData = new double[size][size];
        double[][] ones = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //uData[i][j] = 0.9;
                //vData[i][j] = 0.0;
                condData[i][j] = 0;
                ones[i][j] = 1.0;
            }
        }

        /*
        for (int i = size / 2 - size / 4; i < size / 2 + size / 4; i++) {
            for (int j = size * 2 / 3 + size / 6; j < size * 2 / 3 + size / 4; j++) {
                //uData[i][j] = 0.9;
                vData[i][j] = 0.3;
            }
        }
        */

        for (int i = size / 2 - size / 24; i < size / 2 + size / 24; i++) {
            for (int j = size / 2 - size / 24; j < size / 2 + size / 24; j++) {
                //uData[i][j] = 1.0;
                //vData[i][j] = 0.3;
            }
        }




        Matrix64 u = new Matrix64(uData);
        Matrix64 v = new Matrix64(vData);
        Matrix64 c = new Matrix64(condData);
        Matrix64 one = new Matrix64(ones);

        //condition = DEConditionFactory.DIRICHRET(c);
        condition = DEConditionFactory.PERIODIC(dx);
        //condition = DEConditionFactory.NEUMANN(dx);

        createGraph(u, v, c, one);
    }

    private void createGraph (Matrix64 u, Matrix64 v, Matrix64 c, Matrix64 one) {
        U = cg.variable(u);
        V = cg.variable(v);
        CNode One = cg.constant(one);
        CNode fN = cg.constant(this.f);
        CNode kN = cg.constant(this.k);
        CNode duN = cg.constant(this.du);
        CNode dvN = cg.constant(this.dv);
        CNode dxN = cg.constant(this.dx);
        CNode dtN = cg.constant(this.dt);

        CNode lapU = cg.laplacian(U, dxN, this.condition).multiply(duN);
        CNode lapV = cg.laplacian(V, dxN, this.condition).multiply(dvN);

        CNode uvv = U.entrywizeMultiply(V).entrywizeMultiply(V);

        CNode lastU = One.subtract(U).multiply(fN);
        CNode lastV = V.multiply(fN.add(kN));

        CNode newU = U.add(lapU.subtract(uvv).add(lastU).multiply(dtN));
        CNode newV = V.add(lapV.add(uvv).subtract(lastV).multiply(dtN));

        CNode subU = cg.substitute(U, newU);
        CNode subV = cg.substitute(V, newV);


        batch = cg.batch(subU, subV);
    }

    public void paint(Graphics g) {
        while (true) {
            drawMatrix(g, V);
        }
    }

    private void drawMatrix(Graphics g, CNode v) {
        repaint();
        Dimension size = getSize();

        cg.execute(batch);

        Matrix64 visV = (Matrix64)V.getData().get();
        visV.multiply(3.0);
        float min;

        for (int i = 0, n = visV.getRow(); i < n; i++) {
            for (int j = 0, m = visV.getColumn(); j < m; j++) {
                min = (float) Math64.min(visV.get(i, j), 1.0);
                if (visV.get(i, j) < 0.0) {
                    g.setColor(Color.black);
                }
                else {
                    g.setColor(new Color(1.0f - min, 1.0f - min, 0));
                }
                g.fillRect(i * ratio, j * ratio, ratio, ratio);
            }
        }
    }

    public static void main(String[] args) {
        TuringTestC v = new TuringTestC();

        //System.out.println(v.v);
    }
}
