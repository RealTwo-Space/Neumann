package org.real2space.neumann.approssi.core.value;

import org.real2space.neumann.approssi.core.structure.Complex;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/11/15
 */

public class Complex64 implements Complex<Double> {
    private double re;
    private double im;

    public Complex64 (double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    public final Double re () {
        return this.re;
    }
    
    /**
     * Gets a real part of a.
     * @param a Complex64
     * @return double
     */
    public static double re (Complex64 a) {
        return a.re;
    }
    
    public final Double im () {
        return this.im;
    }
    
    /**
     * Gets an imaginary part of a.
     * @param a Complex64
     * @return double
     */
    public static double im (Complex64 a) {
        return a.im;
    }
    
    public Complex64 conjugate () {
        return new Complex64 (this.re, - this.im);
    }
    
    
    /**
     * Gets a conjugate of a.
     * @param a Complex64
     * @return Complex64
     */
    public static Complex64 conjugate (Complex64 a) {
        return a.conjugate ();
    }
    
    // add
    public void add (Complex<Double> other) {
        Complex64 temp = (Complex64) other;

        this.re += temp.re;
        this.im += temp.im;
    }
    
    /**
     * Add b to a : a + b
     * @param a Complex64
     * @param b Complex64
     * @return Complex64
     */
    public static Complex64 add (Complex64 a, Complex64 b) {
        Complex64 o = a.deepCopy();
        o.add(b);
        
        return o;
    }
    
    // subtract
    public void subtract (Complex<Double> other) {
        Complex64 temp = (Complex64) other;
        this.re -= temp.re;
        this.im -= temp.im;
    }
    
    /**
     * Subtract b from a : a - b
     * @param a Complex64
     * @param b Complex64
     * @return Complex64
     */
    public static Complex64 subtract (Complex64 a, Complex64 b) {
        Complex64 res = a.deepCopy ();
        res.subtract (b);
        return res;
    }

    public void multiply (Complex<Double> other) {
        Complex64 temp = (Complex64)other;

        double tre = this.re * temp.re - this.im * temp.im;
        this.im = this.re * temp.im + this.im * temp.re;
        this.re = tre;

    }
    
    /**
     * Multiply b to a : a * b
     * @param a Complex64
     * @param b Complex64
     * @return Complex64
     */
    public static Complex64 multiply (Complex64 a, Complex64 b) {
        Complex64 o = a.deepCopy();
        o.multiply(b);
        
        return o;
    }
    
    public void divide (Complex<Double> other) {
        Complex64 temp = (Complex64)other;

        double a = 1.0 / (temp.im * temp.im + temp.re * temp.re);

        double tre = (this.re * temp.re + this.im * temp.im) * a;
        this.im = (this.im * temp.re + this.re * temp.im) * a;
        this.re = tre;
    }
    
    /**
     * Divide a by b : a / b
     * @param a Complex64
     * @param b Complex64
     * @return Complex64
     */
    public static Complex64 divide (Complex64 a, Complex64 b) {
        Complex64 o = a.deepCopy();
        o.divide(b);
        
        return o;
    }

    public Double abs () {
        return 0.0;
    }
    
    /**
     * Gets an absolute value of a
     * @param a Complex64
     * @return Double
     */
    public static Double abs (Complex64 a) {
        return a.abs();
    }
    
    public Double arg () {
        return 0.0;
    }
    
    /**
     * Gets an argument of a.
     * @param a Complex64
     * @return Double
     */
    public static Double arg (Complex64 a) {
        return a.arg();
    }
    
    public Complex64 deepCopy () {
        return new Complex64 (this.re, this.im);
    }
    
    public String toString () {
        return this.re + " + "  + this.im + "i : (Complex64)";
    }
}