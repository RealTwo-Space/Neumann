package org.real2space.neumann.approssi.analysis.differentialequation;

import org.real2space.neumann.approssi.core.value.Matrix64;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */
public interface BoundaryCondition64 {
    void executeNabla(Matrix64 u, Matrix64 newU);
    void executeLaplacian(Matrix64 u, Matrix64 newU);
}
