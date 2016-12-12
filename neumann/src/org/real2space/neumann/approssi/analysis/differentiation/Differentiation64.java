package org.real2space.neumann.approssi.analysis.differentiation;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/12/11
 */ 
 
public class Differentiation64 extends AbstractDifferentiation<Double, Double> {

    @Override
    public void substitute (String var, Double va) {
        getFunction("f").changeArgument(var, va);
    }
    
    @Override
    public void execute(String var, Double h) {
        double k = (double)h;
        double x = getFunction("f").getDouble(var);
        getFunction("f").execute();
        double fx = (double)getFunction("f").getResult();
        substitute(var, x + k);
        getFunction("f").execute();
        double fxh = (double)getFunction("f").getResult();
        substitute(var, x);
        this.result.set((fxh - fx) / h);
    }
}