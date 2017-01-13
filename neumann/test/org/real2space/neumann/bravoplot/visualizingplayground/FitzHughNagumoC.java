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
 * created 1/13/17
 */
public class FitzHughNagumoC extends JFrame {
    private Congraph cg;
    private DECondition condition;

    int size = 200;
    int ratio = 3;
    int r = (int)(600.0 / (double)size);

    double gamma = 0.1;
    double epsilon = 1000;
    double a = 0.125;
    double du = 0.01;
    double dv = 0.001;
    double dx = 1.0;
    double dt = 1.0;

    CNode U;
    CNode V;
    CNode batch;



    public FitzHughNagumoC () {
        cg = new Congraph();
        initialize();

        this.setSize(size * ratio, size * ratio);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initialize() {
        double[][] uData = cg.util.normalRandoms(size, size, 0.9, 0.2);
        double[][] vData = cg.util.normalRandoms(size, size, 0.9, 0.2);
        double[][] condData = new double[size][size];
        double[][] ones = new double[size][size];
        double[][] as = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //uData[i][j] = 0.5;
                vData[i][j] = 0.9;
                condData[i][j] = 0;
                ones[i][j] = 1.0;
                as[i][j] = a;
            }
        }

        //vData[size / 2][size / 2] = 1.0;


        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                uData[i][j] = 0;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = size / 2; j < size; j++) {
                vData[i][j] = 0;
            }
        }


        Matrix64 c = new Matrix64(condData);

        //condition = DEConditionFactory.DIRICHRET(c);
        condition = DEConditionFactory.PERIODIC(dx);
        //condition = DEConditionFactory.NEUMANN(dx);

        createGraph(uData, vData, ones, as);
    }

    public void createGraph(double[][] u, double[][] v, double[][] one, double[][] as) {
        U = cg.variable(u);
        V = cg.variable(v);

        CNode One = cg.constant(one);
        CNode A = cg.constant(as);
        CNode Gamma = cg.constant(gamma);
        CNode Epsilon = cg.constant(epsilon);
        CNode Du = cg.constant(du);
        CNode Dv = cg.constant(dv);
        CNode Dt = cg.constant(dt);
        CNode Dx = cg.constant(dx);

        CNode lapU = cg.laplacian(U, Dx, this.condition).multiply(Du);
        CNode lapV = cg.laplacian(V, Dx, this.condition).multiply(Dv);

        CNode lastU = U.entrywizeMultiply(One.subtract(U)).entrywizeMultiply(U.subtract(A)).subtract(V).divide(Epsilon);
        CNode lastV = U.subtract(V.multiply(Gamma));

        CNode newU = lapU.add(lastU).multiply(Dt).add(U);
        CNode newV = lapV.add(lastV).multiply(Dt).add(V);

        batch = cg.batch(cg.substitute(U, newU), cg.substitute(V, newV));
    }


    public void drawMatrix (Graphics g) {
        repaint();
        Dimension size = getSize();

        cg.execute(batch);

        Matrix64 visV = (Matrix64)V.getData().get();
        visV = visV.deepCopy();
        visV.multiply(10.0);
        float min;

        for (int i = 0, n = visV.getRow(); i < n; i++) {
            for (int j = 0, m = visV.getColumn(); j < m; j++) {
                min = (float) Math64.min(visV.get(i, j), 1.0);
                if (visV.get(i, j) < 0.0) {
                    //System.out.println(visV.get(i, j));
                    g.setColor(Color.black);
                }
                else {
                    g.setColor(new Color(1.0f - min, 1.0f - min, 0));
                }
                g.fillRect(i * ratio, j * ratio, ratio, ratio);
            }
        }
    }

    public void paint (Graphics g) {
        while (true) {
            drawMatrix(g);
        }
    }

    public static void main(String[] args) {
        FitzHughNagumoC fhn = new FitzHughNagumoC();
    }

}
