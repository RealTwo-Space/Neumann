package org.real2space.neumann.approssi.core.value;

import java.lang.ArithmeticException;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/11/01
 */

public class Int32 implements OrderedRing<Int32>, Quotient<Int32> {
    private int value;
    
    public static final Int32 ZERO = new Int32 (0);
    public static final Int32 ONE = new Int32 (1);
    public static final Int32 NEGATIVE_ONE = new Int32 (-1);
    
    public Int32 (int value) {
        this.value = value;
    }
    
    public int getValue () {
        return this.value;
    }
    
    public Int32 opposite () {
        return new Int32 (- this.value);
    }
    

    // add
    public void add (Int32 other) {
        this.value += other.value;
    }
    
    public void add (int other) {
        this.value += other;
    }
    
    public static Int32 add (Int32 a, Int32 b) {
        return new Int32 (a.value + b.value);
    }
    
    public static Int32 add (int a, int b) {
        return new Int32 (a + b);
    }
    
    // subtract
    public void subtract (Int32 other) {
        this.value -= other.value;
    }
    
    public void subtract (int other) {
        this.value -= other;
    }
    
    public static Int32 subtract (Int32 a, Int32 b) {
        return new Int32 (a.value - b.value);
    }
    
    public static Int32 subtract (int a, int b) {
        return new Int32 (a - b);
    }
    
    //multiply
    public void multiply (Int32 other) {
        this.value *= other.value;
    }
    
    public void multiply (int other) {
        this.value *= other;
    }
    
    public static Int32 multiply (Int32 a, Int32 b) {
        return new Int32 (a.value * b.value);
    }
    
    public static Int32 multiply (int a, int b) {
        return new Int32 (a * b);
    }
    
    
    // divide
    public void divide (Int32 other) {
        this.value /= other.value;
    }
    
    public void divide (int other) {
        this.value /= other;
    }
    
    public static Int32 divide (Int32 a, Int32 b) {
        return new Int32 (a.value / b.value);
    }
    
    public static Int32 divide (int a, int b) {
        return new Int32 (a / b);
    }
    
    // mod
    public void mod (Int32 other) {
        this.value %= other.value;
    }
    
    public void mod (int other) {
        this.value %= other.value;
    }
    
    public static Int32 mod (Int32 a, Int32 b) {
        return new Int32 (a.value % b.value);
    }
    
    public static Int32 mod (int a, int b) {
        return new Int32 (a % b);
    }
    
    // pow : Exception
    public void pow (Int32 other) {
        if (other.value < 0) {
            throws new ArithmeticException("Cannot pow by Negative number (" + other.value + ").");
        }
        
        int result = 1;
        for (int i = 0; i < other.value; i++) {
            result *= this.value;
        }
        this.value = result;
    }
    
    public void pow (int other) {
        if (other < 0) {
            throws new ArithmeticException("Cannot pow by Negative number (" + other + ").");
        }
        
        int result = 1;
        for (int i = 0; i < other; i++) {
            result *= this.value;
        }
        this.value = result;
    }
    
    public static Int32 pow (Int32 a, Int32 b) {
        Int32 result = new Int32 (a.value);
        result.pow(b);
        
        return result;
    }
    
    public static Int32 pow (int a, int b) {
        return (Int32.pow(new Int32(a), new Int32(b)));
    }
    
    // is equal to
    public boolean isET (Int32 other) {
        return (this.value == other.value);
    }
    
    public boolean isET (int other) {
        return (this.value == other);
    }
    
    public static Int32 isET (Int32 a, Int32 b) {
        return (a.value == b.value);
    }
    
    public static Int32 isET (int a, int b) {
        return (a == b);
    }
    
    // is greater than
    public boolean isGT (Int32 other) {
        return (this.value > other.value);
    }
    
    public boolean isGT (int other) {
        return (this.value > other);
    }
    
    public static boolean isGT (Int32 a, Int32 b) {
        return (a.value > b.value);
    }
    
    public static boolean isGT (int a, int b) {
        return (a > b);
    }
    
    // is greater than or equal to
    public boolean isGE (Int32 other) {
        return (this.value >= other.value);
    }
    
    public boolean isGE (int other) {
        return (this.value >= other);
    }
    
    public static boolean isGE (Int32 a, Int32 b) {
        return (a.value >= b.value);
    }
    
    public static boolean isGE (int a, int b) {
        return (a >= b);
    }
    
    // is less than
    public boolean isLT (Int32 other) {
        return (this.value < other.value);
    }
    
    public boolean isLT (int other) {
        return (this.value < other);
    }
    
    public static boolean isLT (Int32 a, Int32 b) {
        return (a.value < b.value);
    }
    
    public static boolean isLT (int a, int b) {
        return (a < b);
    }
    
    // is less than or eual to
    public boolean isLE (Int32 other) {
        return (this.value <= other.value);
    }
    public boolean isLE (int other) {
        return (this.value <= other);
    }
    
    public static boolean isLE (Int32 a, Int32 b) {
        return (a.value <= b.value);
    }
    
    public static boolean isLE (int a, int b) {
        return (a <= b);
    }
    
    @Override
    public Int32 clone() {
        try {
            return (Int32)super.clone();
        }
        catch (CloneNotSupportedException e) {
            return e;
        }
    }

    
    public String toString () {
        return this.value + "(Int32)";
    }
}
