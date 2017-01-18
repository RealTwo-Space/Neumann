package org.real2space.neumann.congraph.core.backpropagate.tensor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project Neumann
 * created 2017/01/08
 *
 * @author RealTwo-Space
 * @version 0
 */
public class ShapeTest {
    // 3 x 2 x 4 (i*YMAX+j)*XMAX+k
    //  111, 112, 113, 114, 121, 122, 123, 124, 211, 212, 214, ...
    //    0    1    2    3    4    5    6    7    8    9   10
    //
    //
    @Test
    public void getTensorIndex() throws Exception {
        Shape shape = new Shape(3,2,4);
        Shape shapeA = new Shape(3,2,4,3);
        Shape shapeB = new Shape(3,2,4,1);
        int N1 = shape.getIndex(1,1,1);
        int N2 = shape.getIndex(1,1,2);
        int N3 = shape.getIndex(3,2,4);
        System.out.println(N1);
        System.out.println(N2);
        System.out.println(N3);
        System.out.println(shapeB.getIndexWhichCanExpand(shapeA));
    }

}