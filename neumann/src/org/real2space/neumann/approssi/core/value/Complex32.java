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
    
    public final Float im () {
        return this.im;
    }
    
    public Complex32 conjugate () {
        return new Complex32 (this.re, - this.im);
    }
    
    public void add (Complex<Float> other) {
        this.re += other.re();
        this.im += other.im();
    }
    
    public void subtract (Complex<Float> other) {
        this.re -= other.re();
        this.im -= other.im();
    }
    
    public void multiply (Complex<Float> other) {
        float oim = other.im ();
        float ore = other.re ();
        float tim = this.im;
        float tre = this.re;
        
        this.re = tre * ore - tim * oim;
        this.im = tre * oim + tim * ore;
    }
    
    public void divide (Complex<Float> other) {
        Complex32 temp = (Complex32)other;

        float a = 1f / (temp.im * temp.im + temp.re * temp.re);

        float tre = (this.re * temp.re + this.im * temp.im) * a;
        this.im = (this.im * temp.re + this.re * temp.im) * a;
        this.re = tre;
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
    
    public String toString () {
        return this.re + " + "  + this.im + "i : (Complex32)";
    }
}