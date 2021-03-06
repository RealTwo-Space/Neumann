package org.real2space.neumann.congraph.core.graph;
import org.real2space.neumann.congraph.core.data.Data;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 11/29/16
 */
class MonomialArgument extends Argument {
    private Node arg;
    
    protected MonomialArgument(Node arg) {
        this.arg = arg;
    }
    
    protected Data getDataAt(int index) {
        return this.arg.refData();
    }
    
    protected int getSize() {
        return 1;
    }

}