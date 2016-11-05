package org.real2space.neumann.approssi.core.value;

import java.math.BigInteger;
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
 
public class BigInt implements OrderedRing<BigInt>, Quotient<BigInt> {
    private BigInteger value;

    public BigInt (BigInteger value) {
        this.value = value;
    }
    
    public BigInt (String number) {
        this.value = new BigInteger (number);
    }

    public static BigInt ZERO () {
        return new BigInt(BigInteger.ZERO);
    }

    public static BigInt ONE () {
        return new BigInt(BigInteger.ONE);
    }

    public static BigInt NEGATIVE_ONE () {
        return new BigInt("-1");
    }
    
    public BigInteger getValue () {
        return this.value;
    }
    
    public void setValue (BigInteger value) {
        this.value = value;
    }
    
    public BigInt opposite () {
        return BigInt.multiply(this, BigInt.NEGATIVE_ONE());
    }

    // add
    public void add (BigInt other) {
        this.value = this.value.add(other.value);
    }
    
    public void add (BigInteger other) {
        this.value = this.value.add(other);
    }
    
    public void add (String other) {
        this.add (new BigInt (other));
    }
    
    public static BigInt add (BigInt a, BigInt b) {
        return new BigInt (a.value.add(b.value));
    }
    
    public static BigInt add (BigInteger a, BigInteger b) {
        return new BigInt (a.add(b));
    }
    
    public static BigInt add (String a, String b) {
        BigInt result = new BigInt (a);
        result.add (b);
        return result;
    }
    
    // subtract
    public void subtract (BigInt other) {
        this.value = this.value.subtract(other.value);
    }
    
    public void subtract (BigInteger other) {
        this.value = this.value.subtract(other);
    }
    
    public void subtract (String other) {
        this.subtract (new BigInt(other));
    }
    
    public static BigInt subtract (BigInt a, BigInt b) {
        return new BigInt (a.value.subtract(b.value));
    }
    
    public static BigInt subtract (BigInteger a, BigInteger b) {
        return new BigInt (a.subtract(b));
    }
    
    public static BigInt subtract (String a, String b) {
        BigInt result = new BigInt (a);
        result.subtract (b);
        return result;
    }
    
    //multiply
    public void multiply (BigInt other) {
        this.value = this.value.multiply(other.value);
    }
    
    public void multiply (BigInteger other) {
        this.value = this.value.multiply(other);
    }
    
    public void multiply (String other) {
        this.multiply (new BigInt (other));
    }
    
    public static BigInt multiply (BigInt a, BigInt b) {
        return new BigInt (a.value.multiply(b.value));
    }
    
    public static BigInt multiply (BigInteger a, BigInteger b) {
        return new BigInt (a.multiply(b));
    }
    
    public static BigInt multiply (String a, String b) {
        BigInt result = new BigInt (a);
        result.multiply (b);
        return result;
    }
    
    
    // divide
    public void divide (BigInt other) {
        this.value = this.value.divide(other.value);
    }
    
    public void divide (BigInteger other) {
        this.value = this.value.divide(other);
    }
 
    public void divide (String other) {
        this.divide(new BigInt (other));
    }
    
    public static BigInt divide (BigInt a, BigInt b) {
        return new BigInt (a.value.divide(b.value));
    }
    
    public static BigInt divide (BigInteger a, BigInteger b) {
        return new BigInt (a.divide(b));
    }
    
    public static BigInt divide (String a, String b) {
        BigInt result = new BigInt (a);
        result.divide (b);
        return result;
    }
    
    // mod
    public void mod (BigInt other) {
        this.value = this.value.remainder(other.value);
    }
    
    public void mod (BigInteger other) {
        this.value = this.value.remainder(other);
    }
    
    public void mod (String other) {
        this.mod (new BigInt (other));
    }
    
    public static BigInt mod (BigInt a, BigInt b) {
        return new BigInt (a.value.remainder(b.value));
    }
    
    public static BigInt mod (BigInteger a, BigInteger b) {
        return new BigInt (a.remainder(b));
    }
    
    public static BigInt mod (String a, String b) {
        BigInt result = new BigInt (a);
        result.mod (b);
        return result;
    }
    
    // pow : Exception
    public void pow (BigInt other) {
        /*
        this.value = this.value.pow(other.value);
        */
    }
    
    public void pow (BigInteger other) {
        /*
        this.value = this.value.pow(other);
        */
    }
    
