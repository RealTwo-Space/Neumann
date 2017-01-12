package org.real2space.neumann.congraph.core.differentialequation.operation;

import org.real2space.neumann.approssi.analysis.differentialequation.DiffEq64;
import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.differentialequation.condition.DECondition;
import org.real2space.neumann.congraph.core.graph.BinomialArgument;
import org.real2space.neumann.congraph.core.graph.Node;
import org.real2space.neumann.congraph.core.graph.Operation;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 *
 * created 1/11/17
 */
public class LaplacianOperation extends Operation{
    private BinomialArgument arg;
    private DECondition cond;

    public LaplacianOperation(Node U, Node dx, DECondition cond) {
        this.arg = new BinomialArgument(U, dx);
        this.cond = cond;
    }

    @Override
    public Data execute() {
        if (this.arg.getDataAt(0).get() instanceof Matrix64 && this.arg.getDataAt(1).get() instanceof Double) {
            Matrix64 u = (Matrix64)this.arg.getDataAt(0).get();
            Double dx = (Double)this.arg.getDataAt(1).get();
            Matrix64 output = DiffEq64.laplacian(u, (double)dx, this.cond.getCondition());

            return new MatrixData(output);
        }
        throw new NotImplementedException();
    }
}
