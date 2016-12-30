package org.real2space.neumann.congraph.core.backpropagate.differentiation;

import org.junit.Test;

import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DoubleData;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.operation.*;
import org.real2space.neumann.congraph.core.operation.SubtractOperation;

import static org.junit.Assert.*;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class DiffTest {
    @Test
    public void addOp() throws Exception {
        Diff diff = Diff.valueOf(new AddOperation(null, null));

        Data[] d = diff.execute(new DoubleData(4.0), new DoubleData(3.0));
        System.out.println(d[0]);
        System.out.println(d[1]);

    }

    @Test
    public void subOp() throws Exception {
        Diff diff = Diff.valueOf(new SubtractOperation(null, null));

        Data[] d = diff.execute(new DoubleData(4.0), new DoubleData(3.0));
        System.out.println(d[0]);
        System.out.println(d[1]);

    }

    @Test
    public void multOp() throws Exception {
        Diff diff = Diff.valueOf(new MultiplyOperation(null, null));

        Data[] d = diff.execute(new DoubleData(4.0), new DoubleData(3.0));
        System.out.println(d[0]);
        System.out.println(d[1]);

    }

    @Test
    public void multOp2() throws Exception {
        Diff diff = Diff.valueOf(new MultiplyOperation(null, null));


        double[][] da = {{1,1},{1,1},{2,2}};
        double[][] db = {{4,4,4,4},{1,1,1,1}};
        Matrix64 a, b;
        a = new Matrix64(da);
        b = new Matrix64(db);

        Data[] d = diff.execute(new MatrixData(a), new MatrixData(b));
        System.out.println(d[0]);
        System.out.println(d[1]);

    }

    @Test
    public void divOp() throws Exception {
        Diff diff = Diff.valueOf(new DivideOperation(null, null));

        double[][] da = {{1,1},{1,1},{2,2}};
        Matrix64 a;
        a = new Matrix64(da);

        Data[] d = diff.execute(new MatrixData(a), new DoubleData(3.0));
        System.out.println(d[0]);
        System.out.println(d[1]);

    }

}