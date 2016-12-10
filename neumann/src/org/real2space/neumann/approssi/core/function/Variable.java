package org.real2space.neumann.approssi.core.function;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/12/11
 */ 
 

public class Variable<E> {
    E value;
    
    public Variable(E value) {
        this.value = value;
    }
    
    public Variable() {
    }
    
    E get() {
        return this.value;
    }
    
    void set(E value) {
        this.value = value;
    }
}