package org.real2space.neumann.evaris.core.structure;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created    2016/11/01
 * added "extends Ring<F>" 2016/11/9
 */
public interface Field<F> extends Ring<F> {
    /*
     * Multiply this member by an inverse of "other".
     */ 
    public void divide (F other);
    
    /*
     * Returns an inverse of this member.
     */ 
    public F inverse ();
}