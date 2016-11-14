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
 
public class Float32 implements OrderedField<Float32> {
    private float value;
    
    public Float32 (float value) {
        this.value = value;
    }

    public static Float32 ZERO () {
        return new Float32(0f);
    }

    public static Float32 ONE () {
        return new Float32(1f);
    }

    public static Float32 NEGATIVE_ONE () {
        return new Float32(-1f);
    }

    public static Float32 POSITIVE_INFINITY () {
        return new Float32 (Float.POSITIVE_INFINITY);
    }

    public static Float32 NEGATIVE_INFINITY () {
        return new Float32 (Float.NEGATIVE_INFINITY);
    }

    public static Float32 NaN() {
        return new Float32 (Float.NaN);
    }
    
    public float getValue () {
        return this.value;
    }
    
    public Float32 opposite () {
        return new Float32 (- this.value);
    }
    
    public Float32 inverse () {
        return new Float32 (1f / this.value);
    }
    
    // add
    public void add (Float32 other) {
        this.value += other.value;
    }
    
    public void add (float other) {
        this.value += other;
    }
    
    public static Float32 add (Float32 a, Float32 b) {
        return new Float32 (a.value + b.value);
    }
    
    public static Float32 add (float a, float b) {
        return new Float32 (a + b);
    }
    
    // subtract
    public void subtract (Float32 other) {
        this.value -= other.value;
    }
    
    public void subtract (float other) {
        this.value -= other;
    }
    
    public static Float32 subtract (Float32 a, Float32 b) {
        return new Float32 (a.value - b.value);
    }
    
    public static Float32 subtract (float a, float b) {
        return new Float32 (a - b);
    }
    
    //multiply
    public void multiply (Float32 other) {
        this.value *= other.value;
    }
    
    public void multiply (float other) {
        this.value *= other;
    }
    
    public static Float32 multiply (Float32 a, Float32 b) {
        return new Float32 (a.value * b.value);
    }
    
    public static Float32 multiply (float a, float b) {
        return new Float32 (a * b);
    }
    
    
    // divide
    public void divide (Float32 other) {
        this.value /= other.value;
    }
    
    public void divide (float other) {
        this.value /= other;
    }
    
    public static Float32 divide (Float32 a, Float32 b) {
        return new Float32 (a.value / b.value);
    }
    
    public static Float32 divide (float a, float b) {
        return new Float32 (a / b);
    }
    
    // mod
    public void mod (Float32 other) {
        this.value %= other.value;
    }
    
    public void mod (float other) {
        this.value %= other;
    }
    
    public static Float32 mod (Float32 a, Float32 b) {
        return new Float32 (a.value % b.value);
    }
    
    public static Float32 mod (float a, float b) {
        return new Float32 (a % b);
    }
    
    // pow : Exception
    public void pow (Float32 other) {
        this.value = (float)Math.pow((double)this.value, (double)other.value);
    }
    
    public void pow (float other) {
        this.value = (float)Math.pow((double)this.value, (double)other);
    }
    
    public static Float32 pow (Float32 a, Float32 b) {
        Float32 result = new Float32 (a.value);
        result.pow(b);
        
        return result;
    }
    
    public static Float32 pow (float a, float b) {
        return (Float32.pow(new Float32(a), new Float32(b)));
    }
    
    // is equal to
    public boolean isET (Float32 other) {
        return (this.value == other.value);
    }
    
    public boolean isET (float other) {
        return (this.value == other);
    }
    
    public static boolean isET (Float32 a, Float32 b) {
        return (a.value == b.value);
    }
    
    public static boolean isET (float a, float b) {
        return (a == b);
    }
    
    // is greater than
    public boolean isGT (Float32 other) {
        return (this.value > other.value);
    }
    
    public boolean isGT (float other) {
        return (this.value > other);
    }
    
    public static boolean isGT (Float32 a, Float32 b) {
        return (a.value > b.value);
    }
    
    public static boolean isGT (float a, float b) {
        return (a > b);
    }
    
    // is greater than or equal to
    public boolean isGE (Float32 other) {
        return (this.value >= other.value);
    }
    
    public boolean isGE (float other) {
        return (this.value >= other);
    }
    
    public static boolean isGE (Float32 a, Float32 b) {
        return (a.value >= b.value);
    }
    
    public static boolean isGE (float a, float b) {
        return (a >= b);
    }
    
    // is less than
    public boolean isLT (Float32 other) {
        return (this.value < other.value);
    }
    
    public boolean isLT (float other) {
        return (this.value < other);
    }
    
    public static boolean isLT (Float32 a, Float32 b) {
        return (a.value < b.value);
    }
    
    public static boolean isLT (float a, float b) {
        return (a < b);
    }
    
    // is less than or eual to
    public boolean isLE (Float32 other) {
        return (this.value <= other.value);
    }
    public boolean isLE (float other) {
        return (this.value <= other);
    }
    
    public static boolean isLE (Float32 a, Float32 b) {
        return (a.value <= b.value);
    }
    
    public static boolean isLE (float a, float b) {
        return (a <= b);
    }
    
    @Override
    public Float32 clone() {
        try {
            return (Float32)super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError (e.toString());
        }
    }

    
    public String toString () {
        return this.value + "(Float32)";
    }
}