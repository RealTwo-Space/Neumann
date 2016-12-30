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
public class MonomialArgument extends Argument {
    private Node arg;
    
    public MonomialArgument(Node arg) {
        this.arg = arg;
    }
    
    public Data getDataAt(int index) {
        return this.arg.refData();
    }
    
    public int getSize() {
        return 1;
    }

}