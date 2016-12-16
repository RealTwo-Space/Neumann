package org.real2space.neumann.congraph.core.data;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/17/16
 */
 
public interface Data<E> {
    public Data<E> add(Data a);
    public Data<E> subtract(Data a);
    public Data<E> multiply(Data a);
    public Data<E> divide(Data a);
    public E get();
}