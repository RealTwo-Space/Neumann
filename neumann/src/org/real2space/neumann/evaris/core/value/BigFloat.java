package org.real2space.neumann.evaris.core.value;

import java.lang.CloneNotSupportedException;
import java.lang.InternalError;
import java.math.BigDecimal;
import org.real2space.neumann.evaris.core.structure.OrderedField;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created     2016/11/01
 */
 
public class BigFloat implements OrderedField<BigFloat> {
    private BigDecimal value;
    
    public BigFloat (BigDecimal value) {
        this.value = value;
    }
    
    public BigFloat (String number) {
        this.value = new BigDecimal (number);
    }

    public static BigFloat ZERO () {
        return new BigFloat(BigDecimal.ZERO);
    }

    public static BigFloat ONE () {
        return new BigFloat(BigDecimal.ONE);
    }

    public static BigFloat NEGATIVE_ONE () {
        return new BigFloat("-1.0");
    }
    
    public BigDecimal getValue () {
        return this.value;
    }
    
    public void setValue (BigDecimal value) {
        this.value = value;
    }
    
    public BigFloat opposite () {
        BigFloat result = this.clone();
        result.multiply("-1.0");
        return result;
    }
    
    public BigFloat inverse () {
        return BigFloat.divide(BigFloat.ONE(), this);

    }
    

    // add
    public void add (BigFloat other) {
        this.value = this.value.add(other.value);
    }
    
    public void add (BigDecimal other) {
        this.value = this.value.add(other);
    }
    
    public void add (String other) {
        this.add (new BigFloat (other));
    }
    
    public static BigFloat add (BigFloat a, BigFloat b) {
        return new BigFloat (a.value.add(b.value));
    }
    
    public static BigFloat add (BigDecimal a, BigDecimal b) {
        return new BigFloat (a.add(b));
    }
    
    public static BigFloat add (String a, String b) {
        BigFloat result = new BigFloat (a);
        result.add (b);
        return result;
    }
    
    // subtract
    public void subtract (BigFloat other) {
        this.value = this.value.subtract(other.value);
    }
    
    public void subtract (BigDecimal other) {
        this.value = this.value.subtract(other);
    }
    
    public void subtract (String other) {
        this.subtract (new BigFloat(other));
    }
    
    public static BigFloat subtract (BigFloat a, BigFloat b) {
        return new BigFloat (a.value.subtract(b.value));
    }
    
    public static BigFloat subtract (BigDecimal a, BigDecimal b) {
        return new BigFloat (a.subtract(b));
    }
    
    public static BigFloat subtract (String a, String b) {
        BigFloat result = new BigFloat (a);
        result.subtract (b);
        return result;
    }
    
    //multiply
    public void multiply (BigFloat other) {
        this.value = this.value.multiply(other.value);
    }
    
    public void multiply (BigDecimal other) {
        this.value = this.value.multiply(other);
    }
    
    public void multiply (String other) {
        this.multiply (new BigFloat (other));
    }
    
    public static BigFloat multiply (BigFloat a, BigFloat b) {
        return new BigFloat (a.value.multiply(b.value));
    }
    
    public static BigFloat multiply (BigDecimal a, BigDecimal b) {
        return new BigFloat (a.multiply(b));
    }
    
    public static BigFloat multiply (String a, String b) {
        BigFloat result = new BigFloat (a);
        result.multiply (b);
        return result;
    }
    
    
    // divide
    public void divide (BigFloat other) {
        this.value = this.value.divide(other.value);
    }
    
    public void divide (BigDecimal other) {
        this.value = this.value.divide(other);
    }
 
    public void divide (String other) {
        this.divide(new BigFloat (other));
    }
    
    public static BigFloat divide (BigFloat a, BigFloat b) {
        return new BigFloat (a.value.divide(b.value));
    }
    
    public static BigFloat divide (BigDecimal a, BigDecimal b) {
        return new BigFloat (a.divide(b));
    }
    
    public static BigFloat divide (String a, String b) {
        BigFloat result = new BigFloat (a);
        result.divide (b);
        return result;
    }
    
    // mod
    public void mod (BigFloat other) {
        this.value = this.value.remainder(other.value);
    }
    
    public void mod (BigDecimal other) {
        this.value = this.value.remainder(other);
    }
    
    public void mod (String other) {
        this.mod (new BigFloat (other));
    }
    
    public static BigFloat mod (BigFloat a, BigFloat b) {
        return new BigFloat (a.value.remainder(b.value));
    }
    
    public static BigFloat mod (BigDecimal a, BigDecimal b) {
        return new BigFloat (a.remainder(b));
    }
    
    public static BigFloat mod (String a, String b) {
        BigFloat result = new BigFloat (a);
        result.mod (b);
        return result;
    }
    
    // pow : Exception
    public void pow (BigFloat other) {
        /*
        this.value = this.value.pow(other.value);
        */
    }
    
