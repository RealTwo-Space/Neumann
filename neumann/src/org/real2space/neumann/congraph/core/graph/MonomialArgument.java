package org.real2space.neumann.congraph.core.graph;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 11/29/16
 */
class MonomialArgument extends Argument {
    private Data arg;
    
    protected MonomialArgument(Data arg) {
        this.arg = arg;
    }
    
    protected Data getDataAt(int index) {
        return this.arg;
    }
    
    protected int getSize() {
        return 1;
    }

}