package org.real2space.neumann.evaris.core.structure;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created    2016/11/01
 */
 
public interface Order<F> {
    /*
     * Returns true if this is strictly greater than "other"
     */
    public boolean isGT (F other);
    
    /*
     * Returns true if this is greater than or equals to "other"
     */
    public boolean isGE (F other);
    
    /*
     * Returns true if this is strictly less than "other"
     */
    public boolean isLT (F other);
    
    /*
     * Returns true if this is less than or equals to "other"
     */
    public boolean isLE (F other);
    
} 