    public void pow (BigDecimal other) {
        /*
        this.value = this.value.pow(other);
        */
    }
    
    public void pow (String other) {
        /*
        this.pow (new BigFloat (other));
        */
    }
    
    public static BigFloat pow (BigFloat a, BigFloat b) {
        /*
        BigFloat result = new BigFloat (a.value);
        result.pow(b);
        
        return result;
        */
        return BigFloat.ONE();
    }
    
    public static BigFloat pow (BigDecimal a, BigDecimal b) {
        /*
        return BigFloat.pow(new BigFloat(a), new BigFloat(b));
        */
        
        return BigFloat.ONE();
    }
    
    public static BigFloat pow (String a, String b) {
        /*
        return BigFloat.pow(new BigFloat (a), new BigFloat(b));
        */
        return BigFloat.ONE();
    }
    
    // is equal to
    public boolean isET (BigFloat other) {
        return (this.value.compareTo(other.value) == 0);
    }
    
    public boolean isET (BigDecimal other) {
        return (this.value.compareTo(other) == 0);
    }
    
    public boolean isET (String other) {
        return this.isET(new BigDecimal (other));
    }
    
    public static boolean isET (BigFloat a, BigFloat b) {
        return (a.value.compareTo(b.value) == 0);
    }
    
    public static boolean isET (BigDecimal a, BigDecimal b) {
        return (a.compareTo(b) == 0);
    }
    
    public static boolean isET (String a, String b) {
        return BigFloat.isET (new BigFloat (a), new BigFloat (b));
    }
    
    // is greater than
    public boolean isGT (BigFloat other) {
        return (this.value.compareTo(other.value) > 0);
    }
    
    public boolean isGT (BigDecimal other) {
        return (this.value.compareTo(other) > 0);
    }
    
    public boolean isGT (String other) {
        return this.isGT (new BigFloat (other));
    }
    
    public static boolean isGT (BigFloat a, BigFloat b) {
        return (a.value.compareTo(b.value) > 0);
    }
    
    public static boolean isGT (BigDecimal a, BigDecimal b) {
        return (a.compareTo(b) > 0);
    }
    
    public static boolean isGT (String a, String b) {
        return BigFloat.isGT (new BigFloat(a), new BigFloat(b));
    }
    
    // is greater than or equal to
    public boolean isGE (BigFloat other) {
        return (this.value.compareTo(other.value) >= 0);
    }
    
    public boolean isGE (BigDecimal other) {
        return (this.value.compareTo(other) >= 0);
    }
    
    public boolean isGE (String other) {
        return this.isGE (new BigFloat (other));
    }
    
    public static boolean isGE (BigFloat a, BigFloat b) {
        return (a.value.compareTo(b.value) >= 0);
    }
    
    public static boolean isGE (BigDecimal a, BigDecimal b) {
        return (a.compareTo(b) >= 0);
    }
    
    public static boolean isGE (String a, String b) {
        return BigFloat.isGE (new BigFloat(a), new BigFloat(b));
    }
    
    // is less than
    public boolean isLT (BigFloat other) {
        return (this.value.compareTo(other.value) < 0);
    }
    
    public boolean isLT (BigDecimal other) {
        return (this.value.compareTo(other) < 0);
    }
    
    public boolean isLT (String other) {
        return this.isLT (new BigFloat (other));
    }
    
    public static boolean isLT (BigFloat a, BigFloat b) {
        return (a.value.compareTo(b.value) < 0);
    }
    
    public static boolean isLT (BigDecimal a, BigDecimal b) {
        return (a.compareTo(b) < 0);
    }
    
    public static boolean isLT (String a, String b) {
        return BigFloat.isLT (new BigFloat(a), new BigFloat(b));
    }
    
    // is less than or equal to
    public boolean isLE (BigFloat other) {
        return (this.value.compareTo(other.value) <= 0);
    }
    
    public boolean isLE (BigDecimal other) {
        return (this.value.compareTo(other) <= 0);
    }
    
    public boolean isLE (String other) {
        return this.isLE (new BigFloat (other));
    }
    
    public static boolean isLE (BigFloat a, BigFloat b) {
        return (a.value.compareTo(b.value) <= 0);
    }
    
    public static boolean isLE (BigDecimal a, BigDecimal b) {
        return (a.compareTo(b) <= 0);
    }
    
    public static boolean isLE (String a, String b) {
        return BigFloat.isLE (new BigFloat(a), new BigFloat(b));
    }
    
    @Override
    public BigFloat clone() {
        try {
            BigFloat out = (BigFloat)super.clone ();
            out.setValue (new BigDecimal(this.value.toString()));
            return out;
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError (e.toString());
        }
    }
    
    public String toString () {
        return this.value.toString() + "(BigFloat)";
    }
}