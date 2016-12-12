package org.real2space.neumann.congraph.core.graph;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 11/29/16
 */
class MultinomialArgument extends Argument {
    private Data[] args;
    
    protected MultinomialArgument(Data[] args) {
        this.args = args;
    }
    
    protected Data getDataAt(int index) {
        return this.args[index];
    }
    
    protected int getSize() {
        return this.args.length;
    }
}
