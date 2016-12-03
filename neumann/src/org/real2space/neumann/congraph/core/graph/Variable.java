package org.real2space.neumann.congraph.core.graph;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 11/28/16
 */

protected class Variable implements State {
    protected MonomialArgument arg;
    
    protected Variable(MonomialArgument arg) {
        this.arg = arg;
    }
    
    protected Variable(Variable var) {
        this.arg = var.arg;
    }
    
    protected Data execute() {
        return this.arg;
    }
}