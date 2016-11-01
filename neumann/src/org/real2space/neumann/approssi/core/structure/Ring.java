package org.real2space.neumann.approssi.core.structure;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created    2016/11/01
 */
 
public interface Ring<R> extends GroupAditive<R>, Residue<R> {
    /*
     * Multiply this by "other"
     */
    public void multiply (R other);
}