package org.real2space.neumann.approssi.core.value;

import org.junit.Test;
import org.real2space.neumann.approssi.core.structure.Complex;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          <p>
 *          created 11/14/16
 */
public class Complex32Test {
    @Test
    public void createInstance () {
        Complex a = new Complex32 (1f, 2f);
        Complex32 b = new Complex32 (1f, 2f);
        System.out.println(a.re() + " " + a.im());
        System.out.println(b.re() + " " + b.im());
    }

    @Test
    public void add () {
        Complex a = new Complex32 (1f, 2f);
        Complex32 b = new Complex32 (3f, 10f);
        Complex32 c = new Complex32 (4f, -5f);

        c.add(a);
        System.out.println(c.re());
    }
}