package org.real2space.neumann.approssi.core.structure;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created    2016/11/01
 */
public interface GroupAdditive<G> extends Power<G> {
    /*
     * return opposite
     */
    public G opposite ();
    
    /*
     * add other
     */
    public void add (G other);
    
    /*
     * minus other
     */
    public void minus (G other);
    
}