package org.real2space.neumann.approssi.core.value;

import java.lang.ArithmeticException;
import java.lang.CloneNotSupportedException;
import java.lang.InternalError;
import org.real2space.neumann.approssi.core.structure.OrderedRing;
import org.real2space.neumann.approssi.core.structure.Quotient;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/11/01
 */
 
public class Int64 extends OrderedRing<Int64>, Quotient<Int64> {
    private long value;
    
    public static final Int64 ZERO = new Int64 (0);
    public static final Int64 ONE = new Int64 (1);
    public static final Int64 NEGATIVE_ONE = new Int64 (-1);
    
    public Int64 (long value) {
        this.value = value;
    }
    
    public long getValue () {
        return this.value;
    }
    
    public Int64 opposite () {
        return new Int64 (- this.value);
    }
    

    // add
    public void add (Int64 other) {
        this.value += other.value;
    }
    
    public void add (long other) {
        this.value += other;
    }
    
    public static Int64 add (Int64 a, Int64 b) {
        return new Int64 (a.value + b.value);
    }
    
    public static Int64 add (long a, long b) {
        return new Int64 (a + b);
    }
    
    // subtract
    public void subtract (Int64 other) {
        this.value -= other.value;
    }
    
    public void subtract (long other) {
        this.value -= other;
    }
    
    public static Int64 subtract (Int64 a, Int64 b) {
        return new Int64 (a.value - b.value);
    }
    
    public static Int64 subtract (long a, long b) {
        return new Int64 (a - b);
    }
    
    //multiply
    public void multiply (Int64 other) {
        this.value *= other.value;
    }
    
    public void multiply (long other) {
        this.value *= other;
    }
    
    public static Int64 multiply (Int64 a, Int64 b) {
        return new Int64 (a.value * b.value);
    }
    
    public static Int64 multiply (long a, long b) {
        return new Int64 (a * b);
    }
    
    
    // divide
    public void divide (Int64 other) {
        this.value /= other.value;
    }
    
    public void devide (long other) {
        this.value /= other;
    }
    
    public static Int64 devide (Int64 a, Int64 b) {
        return new Int64 (a.value / b.value);
    }
    
    public static Int64 devide (long a, long b) {
        return new Int64 (a / b);
    }
    
    // mod
    public void mod (Int64 other) {
        this.value %= other.value;
    }
    
    public void mod (long other) {
        this.value %= other;
    }
    
    public static Int64 mod (Int64 a, Int64 b) {
        return new Int64 (a.value % b.value);
    }
    
    public static Int64 mod (long a, long b) {
        return new Int64 (a % b);
    }
    
    // pow : Exception
    public void pow (Int64 other) {
        if (other.value < 0) {
            throw new ArithmeticException("Cannot pow by Negative number (" + other.value + ").");
        }
        
        long result = 1;
        for (long i = 0; i < other.value; i++) {
            result *= this.value;
        }
        this.value = result;
    }
    
    public void pow (long other) {
        if (other < 0) {
            throw new ArithmeticException("Cannot pow by Negative number (" + other + ").");
        }
        
        long result = 1;
        for (long i = 0; i < other; i++) {
            result *= this.value;
        }
        this.value = result;
    }
    
    public static Int64 pow (Int64 a, Int64 b) {
        Int64 result = new Int64 (a.value);
        result.pow(b);
        
        return result;
    }
    
    public static Int64 pow (long a, long b) {
        return (Int64.pow(new Int64(a), new Int64(b)));
    }
    
    // is equal to
    public boolean isET (Int64 other) {
        return (this.value == other.value);
    }
    
    public boolean isET (long other) {
        return (this.value == other);
    }
    
    public static boolean isET (Int64 a, Int64 b) {
        return (a.value == b.value);
    }
    
    public static boolean isET (long a, long b) {
        return (a == b);
    }
    
    // is greater than
    public boolean isGT (Int64 other) {
        return (this.value > other.value);
    }
    
    public boolean isGT (long other) {
        return (this.value > other);
    }
    
    public static boolean isGT (Int64 a, Int64 b) {
        return (a.value > b.value);
    }
    
    public static boolean isGT (long a, long b) {
        return (a > b);
    }
    
    // is greater than or equal to
    public boolean isGE (Int64 other) {
        return (this.value >= other.value);
    }
    
    public boolean isGE (long other) {
        return (this.value >= other);
    }
    
    public static boolean isGE (Int64 a, Int64 b) {
        return (a.value >= b.value);
    }
    
    public static boolean isGE (long a, long b) {
        return (a >= b);
    }
    
    // is less than
    public boolean isLT (Int64 other) {
        return (this.value < other.value);
    }
    
    public boolean isLT (long other) {
        return (this.value < other);
    }
    
    public static boolean isLT (Int64 a, Int64 b) {
        return (a.value < b.value);
    }
    
    public static boolean isLT (long a, long b) {
        return (a < b);
    }
    
    // is less than or eual to
    public boolean isLE (Int64 other) {
        return (this.value <= other.value);
    }
    public boolean isLE (long other) {
        return (this.value <= other);
    }
    
    public static boolean isLE (Int64 a, Int64 b) {
        return (a.value <= b.value);
    }
    
    public static boolean isLE (long a, long b) {
        return (a <= b);
    }
    
    @Override
    public Int64 clone() {
        try {
            return (Int64)super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError (e.toString());
        }
    }
    
    public String toString () {
        return this.value + "(Int64)";
    }
}