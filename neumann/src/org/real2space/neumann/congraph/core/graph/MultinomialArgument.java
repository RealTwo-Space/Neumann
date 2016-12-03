package org.real2space.neumann.congraph.core.graph;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 11/29/16
 */
protected class MultinomialArgument implements Argument {
    private Data[] args;
    
    protected MonomialArgument(Data[] args) {
        this.args = args;
    }
    
    protected Data getDataAt(int index) {
        return this.arg[index];
    }
    
    protected int getSize() {
        return this.args.length;
    }
}
