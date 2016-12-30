package org.real2space.neumann.congraph.core.data;

import org.real2space.neumann.approssi.core.util.DeepCopy;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/17/16
 */
 
public interface Data<E> extends DeepCopy<Data<E>> {
    public Data<E> ZERO();
    public Data<E> add(Data a);
    public Data<E> subtract(Data a);
    public Data<E> multiply(Data a);
    public Data<E> divide(Data a);
    public E get();
    public Data<E> deepCopy();
}