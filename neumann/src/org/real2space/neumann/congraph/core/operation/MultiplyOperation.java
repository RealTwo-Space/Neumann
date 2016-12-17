package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.graph.Operation;
import org.real2space.neumann.congraph.core.graph.BinomialArgument;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/18/16
 */

public class MultiplyOperation extends Operation {
    private BinomialArgument arg;
    
    public MultiplyOperation(Data a, Data b) {
        this.arg = new BinomialArgument(a, b);
    }
    
    public Data execute() {
        return arg.getDataAt(0).multiply(arg.getDataAt(1));
    }
}