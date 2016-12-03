package org.real2space.neumann.congraph.core.graph;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 11/29/16
 */
protected class Constant implements State {
    private MonomialArgument arg;
    
    protected Constant(Data data) {
        this.arg = new MonomialArgument(data);
    }
    
    protected Data execute() {
        return this.arg.getDataAt(0);
    }
}
