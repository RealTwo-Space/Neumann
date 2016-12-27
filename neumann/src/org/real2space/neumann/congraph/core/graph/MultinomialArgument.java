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
class MultinomialArgument extends Argument {
    private Node[] args;
    
    protected MultinomialArgument(Node[] args) {
        this.args = args;
    }
    
    protected Data getDataAt(int index) {
        return this.args[index].refData();
    }
    
    protected int getSize() {
        return this.args.length;
    }
}
