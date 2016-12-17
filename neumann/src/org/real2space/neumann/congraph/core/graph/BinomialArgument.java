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
public class BinomialArgument extends Argument {
    private Data[] args;
    
    public BinomialArgument(Data argL, Data argR) {
        this.args = new Data[2];
        this.args[0] = argL;
        this.args[1] = argR;
    }
    
    public Data getDataAt(int index) {
        return this.args[index];
    }
    
    public int getSize() {
        return 2;
    }
}
