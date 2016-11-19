package org.real2space.neumann.evaris.core.value;

import java.lang.CloneNotSupportedException;
import java.lang.InternalError;
import java.lang.Math;
import org.real2space.neumann.evaris.core.structure.OrderedField;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/11/01
 */
 
public class Float64 implements OrderedField<Float64> {
    private double value;
    
    public Float64 (double value) {
        this.value = value;
    }

    public static Float64 ZERO () {
        return new Float64(0.0);
    }

    public static Float64 ONE () {
        return new Float64(1.0);
    }

    public static Float64 NEGATIVE_ONE () {
        return new Float64(-1.0);
    }

    public static Float64 POSITIVE_INFINITY () {
        return new Float64(Double.POSITIVE_INFINITY);
    }

    public static Float64 NEGATIVE_INFINITY () {
        return new Float64(Double.NEGATIVE_INFINITY);
    }

    public static Float64 NaN () {
        return new Float64(Double.NaN);
    }
    
    public double getValue () {
        return this.value;
    }
    
    public Float64 opposite () {
        return new Float64 (- this.value);
    }
    
    public Float64 inverse () {
        return new Float64 (1.0 / this.value);
    }
    
    // add
    public void add (Float64 other) {
        this.value += other.value;
    }
    
    public void add (double other) {
        this.value += other;
    }
    
    public static Float64 add (Float64 a, Float64 b) {
        return new Float64 (a.value + b.value);
    }
    
    public static Float64 add (double a, double b) {
        return new Float64 (a + b);
    }
    
    // subtract
    public void subtract (Float64 other) {
        this.value -= other.value;
    }
    
    public void subtract (double other) {
        this.value -= other;
    }
    
    public static Float64 subtract (Float64 a, Float64 b) {
        return new Float64 (a.value - b.value);
    }
    
    public static Float64 subtract (double a, double b) {
        return new Float64 (a - b);
    }
    
    //multiply
    public void multiply (Float64 other) {
        this.value *= other.value;
    }
    
    public void multiply (double other) {
        this.value *= other;
    }
    
    public static Float64 multiply (Float64 a, Float64 b) {
        return new Float64 (a.value * b.value);
    }
    
    public static Float64 multiply (double a, double b) {
        return new Float64 (a * b);
    }
    
    
    // divide
    public void divide (Float64 other) {
        this.value /= other.value;
    }
    
    public void divide (double other) {
        this.value /= other;
    }
    
    public static Float64 divide (Float64 a, Float64 b) {
        return new Float64 (a.value / b.value);
    }
    
    public static Float64 divide (double a, double b) {
        return new Float64 (a / b);
    }
    
    // mod
    public void mod (Float64 other) {
        this.value %= other.value;
    }
    
    public void mod (double other) {
        this.value %= other;
    }
    
    public static Float64 mod (Float64 a, Float64 b) {
        return new Float64 (a.value % b.value);
    }
    
    public static Float64 mod (double a, double b) {
        return new Float64 (a % b);
    }
    
    // pow : Exception
    public void pow (Float64 other) {
        this.value = (double)Math.pow((double)this.value, (double)other.value);
    }
    
    public void pow (double other) {
        this.value = (double)Math.pow((double)this.value, (double)other);
    }
    
    public static Float64 pow (Float64 a, Float64 b) {
        Float64 result = new Float64 (a.value);
        result.pow(b);
        
        return result;
    }
    
    public static Float64 pow (double a, double b) {
        return (Float64.pow(new Float64(a), new Float64(b)));
    }
    
    // is equal to
    public boolean isET (Float64 other) {
        return (this.value == other.value);
    }
    
    public boolean isET (double other) {
        return (this.value == other);
    }
    
    public static boolean isET (Float64 a, Float64 b) {
        return (a.value == b.value);
    }
    
    public static boolean isET (double a, double b) {
        return (a == b);
    }
    
    // is greater than
    public boolean isGT (Float64 other) {
        return (this.value > other.value);
    }
    
    public boolean isGT (double other) {
        return (this.value > other);
    }
    
    public static boolean isGT (Float64 a, Float64 b) {
        return (a.value > b.value);
    }
    
    public static boolean isGT (double a, double b) {
        return (a > b);
    }
    
    // is greater than or equal to
    public boolean isGE (Float64 other) {
        return (this.value >= other.value);
    }
    
    public boolean isGE (double other) {
        return (this.value >= other);
    }
    
    public static boolean isGE (Float64 a, Float64 b) {
        return (a.value >= b.value);
    }
    
    public static boolean isGE (double a, double b) {
        return (a >= b);
    }
    
    // is less than
    public boolean isLT (Float64 other) {
        return (this.value < other.value);
    }
    
    public boolean isLT (double other) {
        return (this.value < other);
    }
    
    public static boolean isLT (Float64 a, Float64 b) {
        return (a.value < b.value);
    }
    
    public static boolean isLT (double a, double b) {
        return (a < b);
    }
    
    // is less than or eual to
    public boolean isLE (Float64 other) {
        return (this.value <= other.value);
    }
    public boolean isLE (double other) {
        return (this.value <= other);
    }
    
    public static boolean isLE (Float64 a, Float64 b) {
        return (a.value <= b.value);
    }
    
    public static boolean isLE (double a, double b) {
        return (a <= b);
    }
    
    @Override
    public Float64 clone() {
        try {
            return (Float64)super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError (e.toString());
        }
    }

    
    public String toString () {
        return this.value + "(Float64)";
    }
}