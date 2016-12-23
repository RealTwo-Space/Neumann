package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.congraph.core.data.Data;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/24/16
 */


public class SubstituteArgument extends BinomialArgument {
    public SubstituteArgument (Node argL, Node argR) {
        // type check
        super(argL, argR);
    }
    
    public void substitute() {
        this.args[0].setData(this.args[1].getData());
    }
    
}