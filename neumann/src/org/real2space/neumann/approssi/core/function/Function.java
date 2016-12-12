package org.real2space.neumann.approssi.core.function;

import java.util.HashMap;
import org.real2space.neumann.approssi.core.structure.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/12/11
 */

public abstract class Function<E> {
    protected HashMap<String, Variable> argument;
    protected Variable<E> result;
    
    public Function () {
        this.argument = new HashMap<String, Variable>();
    }
    
    public void changeArgument (String var, Float va) {
        this.argument.get(var).set(va);
    }

    public void changeArgument (String var, Double va) {
        this.argument.get(var).set(va);
    }
    
    public void changeArgument (String var, Complex va) {
        this.argument.get(var).set(va);
    }
    
    public void changeArgument (String var, Vector va) {
        this.argument.get(var).set(va);
    }
    
    public void changeArgument (String var, Matrix va) {
        this.argument.get(var).set(va);
    }
    
    public void changeArgument (String var, Function va) {
        this.argument.get(var).set(va);
    }
    
    public void setArgument (String var, Float va) {
        this.argument.put(var, new Variable<Float>(va));
    }
    
    public void setArgument (String var, Double va) {
        this.argument.put(var, new Variable<Double>(va));
    }
    
    public void setArgument (String var, Complex va) {
        this.argument.put(var, new Variable<Complex>(va));
    }
    
    public void setArgument (String var, Vector va) {
        this.argument.put(var, new Variable<Vector>(va));
    }
    
    public void setArgument (String var, Matrix va) {
        this.argument.put(var, new Variable<Matrix>(va));
    }
    
    public void setArgument (String var, Function va) {
        this.argument.put(var, new Variable<Function>(va));
    }
    
    public void setFloat (String var) {
        this.argument.put(var, new Variable<Float>());
    }
    
    public void setDouble (String var) {
        this.argument.put(var, new Variable<Double>());
    }
    
    public void setComplex (String var) {
        this.argument.put(var, new Variable<Complex>());
    }
    
    public void setVector (String var) {
        this.argument.put(var, new Variable<Vector>());
    }
    
    public void setMatrix (String var) {
        this.argument.put(var, new Variable<Matrix>());
    }
    
    public void setFunction (String var) {
        this.argument.put(var, new Variable<Function>());
    }
    
    public Float getFloat(String var) {
        return (Float)this.argument.get(var).get();
    }
    
    public Double getDouble(String var) {
        return (Double)this.argument.get(var).get();
    }
    
    public Complex getComlex(String var) {
        return (Complex)this.argument.get(var).get();
    }
    
    public Vector getVector(String var) {
        return (Vector)this.argument.get(var).get();
    }
    
    public Matrix getMatrix(String var) {
        return (Matrix)this.argument.get(var).get();
    }
    
    public Function getFunction(String var) {
        return (Function)this.argument.get(var).get();
    }
    
    public Variable getArgument(String var) {
        return this.argument.get(var);
    }
    
    public E getResult() {
        return this.result.get();
    }
    
    public abstract void execute();

}