package org.real2space.neumann.approssi.core.value;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          <p>
 *          created 11/18/16
 */
public class Vector64Test {
    @Test
    public void toMatrixTest () {
        Vector64 a = new Vector64 (new double[]{1, 2});
        System.out.println(a);

        Matrix64 b = a.toMatrix();
        System.out.println(b);
    }
}