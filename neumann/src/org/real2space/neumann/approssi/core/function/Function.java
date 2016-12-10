package org.real2space.neumann.approssi.core.function;

import java.util.HashMap;
import org.real2space.neumann.approssi.core.structure;

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
    
    protected Function () {
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
    
    protected void setArgument (String var, Float va) {
        this.argument.put(var, new Variable<Float>(va));
    }
    
    protected void setArgument (String var, Double va) {
        this.argument.put(var, new Variable<Double>(va));
    }
    
    protected void setArgument (String var, Complex va) {
        this.argument.put(var, new Variable<Complex>(va));
    }
    
    protected void setArgument (String var, Vector va) {
        this.argument.put(var, new Variable<Vector>(va));
    }
    
    protected void setArgument (String var, Matrix va) {
        this.argument.put(var, new Variable<Matrix>(va));
    }
    
    protected void setArgument (String var, Function va) {
        this.argument.put(var, new Variable<Function>(va));
    }
    
    protected void setFloat (String var) {
        this.argument.put(var, new Variable<Float>());
    }
    
    protected void setDouble (String var) {
        this.argument.put(var, new Variable<Double>());
    }
    
    protected void setVector (String var) {
        this.argument.put(var, new Variable<Complex>());
    }
    
    protected void setVector (String var) {
        this.argument.put(var, new Variable<Vector>());
    }
    
    protected void setVector (String var) {
        this.argument.put(var, new Variable<Matrix>());
    }
    
    protected void setFunction (String var) {
        this.argument.put(var, new Variable<Function>());
    }
    
    protected Float getFloat(String var) {
        return (Float)this.argument.get(var).get();
    }
    
    protected Double getDouble(String var) {
        return (Double)this.argument.get(var).get();
    }
    
    protected Complex getComlex(String var) {
        return (Comlex)this.argument.get(var).get();
    }
    
    protected Vector getVector(String var) {
        return (Vector)this.argument.get(var).get();
    }
    
    protected Matrix getMatrix(String var) {
        return (Matrix)this.argument.get(var).get();
    }
    
    protected Function getFunction(String var) {
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