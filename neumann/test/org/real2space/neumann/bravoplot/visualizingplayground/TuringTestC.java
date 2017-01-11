package org.real2space.neumann.congraph;

import org.real2space.neumann.approssi.analysis.math.Math64;
import org.real2space.neumann.approssi.core.value.Matrix64;
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
public class TuringTest extends JFrame {
    Congraph cg;
    DECondition condition;

    double f = 0.03;
    double k = 0.056;
    double du = 0.12;
    double dv = 0.056;
    double dx = 1.0;
    double dt = 1.0;

    CNode U;
    CNode V;
    CNode batch;

    public TuringTest () {
        cg = new Congraph();

        initialize();
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initialize () {
        double[][] uData = cg.util.normalRandoms(200, 200, 0.7, 0.2);
        double[][] vData = cg.util.normalRandoms(200, 200, 0.3, 0.2);
        double[][] condData = new double[200][200];
        double[][] ones = new double[200][200];

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 200; j++) {
                //uData[i][j] = 0.9;
                //vData[i][j] = 0.0;
                ones[i][j] = 1.0;
            }
        }

        /*
        for (int i = 100; i < 140; i++) {
            for (int j = 50; j < 80; j++) {
                uData[i][j] = 1.0;
                vData[i][j] = 0.3;
            }
        }
        */

        Matrix64 u = new Matrix64(uData);
        Matrix64 v = new Matrix64(vData);
        Matrix64 c = new Matrix64(condData);
        Matrix64 one = new Matrix64(ones);

        condition = DEConditionFactory.DIRICHRET(c);
        //condition = DEConditionFactory.PERIODIC(dx);
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
        visV.multiply(2.0);
        float min;

        for (int i = 0, n = visV.getRow(); i < n; i++) {
            for (int j = 0, m = visV.getColumn(); j < m; j++) {
                min = (float) Math64.min(visV.get(i, j), 1.0);
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
        TuringTest v = new TuringTest();

        //System.out.println(v.v);
    }
}
