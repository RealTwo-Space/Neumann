package org.real2space.neumann.approssi.analysis.math;

import org.real2space.neumann.approssi.core.value.DualNumber64;

/**
 * Project Neumann
 * 
 * @author RealTwo-Space
 * @version 0
 * created 2016/12/27
 */ 
 
 
public class MathDual64 {
    
    // sin(a + be) = sin(a) + b * cos(a)e
    public static DualNumber64 sin(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        return new DualNumber64(Math64.sin(a), b * Math64.cos(a));
    }
    
    // sin(a+be) = cos(a) - b * sin(a)e
    public static DualNumber64 cos(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        return new DualNumber64(Math64.cos(a), - b * Math64.sin(a));
    }
    
    // b / cos^2(a)
    public static DualNumber64 tan(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invcos2 = Math64.sq(1.0 / Math64.cos(a)); 
        return new DualNumber64(Math64.tan(a), b * invcos2);
    }
    
    // cosh(a) * b
    public static DualNumber64 sinh(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        return new DualNumber64(Math64.sinh(a), b * Math64.cosh(a));
    }
    
    // sinh(a) * b
    public static DualNumber64 cosh(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        return new DualNumber64(Math64.cosh(a), b * Math64.sinh(a));
    }
    
    // tanh(a) = (cosh*cosh - sinh*sinh) / cosh^2 = 1 / cosh(a)^2 * b
    public static DualNumber64 tanh(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invcosh2 = Math64.sq(1.0 / Math64.cosh(a)); 
        return new DualNumber64(Math64.tanh(a), b * invcosh2);
    }
    
    // 1 / cos =  sin/cos^2 = tan * (1 / cos) = tan * sec * b
    public static DualNumber64 sec(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double tan = Math64.tan(a);
        double sec = Math64.sec(a);
        return new DualNumber64(sec, b * tan * sec);
    }
    
    // (1 / sin)' = - cos / sin^2 = - b * cot * csc
    public static DualNumber64 csc(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double cot = Math64.cot(a);
        double csc = Math64.csc(a);
        return new DualNumber64(csc, - b * cot * csc);
    }
    
    // (1 / tan)' = 1/ cos^2 * (- (1 / tan^2)) = - 1 / (cos^2 * sin / cos^2) = - 1 / sin^2 
    public static DualNumber64 cot(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invsin2 = Math64.sq(1.0 / Math64.sin(a));
        return new DualNumber64(Math64.cot(a), - b * invsin2);
    }
    
    // (1 / cosh)' = -sinh / cosh^2 = -tanh * sech
    public static DualNumber64 sech(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double tanh = Math64.tanh(a);
        double sech = Math64.sech(a);
        return new DualNumber64(sech, - b * tanh * sech);
    }
    
    // (1/sinh)' = - cosh / sinh^2 = - coth * csch
    public static DualNumber64 csch(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double coth = Math64.coth(a);
        double csch = Math64.csch(a);
        return new DualNumber64(csch, - b * coth * csch);
    }
    
    // (1/tanh)' = -(1/cosh^2)*(1/tanh^2) = -1/sinh^2
    public static DualNumber64 coth(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invsinh2 = Math64.sq(1.0 / Math64.sinh(a));
        return new DualNumber64(Math64.coth(a), - b * invsinh2);
    }
    
    // y = arcsinx
    // 1 / siny = 1 / sqrt(1 - x^2)
    public static DualNumber64 arcsin(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invsqrt = b / Math64.sqrt(1.0 - a * a);
        return new DualNumber64(Math64.arcsin(a), invsqrt);
    }
    
    // - 1 / (sqrt(1 - x^2))
    public static DualNumber64 arccos(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invsqrt = b / Math64.sqrt(1.0 - a * a);
        return new DualNumber64(Math64.arccos(a), - invsqrt);
    }
    
    // 1 / 1+a^2
    public static DualNumber64 arctan(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double inv = b / (1.0 + a * a);
        return new DualNumber64(Math64.arctan(a), inv);
    }
    
