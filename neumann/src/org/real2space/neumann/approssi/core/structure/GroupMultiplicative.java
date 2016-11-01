package org.real2space.neumann.approssi.core.structure;

import java.lang.Cloneable;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created    2016/11/01
 */
public interface GroupMultiplicative<G> extends EqualityAxiom<G>, Power<G>, Cloneable {
    /*
     * Returns inverse of this member
     */
    public G inverse ();
    
    /*
     * Multiply this by "other" 
     */
    public void multiply (G other);
    
    /*
     * Multiply this by the inverse of "other"
     */
    public void divide (G other);
}