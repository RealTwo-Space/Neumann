package org.real2space.neumann.approssi.core.structure;

import org.real2space.neumann.approssi.core.util.DeepCopy;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/14
 */ 
 
public interface Vector<E> extends DeepCopy<Vector<E>> {
    /**
     * Add other to this.
     * @param Vector<E> other
     * @return void
     */
    public void add (Vector<E> other);
    
    /**
     * Subtract other to this.
     * @param Complex<E> other
     * @return void
     */
    public void subtract (Vector<E> other);
    
    /**
     * Multiply this scalar value to this.
     * @param Complex<E> other
     * @return void
     */
    public void multiply (E scalar);
    
    /**
     * Divide this vector by a scalar.
     * @param Complex<E> other
     * @return void
     */
    public void divide (E scalar);
    
    /**
     *  Get eulidian norm.
     * @param Complex<E> other
     * @return void
     */
    public E norm ();
    
    /**
     * Divide this by other.
     * @param Complex<E> other
     * @return void
     */
    public Matrix<E> toMatrix ();
}