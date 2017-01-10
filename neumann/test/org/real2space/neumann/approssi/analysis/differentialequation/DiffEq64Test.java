package org.real2space.neumann.approssi.analysis.differentialequation;

import org.junit.Test;
import org.real2space.neumann.approssi.analysis.math.Math64;
import org.real2space.neumann.approssi.core.value.Matrix64;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */
public class DiffEq64Test {
    private class Visualize extends JFrame {
        Graphics g;

        public Visualize(){
            this.setSize(300, 200);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.g = this.getGraphics();
            // 描画のサンプル
            g.setColor(Color.RED);
            g.fillOval(50, 50, 100, 100);
        }
    }

    @Test
    public void visualizeTest () {
        Visualize v = new Visualize();
    }

    @Test
    public void TuringTest () {
        double f = 0.03;
        double k = 0.056;
        double du = 0.09;
        double dv = 0.056;
        double dx = 1.0;
        double dt = 1.0;


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

        Matrix64 u = new Matrix64(uData);
        Matrix64 v = new Matrix64(vData);
        Matrix64 c = new Matrix64(condData);
        Matrix64 one = new Matrix64(ones);

        Matrix64 newU;
        Matrix64 newV;

        BoundaryCondition64 cond = new DirichletCondition64(c);

        Matrix64 nablaU, nablaV;
        Matrix64 uvv;
        Matrix64 lastU;
        Matrix64 lastV;

        for (int i = 0; i < 1000; i++) {
            newU = u.deepCopy();
            newV = v.deepCopy();

            nablaU = DiffEq64.nabla(u, dx, cond);
            nablaU.multiply(du);
            nablaV = DiffEq64.nabla(v, dx, cond);
            nablaV.multiply(dv);

            uvv = DiffEq64.entrywiseMultiply(u, v);
            uvv = DiffEq64.entrywiseMultiply(uvv, v);

            lastU = one.deepCopy();
            lastU.subtract(u);
            lastU.multiply(f);

            lastV = v.deepCopy();
            lastV.multiply(f + k);

            nablaU.subtract(uvv);
            nablaU.add(lastU);
            nablaU.multiply(dt);

            nablaV.add(uvv);
            nablaV.subtract(lastV);
            nablaU.multiply(dt);

            newU.add(nablaU);
            newV.add(nablaV);

            u = newU.deepCopy();
            v = newV.deepCopy();
        }

        System.out.println(v);
    }

    @Test
    public void dirichletTest () {
        Random rand = new Random();
        double dx = 1.0;
        double[][] uData = {{1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0}};
        Matrix64 u = new Matrix64(uData);

        BoundaryCondition64 cond = new DirichletCondition64(u);
        System.out.println(u);

        for (int i = 0; i < 3; i++) {
            //u = DiffEq64.nabla(u, dx, cond);
            u = DiffEq64.laplacian(u, dx, cond);
            System.out.println(u + "\n");
        }
    }

    @Test
    public void periodicBoundaryTest () {
        Random rand = new Random();
        double dx = 1.0;
        double[][] uData = {{1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                            {1.0, 2.0, 3.0, 0.0, 5.0, 4.0}};
        Matrix64 u = new Matrix64(uData);

        BoundaryCondition64 cond = new PeriodicalBoundaryCondition64(dx);
        System.out.println(u);

        for (int i = 0; i < 3; i++) {
            //u = DiffEq64.nabla(u, dx, cond);
            u = DiffEq64.laplacian(u, dx, cond);
            System.out.println(u + "\n");
        }
    }

    @Test
    public void neumannTest () {
        Random rand = new Random();
        double dx = 1.0;
        double[][] uData = {{1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                {1.0, 2.0, 3.0, 0.0, 5.0, 4.0},
                {1.0, 2.0, 3.0, 0.0, 5.0, 4.0}};
        Matrix64 u = new Matrix64(uData);

        BoundaryCondition64 cond = new NeumannCondition64(dx);
        System.out.println(u);

        for (int i = 0; i < 3; i++) {
            //u = DiffEq64.nabla(u, dx, cond);
            u = DiffEq64.laplacian(u, dx, cond);
            System.out.println(u + "\n");
        }
    }
}