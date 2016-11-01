package org.real2space.neumann.approssi.core.structure;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created    2016/11/01
 */
public interface Field<F> {
    /*
     * Multiply this member by an inverse of "other".
     */ 
    public void divide (F other);
    
    /*
     * Returns an inverse of this member.
     */ 
    public F inverse ();
}