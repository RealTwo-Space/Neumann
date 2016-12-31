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
public class MultinomialArgument extends Argument {
    private Node[] args;
    
    public MultinomialArgument(Node[] args) {
        this.args = args;
    }
    
    public Data getDataAt(int index) {
        return this.args[index].refData();
    }
    
    public int getSize() {
        return this.args.length;
    }
}
