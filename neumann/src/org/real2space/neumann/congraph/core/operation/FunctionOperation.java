package org.real2space.neumann.congraph.core.operation;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.structure.Vector;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DataConverter;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;
import org.real2space.neumann.approssi.core.function.*;

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
    private Function function;
    private HashMap<String, Node> args;
    
    public FunctionOperation(Function f, HashMap<String, Node> args) {
        this.function = f;
        this.args = new HashMap<String, Node>();
        this.args.putAll(args);
    }
    
    public Data execute() {
        Object temp;
        for(String key : this.args.keySet()) {
            temp = this.args.get(key).getData().get();
            if (temp instanceof Double) {
                this.function.changeArgument(key, (Double)temp);
            }
            else if (temp instanceof Float) {
                this.function.changeArgument(key, (Float)temp);
            }
            else if (temp instanceof Matrix) {
                this.function.changeArgument(key, (Matrix)temp);
            }
            else if (temp instanceof Vector) {
                this.function.changeArgument(key, (Vector)temp);
            }

		}
		this.function.execute();
		return DataConverter.convert(this.function.getResult());
    }
}
