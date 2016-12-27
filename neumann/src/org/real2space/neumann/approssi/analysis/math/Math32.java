package org.real2space.neumann.approssi.analysis.math;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created 2016/12/27
 */ 
 
 
public class Math32 {
    public static final float ZERO = 0.0f;
    public static final float ONE = 1.0f;
    public static final float NEGATIVE_ONE = -1.0f;
    public static final float E = 2.7182818f;
    public static final float PI = 3.1415927f;
    
    public static float sin(float value) {
        return (float)Math64.sin(value);
    }
    
    public static float cos(float value) {
        return (float)Math64.cos(value);
    }
    
    public static float tan(float value) {
        return (float)Math64.tan(value);
    }
    
    public static float sinh(float value) {
        return (float)Math64.sinh(value);
    }
    
    public static float cosh(float value) {
        return (float)Math64.cosh(value);
    }
    
    public static float tanh(float value) {
        return (float)Math64.tanh(value);
    }
    
    public static float sec(float value) {
        return (float)Math64.sec(value);
    }
    
    public static float csc(float value) {
        return (float)Math64.csc(value);
    }
    
    public static float cot(float value) {
        return (float)Math64.cot(value);
    }
    
    public static float sech(float value) {
        return (float)Math64.sech(value);
    }
    
    public static float csch(float value) {
        return (float)Math64.csch(value);
    }
    
    public static float coth(float value) {
        return (float)Math64.coth(value);
    }
    
    public static float arcsin(float value) {
        return (float)Math64.arcsin(value);
    }
    
    public static float arccos(float value) {
        return (float)Math64.arccos(value);
    }
    
    public static float arctan(float value) {
        return (float)Math64.arctan(value);
    }
    
    public static float arcsec(float value) {
        return (float)Math64.arcsec(value);
    }
    
    public static float arccsc(float value) {
        return (float)Math64.arccsc(value);
    }
    
    public static float arccot(float value) {
        return (float)Math64.arccot(value);
    }
    
    public static float arcsinh(float value) {
        return (float)Math64.arcsinh(value);
    }
    
    public static float arccosh(float value) {
        return (float)Math64.arccosh(value);
    }
    
    public static float arctanh(float value) {
        return (float)Math64.arctanh(value);
    }
    
    public static float arcsech(float value){
        return (float)Math64.arcsech(value);
    }
    
    public static float arccsch(float value){
        return (float)Math64.csc(value);
    }
    
    public static float arccoth(float value){
        return (float)Math64.arccoth(value);
    }
    
    public static float sqrt(float value) {
        return (float)Math64.sqrt(value);
    }
    
    public static float sq(float value) {
        return value * value;
    }
    
    public static float pow(float a, float b) {
        return (float)Math64.pow(a, b);
    }
    
    public static float exp(float value) {
        return (float)Math64.exp(value);
    }
    
    public static float log(float a, float b) {
        return (float)Math64.log(a, b);
    }
    
    public static float ln(float value) {
        return (float)Math64.ln(value);
    }

    public static float log10(float value) {
        return (float)Math64.log10(value);
    }
    
    public static float abs(float value) {
        return (float)Math64.abs(value);
    }
    
    public static float max(float... values) {
        return (float)Math64.max(values);
    }
    
    public static float max(float a, float b) {
        return (float)Math64.max(a, b);
    }
    
    public static float min(float... values) {
        return (float)Math64.min(values);
    }
    
    public static float min(float a, float b) {
        return (float)Math64.min(a, b);
    }
    
    public static float ceil(float value) {
        return (float)Math64.ceil(value);
    }
    
    public static float floor(float value) {
        return (float)Math64.floor(value);
    }
    
    public static float toRadians(float value) {
        return (float)Math64.toRadians(value);
    }
    
    public static float toDegrees(float value) {
        return (float)Math64.toDegrees(value);
    }
}
