package org.real2space.neumann.congraph.core.function;

import org.real2space.neumann.approssi.core.structure.*;
import org.real2space.neumann.congraph.core.operation.*;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DataConverter;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/28/16
 */

public class CGFunction {
    Function function;
    
    public CGFunction (Function function) {
        this.function = function;
    }
    
    public void changeArgument(String key, Data data) {
        if (data instanceof Double) {
            this.function.changeArgument(key, (Double)data.get());
        }
        else if (data instanceof Float) {
            this.function.changeArgument(key, (Float)data.get());
        }
        else if (data instanceof Matrix) {
            this.function.changeArgument(key, (Matrix)data.get());
        }
        else if (data instanceof Vector) {
            this.function.changeArgument(key, (Vector)data.get());
        }
        throw new NotImplementedException();
    }
    
    public void execute() {
        this.function.execute();
    }
    
    public Data getResult() {
        return  DataConverter.convert(this.function.getResult());
    }
    
    
}
