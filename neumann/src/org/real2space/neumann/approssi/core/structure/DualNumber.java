package org.real2space.neumann.approssi.core.structure;

import org.real2space.neumann.approssi.core.util.DeepCopy;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/12/27
 */
 
public interface DualNumber<E> extends DeepCopy<DualNumber<E>> {
    /**
     * Get a of (a + b * epsilon)
     * @return E
     */
    public E a();
    
    /**
     * Get b of (a + b * epsilon)
     * @return E
     */
    public E b();
    
    /**
     * Add other to this.
     * @param other DualNumber<E>
     * @return void
     */
    public void add (DualNumber<E> other);
    
    /**
     * Subtract other from this. : this - other
     * @param other DualNumber<E>
     * @return void
     */
    public void subtract (DualNumber<E> other);
    
    /**
     * Multiply this by other.
     * @param other DualNumber<E>
     * @return void
     */
    public void multiply (DualNumber<E> other);
    
    /**
     * Divide this by other. : this / other
     * @param other DualNumber<E>
     * @return void
     */
    public void divide (DualNumber<E> other);

    public DualNumber<E> deepCopy();
}