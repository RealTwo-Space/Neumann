package org.real2space.neumann.approssi.analysis.differentiation;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/12/11
 */ 
 
public class Differentiation32 extends AbstractDifferentiation<Float, Float> {
    @Override
    public void substitute (String var, Float va) {
        getFunction("f").changeArgument(var, va);
    }
    
    @Override
    public void execute(String var, Float h) {
        float k = (float)h;
        float x = getFunction("f").getFloat(var);
        getFunction("f").execute();
        float fx = (float)getFunction("f").getResult();
        substitute(var, x + k);
        getFunction("f").execute();
        float fxh = (float)getFunction("f").getResult();
        substitute(var, x);
        this.result.set((fxh - fx) / h);
    }
}