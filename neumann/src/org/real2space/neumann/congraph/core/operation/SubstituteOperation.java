package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;
import org.real2space.neumann.congraph.core.graph.SubstituteArgument;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/24/16
 */

public class SubstituteOperation extends Operation {
    private SubstituteArgument arg;
    
    // a <- b
    public SubstituteOperation(Node a, Node b) {
        this.arg = new SubstituteArgument(a, b);
    }
    
    public Data execute() {
        this.arg.substitute();
        return this.arg.getDataAt(1).deepCopy();
    }
}