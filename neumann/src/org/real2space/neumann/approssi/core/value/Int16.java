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
 
public class Int16 implements OrderedRing<Int16> {
    private short value;
    
    public static final Int16 ZERO = new Int16 (0);
    public static final Int16 ONE = new Int16 (1);
    public static final Int16 NEGATIVE_ONE = new Int16 (-1);
    
    public Int16 (short value) {
        this.value = value;
    }
    
    public Int16 (int value) {
        this.valule = (short)value;
    }
    
    public short getValue () {
        return this.value;
    }
    
    public Int16 opposite () {
        return new Int16 (- this.value);
    }
    

    // add
    public void add (Int16 other) {
        this.value += other.value;
    }
    
    public void add (short other) {
        this.value += other;
    }
    
    public static Int16 add (Int16 a, Int16 b) {
        return new Int16 (a.value + b.value);
    }
    
    public static Int16 add (short a, short b) {
        return new Int16 (a + b);
    }
    
    // subtract
    public void subtract (Int16 other) {
        this.value -= other.value;
    }
    
    public void subtract (short other) {
        this.value -= other;
    }
    
    public static Int16 subtract (Int16 a, Int16 b) {
        return new Int16 (a.value - b.value);
    }
    
    public static Int16 subtract (short a, short b) {
        return new Int16 (a - b);
    }
    
    //multiply
    public void multiply (Int16 other) {
        this.value *= other.value;
    }
    
    public void multiply (short other) {
        this.value *= other;
    }
    
    public static Int16 multiply (Int16 a, Int16 b) {
        return new Int16 (a.value * b.value);
    }
    
    public static Int16 multiply (short a, short b) {
        return new Int16 (a * b);
    }
    
    
    // divide
    public void divide (Int16 other) {
        this.value /= other.value;
    }
    
    public void divide (short other) {
        this.value /= other;
    }
    
    public static Int16 divide (Int16 a, Int16 b) {
        return new Int16 (a.value / b.value);
    }
    
    public static Int16 divide (short a, short b) {
        return new Int16 (a / b);
    }
    
    // mod
    public void mod (Int16 other) {
        this.value %= other.value;
    }
    
    public void mod (short other) {
        this.value %= other;
    }
    
    public static Int16 mod (Int16 a, Int16 b) {
        return new Int16 (a.value % b.value);
    }
    
    public static Int16 mod (short a, short b) {
        return new Int16 (a % b);
    }
    
    // pow : Exception
    public void pow (Int16 other) {
        if (other.value < 0) {
            throw new ArithmeticException("Cannot pow by Negative number (" + other.value + ").");
        }
        
        short result = 1;
        for (short i = 0; i < other.value; i++) {
            result *= this.value;
        }
        this.value = result;
    }
    
    public void pow (short other) {
        if (other < 0) {
            throw new ArithmeticException("Cannot pow by Negative number (" + other + ").");
        }
        
        short result = 1;
        for (short i = 0; i < other; i++) {
            result *= this.value;
        }
        this.value = result;
    }
    
    public static Int16 pow (Int16 a, Int16 b) {
        Int16 result = new Int16 (a.value);
        result.pow(b);
        
        return result;
    }
    
    public static Int16 pow (short a, short b) {
        return (Int16.pow(new Int16(a), new Int16(b)));
    }
    
    // is equal to
    public boolean isET (Int16 other) {
        return (this.value == other.value);
    }
    
    public boolean isET (short other) {
        return (this.value == other);
    }
    
    public static boolean isET (Int16 a, Int16 b) {
        return (a.value == b.value);
    }
    
    public static boolean isET (short a, short b) {
        return (a == b);
    }
    
    // is greater than
    public boolean isGT (Int16 other) {
        return (this.value > other.value);
    }
    
    public boolean isGT (short other) {
        return (this.value > other);
    }
    
    public static boolean isGT (Int16 a, Int16 b) {
        return (a.value > b.value);
    }
    
    public static boolean isGT (short a, short b) {
        return (a > b);
    }
    
    // is greater than or equal to
    public boolean isGE (Int16 other) {
        return (this.value >= other.value);
    }
    
    public boolean isGE (short other) {
        return (this.value >= other);
    }
    
    public static boolean isGE (Int16 a, Int16 b) {
        return (a.value >= b.value);
    }
    
    public static boolean isGE (short a, short b) {
        return (a >= b);
    }
    
    // is less than
    public boolean isLT (Int16 other) {
        return (this.value < other.value);
    }
    
    public boolean isLT (short other) {
        return (this.value < other);
    }
    
    public static boolean isLT (Int16 a, Int16 b) {
        return (a.value < b.value);
    }
    
    public static boolean isLT (short a, short b) {
        return (a < b);
    }
    
    // is less than or eual to
    public boolean isLE (Int16 other) {
        return (this.value <= other.value);
    }
    public boolean isLE (short other) {
        return (this.value <= other);
    }
    
    public static boolean isLE (Int16 a, Int16 b) {
        return (a.value <= b.value);
    }
    
    public static boolean isLE (short a, short b) {
        return (a <= b);
    }
    
    @Override
    public Int16 clone() {
        try {
            return (Int16)super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError (e.toString());
        }
    }
    
    public String toString () {
        return this.value + "(Int16)";
    }
}