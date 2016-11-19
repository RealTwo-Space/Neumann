package org.real2space.neumann.approssi.core.structure;

import org.real2space.neumann.approssi.core.util.DeepCopy;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/11/14
 */ 
 
public interface Complex<E> extends DeepCopy <Complex<E>>{
    
    /**
     * Get real part
     * @return E
     */
    public E re ();
    
    /**
     * Get imaginary part.
     * @return E
     */
    public E im ();
    
    /**
     * Get conjugate of this.
     * @return Complex<E>
     */
    public Complex<E> conjugate ();
    
    /**
     * Add other to this.
     * @param other Complex<E>
     * @return void
     */
    public void add (Complex<E> other);
    
    /**
     * Subtract other from this. : this - other
     * @param other Complex<E>
     * @return void
     */
    public void subtract (Complex<E> other);
    
    /**
     * Multiply this by other.
     * @param other Complex<E>
     * @return void
     */
    public void multiply (Complex<E> other);
    
    /**
     * Divide this by other. : this / other
     * @param other Complex<E>
     * @return void
     */
    public void divide (Complex<E> other);
    
    /**
     * Calculate an absolute value of this.
     * @return E
     */
    public E abs ();
    
    /**
     * Calculate an argument of this.
     * @return E
     */
    public E arg ();
}