package org.real2space.neumann.congraph.core.data;

import org.junit.Test;
import org.real2space.neumann.congraph.core.graph.Congraph;
import org.real2space.neumann.congraph.core.graph.Node;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 12/28/16
 */
public class DataTypeConverterTest {
    @Test
    public void dataConvertTest () {
        Congraph cg = new Congraph();
        Node a = cg.constant(1.0);

        System.out.println(a.refData());

        a.setData(DataTypeConverter.convert(a.refData()));

        System.out.println(a.refData());
    }
}