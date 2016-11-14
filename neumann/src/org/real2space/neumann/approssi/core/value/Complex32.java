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
    
    public Complex32 (float abs, float arg) {
        
    }
    
    public final Float re () {
        return this.re;
    }
    
    public final Float im () {
        return this.im;
    }
    
    public Complex32 conjugate () {
        return new Complex32 (this.re, - this.im);
    }
    
    public void add (Complex<Float> other) {
        this.re += other.re;
        this.im += other.im;
    }
    
    public void subtract (Complex<Float> other) {
        this.re -= this.other;
        this.im -= this.other;
    }
    
    public void multiply (Complex<Float> other) {
        this.re = this.re * other.re - this.im * other.im;
        this.im = this.re * other.im + this.im * other.re;
    }
    
    public void divide (Complex<Float> other) {
        this.re = (this.re * other.re + this.im * other.im) / (other.re * other.re + other.im * other.im);
        this.re = (this.im * other.re - this.re * other.im) / (other.re * other.re + other.im * other.im);
    }
    
    public Float abs () {
        return 0f;
    }
    
    public Float arg () {
        return 0f;
    }
    
    public Complex32 deepCopy () {
        return new Complex32 (this.re, this.im);
    }

}