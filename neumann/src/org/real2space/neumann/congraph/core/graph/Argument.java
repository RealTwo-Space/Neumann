package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.congraph.core.data.Data;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          
 * created 11/28/16
 */
abstract class Argument {
    abstract Data getDataAt(int index);
    abstract int getSize();
}
