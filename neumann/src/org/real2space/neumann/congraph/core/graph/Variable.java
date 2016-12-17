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

class Variable extends State {
    protected MonomialArgument arg;

    protected Variable () {
    }
    /*
    protected Variable(MonomialArgument arg) {
        this.arg = arg;
    }
    */
    
    protected Variable(Variable var) {
        this.arg = var.arg;
    }

    protected void setMonomialArgument(Node node) {
        this.arg = new MonomialArgument(node);
    }
    
    public Data execute() {
        return this.arg.getDataAt(0);
    }
}