    public void pow (String other) {
        /*
        this.pow (new BigInt (other));
        */
    }
    
    public static BigInt pow (BigInt a, BigInt b) {
        /*
        BigInt result = new BigInt (a.value);
        result.pow(b);
        
        return result;
        */
        return BigInt.ONE();
    }
    
    public static BigInt pow (BigInteger a, BigInteger b) {
        /*
        return BigInt.pow(new BigInt(a), new BigInt(b));
        */
        
        return BigInt.ONE();
    }
    
    public static BigInt pow (String a, String b) {
        /*
        return BigInt.pow(new BigInt (a), new BigInt(b));
        */
        
        return BigInt.ONE();
    }
    
    // is equal to
    public boolean isET (BigInt other) {
        return (this.value.compareTo(other.value) == 0);
    }
    
    public boolean isET (BigInteger other) {
        return (this.value.compareTo(other) == 0);
    }
    
    public boolean isET (String other) {
        return this.isET(new BigInteger (other));
    }
    
    public static boolean isET (BigInt a, BigInt b) {
        return (a.value.compareTo(b.value) == 0);
    }
    
    public static boolean isET (BigInteger a, BigInteger b) {
        return (a.compareTo(b) == 0);
    }
    
    public static boolean isET (String a, String b) {
        return BigInt.isET (new BigInt (a), new BigInt (b));
    }
    
    // is greater than
    public boolean isGT (BigInt other) {
        return (this.value.compareTo(other.value) > 0);
    }
    
    public boolean isGT (BigInteger other) {
        return (this.value.compareTo(other) > 0);
    }
    
    public boolean isGT (String other) {
        return this.isGT (new BigInt (other));
    }
    
    public static boolean isGT (BigInt a, BigInt b) {
        return (a.value.compareTo(b.value) > 0);
    }
    
    public static boolean isGT (BigInteger a, BigInteger b) {
        return (a.compareTo(b) > 0);
    }
    
    public static boolean isGT (String a, String b) {
        return BigInt.isGT (new BigInt(a), new BigInt(b));
    }
    
    // is greater than or equal to
    public boolean isGE (BigInt other) {
        return (this.value.compareTo(other.value) >= 0);
    }
    
    public boolean isGE (BigInteger other) {
        return (this.value.compareTo(other) >= 0);
    }
    
    public boolean isGE (String other) {
        return this.isGE (new BigInt (other));
    }
    
    public static boolean isGE (BigInt a, BigInt b) {
        return (a.value.compareTo(b.value) >= 0);
    }
    
    public static boolean isGE (BigInteger a, BigInteger b) {
        return (a.compareTo(b) >= 0);
    }
    
    public static boolean isGE (String a, String b) {
        return BigInt.isGE (new BigInt(a), new BigInt(b));
    }
    
    // is less than
    public boolean isLT (BigInt other) {
        return (this.value.compareTo(other.value) < 0);
    }
    
    public boolean isLT (BigInteger other) {
        return (this.value.compareTo(other) < 0);
    }
    
    public boolean isLT (String other) {
        return this.isLT (new BigInt (other));
    }
    
    public static boolean isLT (BigInt a, BigInt b) {
        return (a.value.compareTo(b.value) < 0);
    }
    
    public static boolean isLT (BigInteger a, BigInteger b) {
        return (a.compareTo(b) < 0);
    }
    
    public static boolean isLT (String a, String b) {
        return BigInt.isLT (new BigInt(a), new BigInt(b));
    }
    
    // is less than or equal to
    public boolean isLE (BigInt other) {
        return (this.value.compareTo(other.value) <= 0);
    }
    
    public boolean isLE (BigInteger other) {
        return (this.value.compareTo(other) <= 0);
    }
    
    public boolean isLE (String other) {
        return this.isLE (new BigInt (other));
    }
    
    public static boolean isLE (BigInt a, BigInt b) {
        return (a.value.compareTo(b.value) <= 0);
    }
    
    public static boolean isLE (BigInteger a, BigInteger b) {
        return (a.compareTo(b) <= 0);
    }
    
    public static boolean isLE (String a, String b) {
        return BigInt.isLE (new BigInt(a), new BigInt(b));
    }
    
    @Override
    public BigInt clone() {
        try {
            BigInt out = (BigInt)super.clone ();
            out.setValue (new BigInteger(this.value.toString()));
            return out;
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError (e.toString());
        }
    }
    
    public String toString () {
        return this.value.toString() + "(BigInt)";
    }
}