    public static DualNumber64 arcsec(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invz2 = Math64.sq(1.0 / a);
        double invsqrt = b / Math64(1.0 - invz2);
        return new DualNumber64(Math64.arcsec(a), invz2 * invsqrt);
    }
    
    public static DualNumber64 arccsc(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invz2 = Math64.sq(1.0 / a);
        double invsqrt = b / Math64(1.0 - invz2);
        return new DualNumber64(Math64.arcsc(a), - invz2 * invsqrt);
    }
    
    public static DualNumber64 arccot(DualNumber64 value) {
        rdouble a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double inv = b / (1.0 + a * a);
        return new DualNumber64(Math64.arccot(a), - inv);
    }
    
    public static DualNumber64 arcsinh(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invsqrt = b / Math64.sqrt(1.0 + a * a);
        return new DualNumber64(Math64.arcsinh(a), invsqrt);
    }
    
    public static DualNumber64 arccosh(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invsqrt = b / Math64.sqrt(a * a - 1.0);
        return new DualNumber64(Math64.arccosh(a), invsqrt);
    }
    
    public static DualNumber64 arctanh(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double inv = b / (1.0 - a * a);
        return new DualNumber64(Math64.arctanh(a), inv);
    }
    
    public static DualNumber64 arcsech(DualNumber64 value){
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double invxp1 = 1.0 / (1.0 + a);
        double invsqrt = b / Math64.sqrt((1.0 - a) * invxp1);
        return new DualNumber64(Math64.arcsech(a), - invxp1 * invsqrt / a);
    }
    
    public static DualNumber64 arccsch(DualNumber64 value){
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double inv2 = b / Math64.sq(a);
        double invsqrt = Math64.sqrt(1 + inv2);
        return new DualNumber64(Math64.arccsch(a), - inv2 * invsqrt);
    }
    
    public static DualNumber64 arccoth(DualNumber64 value){
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double inv = b / (1.0 - a * a);
        return new DualNumber64(Math64.arccoth(a), inv);
    }
    
    public static DualNumber64 sqrt(DualNumber64 value) {
        return pow(value, 0.5);
    }
    
    // x^2 = 2x
    public static DualNumber64 sq(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        return new DualNumber64(Math64.sq(a), 2 * a * b);
    }
    
    // x^y = y * x^(y-1)
    public static DualNumber64 pow(DualNumber64 x, double y) {
        double a = DualNumber64.a(x);
        double b = DualNumber64.b(x);
        return new DualNumber64(Math64.pow(a, y), b * y * Math64.pow(a, y - 1.0));
    }
    
    // y = x^x, log y = x logx, y' / y = logx + 1, y' = (logx + 1) * x * x
    public static DualNumber64 pow(DualNumber64 x, DualNumber64 y) {
        double a = DualNumber64.a(x);
        double b = DualNumber64.b(x);
        double y = a * a;
        return new DualNumber64(Math64.pow(a, a), b * y * Math64.ln(a));
    }
    
    // x^y = x^y log x
    public static DualNumber64 pow(double x, DualNumber64 y) {
        double a = DualNumber64.a(x);
        double b = DualNumber64.b(x);
        double xy = Math64.pow(a, y);
        return new DualNumber64(xy, b * xy * Math64.ln(a));
    }
    
    public static DualNumber64 exp(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double exp = Math64.exp(a);
        return new DualNumber64(exp, b * exp);
    }
    
    // logab 
    public static DualNumber64 log(double x, DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double tx = b / Math64.ln(x);
        return new DualNumber64(Math64.log(x, a), tx / a);
        DualNumber64 output = ln(value);
    }
    
    // logx = 1/x
    public static DualNumber64 ln(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        return new DualNumber64(Math64.ln(a), b / a);
    }
    
    // log10x = lnx / ln10
    public static DualNumber64 log10(DualNumber64 value) {
        double a = DualNumber64.a(value);
        double b = DualNumber64.b(value);
        double te = b / Math64.ln(10);
        return new DualNumber64(Math64.log10(a), te / a);
        DualNumber64 output = ln(value);
    }
}