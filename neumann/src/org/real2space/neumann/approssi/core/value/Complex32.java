package org.real2space.neumann.approssi.core.value;

import org.real2space.neumann.approssi.core.structure.Complex;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/14
 */

public class Complex32 implements Complex<Float> {
    private float re;
    private float im;

    public Complex32 (float re, float im) {
        this.re = re;
        this.im = im;
    }
    
    public final Float re () {
        return this.re;
    }
    
    /**
     * Gets a real part of a.
     * @param a Complex32
     * @return float
     */
    public static float re (Complex32 a) {
        return a.re;
    }
    
    public final Float im () {
        return this.im;
    }
    
    /**
     * Gets an imaginary part of a.
     * @param a Complex32
     * @return float
     */
    public static float im (Complex32 a) {
        return a.im;
    }
    
    public Complex32 conjugate () {
        return new Complex32 (this.re, - this.im);
    }
    
    
    /**
     * Gets a conjugate of a.
     * @param a Complex32
     * @return Complex32
     */
    public static Complex32 conjugate (Complex32 a) {
        return a.conjugate ();
    }
    
    // add
    public void add (Complex<Float> other) {
        Complex32 temp = (Complex32) other;

        this.re += temp.re;
        this.im += temp.im;
    }
    
    /**
     * Add b to a : a + b
     * @param a Complex32
     * @param b Complex32
     * @return Complex32
     */
    public static Complex32 add (Complex32 a, Complex32 b) {
        Complex32 o = a.deepCopy();
        o.add(b);
        
        return o;
    }
    
    // subtract
    public void subtract (Complex<Float> other) {
        Complex32 temp = (Complex32) other;
        this.re -= temp.re;
        this.im -= temp.im;
    }
    
    /**
     * Subtract b from a : a - b
     * @param a Complex32
     * @param b Complex32
     * @return Complex32
     */
    public static Complex32 subtract (Complex32 a, Complex32 b) {
        Complex32 res = a.deepCopy ();
        res.subtract (b);
        return res;
    }

    public void multiply (Complex<Float> other) {
        Complex32 temp = (Complex32)other;

        float tre = this.re * temp.re - this.im * temp.im;
        this.im = this.re * temp.im + this.im * temp.re;
        this.re = tre;

    }
    
    /**
     * Multiply b to a : a * b
     * @param a Complex32
     * @param b Complex32
     * @return Complex32
     */
    public static Complex32 multiply (Complex32 a, Complex32 b) {
        Complex32 o = a.deepCopy();
        o.multiply(b);
        
        return o;
    }
    
    public void divide (Complex<Float> other) {
        Complex32 temp = (Complex32)other;

        float a = 1f / (temp.im * temp.im + temp.re * temp.re);

        float tre = (this.re * temp.re + this.im * temp.im) * a;
        this.im = (this.im * temp.re + this.re * temp.im) * a;
        this.re = tre;
    }
    
    /**
     * Divide a by b : a / b
     * @param a Complex32
     * @param b Complex32
     * @return Complex32
     */
    public static Complex32 divide (Complex32 a, Complex32 b) {
        Complex32 o = a.deepCopy();
        o.divide(b);
        
        return o;
    }

    public Float abs () {
        return 0f;
    }
    
    /**
     * Gets an absolute value of a
     * @param a Complex32
     * @return Float
     */
    public static Float abs (Complex32 a) {
        return a.abs();
    }
    
    public Float arg () {
        return 0f;
    }
    
    /**
     * Gets an argument of a.
     * @param a Complex32
     * @return Float
     */
    public static Float arg (Complex32 a) {
        return a.arg();
    }
    
    public Complex32 deepCopy () {
        return new Complex32 (this.re, this.im);
    }
    
    public String toString () {
        return this.re + " + "  + this.im + "i";
    }
}