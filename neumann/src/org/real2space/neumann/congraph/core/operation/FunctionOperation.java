package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.congraph.core.function.CGFunction;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;
import org.real2space.neumann.approssi.core.function.function;

import java.util.HashMap;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/18/16
 */

public class FunctionOperation extends Operation {
    private CGFunction function;
    private HashMap<String, Node> args;
    
    public FunctionOperation(Function f, HashMap<String, Node> args) {
        this.function = new CGFunction(f);
        this.args = new HashMap<String, Node>();
        this.args.putAll(args);
    }
    
    public Data execute() {
        for(String key : this.args.keySet()) {
            this.function.changeArgument(key, this.args.get(key).refData());
		}
		this.function.execute();
		return this.function.getResult();
    }
}
