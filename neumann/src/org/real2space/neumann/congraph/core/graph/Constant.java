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
class Constant extends State {
    private ConstantArgument arg;

    protected Constant(Data data) {
        this.arg = new ConstantArgument(data);
    }
    
    public Data execute() {
        return this.arg.getDataAt(0);
    }
}
