package org.real2space.neumann.approssi.core.value;

import org.real2space.neumann.approssi.core.structure.DualNumber;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created 2016/12/27
 */

public class DualNumber64 implements DualNumber<Double> {
    private double a;
    private double b;

    public DualNumber64(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    public DualNumber64(double a) {
        this.a = a;
        this.b = 1.0;
    }
    
    public final Double a() {
        return this.a;
    }
    
    /**
     * Gets a of (a + b epsilon).
     * @param dual DualNumber64
     * @return double
     */
    public static double a(DualNumber64 dual) {
        return dual.a;
    }
    
    public final Double b() {
        return this.b;
    }
    
    /**
     * Gets an imaginary part of a.
     * @param dual DualNumber64
     * @return double
     */
    public static double b(DualNumber64 dual) {
        return dual.b;
    }
    
   
    
    // add
    public void add(DualNumber<Double> other) {
        DualNumber64 temp = (DualNumber64)other;

        this.a += temp.a;
        this.b += temp.b;
    }
    
    /**
     * Add x to y : x + y
     * @param x DualNumber64
     * @param y DualNumber64
     * @return DualNumber64
     */
    public static DualNumber64 add(DualNumber64 x, DualNumber64 y) {
        DualNumber64 res = x.deepCopy();
        res.add(y);
        
        return res;
    }
    
    // subtract
    public void subtract(DualNumber<Double> other) {
        DualNumber64 temp = (DualNumber64)other;
        this.a -= temp.a;
        this.b -= temp.b;
    }
    
    /**
     * Subtract y from x : x - y
     * @param x DualNumber64
     * @param y DualNumber64
     * @return DualNumber64
     */
    public static DualNumber64 subtract(DualNumber64 x, DualNumber64 y) {
        DualNumber64 res = x.deepCopy();
        res.subtract(y);
        return res;
    }
    
    //(a1+b1e)(a2+b2e) = a1a2 + (a1b2 + b1a2)e
    public void multiply(DualNumber<Double> other) {
        DualNumber64 temp = (DualNumber64)other;
        
        double tempa = this.a * temp.a;
        this.b = this.a * temp.b + this.b * temp.a;
        this.a = tempa;

    }
    
    /**
     * Multiply y to x : x * y
     * @param x DualNumber64
     * @param y DualNumber64
     * @return DualNumber64
     */
    public static DualNumber64 multiply(DualNumber64 x, DualNumber64 y) {
        DualNumber64 res = x.deepCopy();
        res.multiply(y);
        
        return res;
    }
    
    //(a + be)/(a'+b'e) = (a+be)(a'-b'e)/(a'^2) = (aa' + (ba' - ab')e)/(a'^2)
    //                  = (a / a') + (ba' - ab')e/(a'^2)
    public void divide(DualNumber<Double> other) {
        DualNumber64 temp = (DualNumber64)other;
        
        double tempad = 1.0 / temp.a;
        double tempa = this.a * tempad;
        this.b = (this.b * temp.a - this.a * temp.b) * tempad * tempad;
        this.a = tempa;
    }
    
    /**
     * Divide x by y : x / y
     * @param x DualNumber64
     * @param y DualNumber64
     * @return DualNumber64
     */
    public static DualNumber64 divide(DualNumber64 x, DualNumber64 y) {
        DualNumber64 res = x.deepCopy();
        res.divide(y);
        
        return res;
    }
    
    public DualNumber64 deepCopy() {
        return new DualNumber64 (this.a, this.b);
    }
    
    public String toString() {
        if (this.b >= 0) {
            return this.a + " + "  + this.b + "e";
        }
        return this.a + " - " + (- this.b) + "e";
    }
}