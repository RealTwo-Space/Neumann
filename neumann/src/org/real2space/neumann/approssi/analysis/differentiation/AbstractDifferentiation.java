package org.real2space.neumann.approssi.analysis.differentiation;

import org.real2space.neumann.approssi.core.function.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/12/11
 */ 
 
public abstract class AbstractDifferentiation<E, H> extends Function<E> {

    public AbstractDifferentiation() {
        super();
        result = new Variable<E>();
        setFunction("f");
    }

    public abstract void substitute (String var, E va);
    
    public void changeArgument(Function va) {
        changeArgument("f", va);
    }
    
    public void execute() {
        // throw exception
    }
    
    public abstract void execute(String var, H h);
}