package org.real2space.neumann.congraph.core.backpropagate;

import org.junit.Test;
import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.bbackpropagate.Tensor;

/**
 * Created by ryosukesuzuki on 2016/12/30.
 */
public class TensorTest {
    @Test
    public void multiply1() throws Exception {
        Matrix64 a11, a12, a21, a22;
        Matrix64 b;
        Tensor ta, tb;
        a11 = new Matrix64(new double[][]{{1, 1}});
        a12 = new Matrix64(new double[][]{{2, 2}});
        a21 = new Matrix64(new double[][]{{3, 4}});
        a22 = new Matrix64(new double[][]{{2, 1}});
        b = new Matrix64(new double[][]{{2, 3}});
        ta = new Tensor(new Matrix64[][]{{a11,a12},{a21, a22}});
        tb = new Tensor(b);

        Tensor out = tb.multiply(ta);
        System.out.println(ta + ", rank: " + ta.getRank());
        System.out.println(tb + ", rank: " + tb.getRank());
        System.out.println(out + " = result" + ", rank: " + out.getRank());
        System.out.println("[[ [[11.0, 14.0]], [[10.0, 7.0]] ]] = answer, rank: 4");
    }

    @Test
    public void multiply2() throws Exception {
        Matrix64 a11, a12, a21, a22;
        Matrix64 b;
        Tensor ta, tb;
        a11 = new Matrix64(new double[][]{{1, 1}});
        a12 = new Matrix64(new double[][]{{2, 2}});
        a21 = new Matrix64(new double[][]{{3, 4}});
        a22 = new Matrix64(new double[][]{{2, 1}});
        b = new Matrix64(new double[][]{{2, 3}});

        ta = new Tensor(new Matrix64[][]{{a11,a12},{a21, a22}});
        tb = new Tensor(b);
        tb = tb.transpose();
        Tensor out = ta.multiply(tb);
        System.out.println(ta + ", rank: " + ta.getRank());
        System.out.println(tb + ", rank: " + tb.getRank());
        System.out.println(out + " = result" + ", rank: " + out.getRank());
    }

    @Test
    public void multiply3() throws Exception {
        Matrix64 a11, a12, a21, a22;
        Matrix64 b11, b12, b21, b22;
        Tensor ta, tb;
        a11 = new Matrix64(new double[][]{{1, 1},{2, 2}});
        a12 = new Matrix64(new double[][]{{2, 2},{2, 2}});
        a21 = new Matrix64(new double[][]{{3, 4},{2, 2}});
        a22 = new Matrix64(new double[][]{{2, 1},{2, 2}});
        b11 = new Matrix64(new double[][]{{1, 3},{2, 2}});
        b12 = new Matrix64(new double[][]{{5, 1},{2, 2}});
        b21 = new Matrix64(new double[][]{{2, 3},{2, 2}});
        b22 = new Matrix64(new double[][]{{1, 1},{2, 2}});
        ta = new Tensor(new Matrix64[][]{{a11,a12},{a21,a22}});
        tb = new Tensor(new Matrix64[][]{{b11,b12},{b21,b22}});

        System.out.println(ta + ", rank: " + ta.getRank());
        System.out.println(tb + ", rank: " + tb.getRank());
        Tensor out = ta.multiply(tb);
        System.out.println(out + " = result" + ", rank: " + out.getRank());
    }

}