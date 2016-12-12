package org.real2space.neumann.congraph.core.graph;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 11/29/16
 */
class BinomialArgument extends Argument {
    private Data[] args;
    
    protected BinomialArgument(Data argL, Data argR) {
        this.args = new Data[2];
        this.args[0] = argL;
        this.args[1] = argR;
    }
    
    protected Data getDataAt(int index) {
        return this.args[index];
    }
    
    protected int getSize() {
        return 2;
    }
}
