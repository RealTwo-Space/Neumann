package org.real2space.neumann.approssi.core.structure;

import org.real2space.neumann.approssi.core.util.DeepCopy;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *          created     2016/11/14
 */ 

public interface Matrix<E> extends DeepCopy <Matrix<E>> {

    public int getRow();
    public int getColumn();
    public E get(int row, int column);
    public void set(int row, int column, E value);

    /**
     * Add other matrix to this
     * @param other Matrix<E>
     * @return void
     */
    public void add (Matrix<E> other);
    
    /**
     * Subtract other matrix from this
     * @param other Matrix<E>
     * @return void
     */
    public void subtract (Matrix<E> other);
    
    /**
     * Multiply other matrix
     * @param other Matrix<E>
     * @return void
     */
    public void multiply (Matrix<E> other);
    
    /**
     * Multiply scalar to this matrix
     * @param scalar E
     * @return void
     */
    public void multiply (E scalar);

    /**
     * Divide this matrix by scalar
     * @param scalar E
     * @return E
     */
    public void divide (E scalar);
    
    /**
     * Calculate (this matrix)^(non-negative integer)
     * @param exponent int
     * @return void
     */
    public void power (int exponent);
    
    /**
     * Get the determinant of this matrix.
     * @return E
     */
    public E det ();
    
    /**
     * Get the trace of this matrix
     * @return E
     */
    public E trace ();
    
    /**
     * Transpose this matrix
     * @return void
     */
    public void transpose ();
    
    /**
     * Transpose this matrix
     * @return void
     */
    public void inverse ();

    public Matrix<E> deepCopy();
}