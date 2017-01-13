package org.real2space.neumann.congraph.core.data;

/**
 * Project Neumann
 * created 2017/01/12
 *
 * @author RealTwo-Space
 * @version 0
 */
public interface MatrixMutiplyInterface<E> {
    /**
     * return matrixMultiply
     * @param a Data
     * @return E
     */
    Data<E> matrixMultiply(Data a);

}
