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
 * created 1/12/17
 */
public class DiffusionTestC extends JFrame {
    Congraph cg;
    DECondition condition;

    // must make d * dt / dx^2 ≤ 0.5, otherwise collapse
    double d_ = 0.2;
    double dx_ = 1.0;
    double dt_ = 1.0;

    CNode u;
    CNode out;

    public DiffusionTestC() {
        cg = new Congraph();

        initialize();
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initialize() {
        double[][] uData = new double[200][200];
        //double[][] uData = cg.util.normalRandoms(200, 200, 0.2, 0.3);
        double[][] bcond = new double[200][200];


        for (int i = 0; i < 120; i++) {
            for (int j = 80; j < 120; j++) {
                uData[i][j] = 1.0;
            }
        }


        u = cg.variable(uData);
        condition = DEConditionFactory.DIRICHRET(new Matrix64(bcond));
        //condition = DEConditionFactory.PERIODIC(dx_);
        //condition = DEConditionFactory.NEUMANN(dx_);

        createGraph();
    }

    private void createGraph () {
        CNode dx = cg.constant(dx_);
        CNode dt = cg.constant(dt_);
        CNode d = cg.constant(d_);

        out = cg.substitute(u, u.add(cg.laplacian(u, dx, condition).multiply(d).multiply(dt)));
    }

    public void paint(Graphics g) {
        while (true) {
            drawMatrix(g, u);
        }
    }

    private void drawMatrix(Graphics g, CNode u) {
        repaint();
        Dimension size = getSize();

        cg.execute(out);

        Matrix64 U = (Matrix64)u.getData().get();
        //U.multiply(1.0);
        float min;

        for (int i = 0, n = U.getRow(); i < n; i++) {
            for (int j = 0, m = U.getColumn(); j < m; j++) {
                min = (float) Math64.min(U.get(i, j), 1.0);
                if (U.get(i, j) < 0.0) {
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
        DiffusionTestC dt = new DiffusionTestC();
    }
}
