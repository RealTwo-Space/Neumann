package org.real2space.neumann.approssi.core.value;

import org.real2space.neumann.approssi.core.structure.DualNumber;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created 2016/12/27
 */

public class DualNumber32 implements DualNumber<Float> {
    private float a;
    private float b;

    public DualNumber32(float a, float b) {
        this.a = a;
        this.b = b;
    }
    
    public DualNumber32(float a) {
        this.a = a;
        this.b = 1.0f;
    }
    
    public final Float a() {
        return this.a;
    }
    
    /**
     * Gets a of (a + b epsilon).
     * @param dual DualNumber32
     * @return double
     */
    public static float a(DualNumber32 dual) {
        return dual.a;
    }
    
    public final Float b() {
        return this.b;
    }
    
    /**
     * Gets an imaginary part of a.
     * @param dual DualNumber32
     * @return double
     */
    public static float b(DualNumber32 dual) {
        return dual.b;
    }
    
   
    
    // add
    public void add(DualNumber<Float> other) {
        DualNumber32 temp = (DualNumber32)other;

        this.a += temp.a;
        this.b += temp.b;
    }
    
    /**
     * Add x to y : x + y
     * @param x DualNumber32
     * @param y DualNumber32
     * @return DualNumber32
     */
    public static DualNumber32 add(DualNumber32 x, DualNumber32 y) {
        DualNumber32 res = x.deepCopy();
        res.add(y);
        
        return res;
    }
    
    // subtract
    public void subtract(DualNumber<Float> other) {
        DualNumber32 temp = (DualNumber32)other;
        this.a -= temp.a;
        this.b -= temp.b;
    }
    
    /**
     * Subtract y from x : x - y
     * @param x DualNumber32
     * @param y DualNumber32
     * @return DualNumber32
     */
    public static DualNumber32 subtract(DualNumber32 x, DualNumber32 y) {
        DualNumber32 res = x.deepCopy();
        res.subtract(y);
        return res;
    }
    
    //(a1+b1e)(a2+b2e) = a1a2 + (a1b2 + b1a2)e
    public void multiply(DualNumber<Float> other) {
        DualNumber32 temp = (DualNumber32)other;
        
        float tempa = this.a * temp.a;
        this.b = this.a * temp.b + this.b * temp.a;
        this.a = tempa;

    }
    
    /**
     * Multiply y to x : x * y
     * @param x DualNumber32
     * @param y DualNumber32
     * @return DualNumber32
     */
    public static DualNumber32 multiply(DualNumber32 x, DualNumber32 y) {
        DualNumber32 res = x.deepCopy();
        res.multiply(y);
        
        return res;
    }
    
    //(a + be)/(a'+b'e) = (a+be)(a'-b'e)/(a'^2) = (aa' + (ba' - ab')e)/(a'^2)
    //                  = (a / a') + (ba' - ab')e/(a'^2)
    public void divide(DualNumber<Float> other) {
        DualNumber32 temp = (DualNumber32)other;
        
        float tempad = 1.0f / temp.a;
        float tempa = this.a * tempad;
        this.b = (this.b * temp.a - this.a * temp.b) * tempad * tempad;
        this.a = tempa;
    }
    
    /**
     * Divide x by y : x / y
     * @param x DualNumber32
     * @param y DualNumber32
     * @return DualNumber32
     */
    public static DualNumber32 divide(DualNumber32 x, DualNumber32 y) {
        DualNumber32 res = x.deepCopy();
        res.divide(y);
        
        return res;
    }
    
    public DualNumber32 deepCopy() {
        return new DualNumber32 (this.a, this.b);
    }
    
    public String toString() {
        if (this.b >= 0) {
            return this.a + " + "  + this.b + "e";
        }
        return this.a + " - " + (- this.b) + "e";
    }
}