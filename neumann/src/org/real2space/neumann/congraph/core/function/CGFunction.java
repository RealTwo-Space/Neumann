package org.real2space.neumann.congraph.core.function;

import org.real2space.neumann.approssi.core.function.Function;
import org.real2space.neumann.approssi.core.structure.*;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.DataConverter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/28/16
 */

public class CGFunction {
    private Function function;
    
    public CGFunction (Function function) {
        this.function = function;
    }
    
    public void changeArgument(String key, Data data) {

        if (data.get() instanceof Double) {
            this.function.changeArgument(key, (Double)data.get());
            return;
        }
        else if (data.get() instanceof Float) {
            this.function.changeArgument(key, (Float)data.get());
            return;
        }
        else if (data.get() instanceof Matrix) {
            this.function.changeArgument(key, (Matrix)data.get());
            return;
        }
        else if (data.get() instanceof Vector) {
            this.function.changeArgument(key, (Vector)data.get());
            return;
        }
        System.out.println(data.get().getClass());
        throw new NotImplementedException();
    }
    
    public void execute() {
        this.function.execute();
    }
    
    public Data getResult() {
        return  DataConverter.convert(this.function.getResult());
    }
    
    
}
