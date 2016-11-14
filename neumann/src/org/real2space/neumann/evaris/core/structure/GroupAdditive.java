package org.real2space.neumann.evaris.core.structure;

import java.lang.Cloneable;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created    2016/11/01
 */
public interface GroupAdditive<G> extends EqualityAxiom<G>, Power<G>, Cloneable {
    /*
     * Returns opposite of this member
     */
    public G opposite ();
    
    /*
     * Add "other" to this member
     */
    public void add (G other);
    
    /*
     * Add opposite of "other" to this member
     */
    public void subtract (G other);
    
}