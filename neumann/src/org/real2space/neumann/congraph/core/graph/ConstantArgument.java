package org.real2space.neumann.congraph.core.graph;
import org.real2space.neumann.congraph.core.data.Data;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 12/18/16
 */
class ConstantArgument extends Argument {
    private Data arg;

    protected ConstantArgument(Data arg) {
        this.arg = arg;
    }
    
    protected Data getDataAt(int index) {
        return this.arg;
    }
    
    protected int getSize() {
        return 1;
    }

}