package org.real2space.neumann.approssi.analysis.math;

import java.lang.Math;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * created 2016/12/27
 */ 
 
 
public class Math64 {
    public static final double ZERO = 0.0;
    public static final double ONE = 1.0;
    public static final double NEGATIVE_ONE = -1.0;
    public static final double E = 2.718281828459045;
    public static final double PI = 3.141592653589793;
    
    public static double sin(double value) {
        return Math.sin(value);
    }
    
    public static double cos(double value) {
        return Math.cos(value);
    }
    
    public static double tan(double value) {
        return Math.tan(value);
    }
    
    public static double sinh(double value) {
        return Math.sinh(value);
    }
    
    public static double cosh(double value) {
        return Math.cosh(value);
    }
    
    public static double tanh(double value) {
        return Math.tanh(value);
    }
    
    public static double sec(double value) {
        return 1.0 / cos(value);
    }
    
    public static double csc(double value) {
        return 1.0 / sin(value);
    }
    
    public static double cot(double value) {
        return 1.0 / tan(value);
    }
    
    public static double sech(double value) {
        return 1.0 / cosh(value);
    }
    
    public static double csch(double value) {
        return 1.0 / sinh(value);
    }
    
    public static double coth(double value) {
        return 1.0 / tanh(value);
    }
    
    public static double arcsin(double value) {
        return Math.asin(value);
    }
    
    public static double arccos(double value) {
        return Math.acos(value);
    }
    
    public static double arctan(double value) {
        return Math.atan(value);
    }
    
    public static double arcsec(double value) {
        return arccos(1 / value);
    }
    
    public static double arccsc(double value) {
        return arcsin(1 / value);
    }
    
    public static double arccot(double value) {
        return arctan(1 / value);
    }
    
    public static double arcsinh(double value) {
        return ln(value + sqrt(sq(value) + 1.0));
    }
    
    public static double arccosh(double value) {
        return ln(value + sqrt(sq(value) - 1.0);
    }
    
    public static double arctanh(double value) {
        return ln((1.0 + value) / (1.0 - value)) / 2.0;
    }
    
    public static double arcsech(double value){
        return arccosh(1.0 / value);
    }
    
    public static double arccsch(double value){
        return arcsinh(1.0 / value);
    }
    
    public static double arccoth(double value){
        return arctanh(1.0 / value);
    }
    
    public static double sqrt(double value) {
        return Math.sqrt(value);
    }
    
    public static double sq(double value) {
        return value * value;
    }
    
    public static double pow(double a, double b) {
        return Math.pow(a, b);
    }
    
    public static double exp(double value) {
        return Math.exp(value);
    }
    
    public static double log(double a, double b) {
        return log10(b) / log10(a);
    }
    
    public static double ln(double value) {
        return Math.log(value);
    }

    public static double log10(double value) {
        return Math.log10(value);
    }
    
    public static double abs(double value) {
        return Math.abs(value);
    }
    
    public static double max(double values..) {
        double max = values[0];
        for (int i = 1, n = values.length; i < n; i++) {
            max = max(max, values[i]);
        }
        return max;
    }
    
    public static double max(double a, double b) {
        return Math.max(a, b);
    }
    
    public static double min(double values..) {
        double min = values[0];
        for (int i = 1, n = values.length; i < n; i++) {
            min = min(min, values[i]);
        }
        return min;
    }
    
    public static double min(double a, double b) {
        return Math.min(a, b);
    }
    
    public static double ceil(double value) {
        return Math.ceil(value);
    }
    
    public static double floor(double value) {
        return Math.floor(value);
    }
    
    public static double toRadians(double value) {
        return Math.toRadians(value);
    }
    
    public static double toDegrees(double value) {
        return Math.toDegrees(value);
    }
}