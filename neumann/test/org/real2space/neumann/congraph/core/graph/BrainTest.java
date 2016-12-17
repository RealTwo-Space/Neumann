package org.real2space.neumann.congraph.core.graph;

import org.junit.Test;

import org.real2space.neumann.congraph.core.data.*;
import org.real2space.neumann.congraph.core.graph.*;
import org.real2space.neumann.congraph.core.operation.*;
import org.real2space.neumann.approssi.core.value.*;
import org.real2space.neumann.approssi.core.structure.*;

import static org.junit.Assert.*;

/**
 * Created by ryosukesuzuki on 2016/12/18.
 */
public class BrainTest {
    @Test
    public void execute() throws Exception {
        Brain brain = new Brain();

        Data dataA = new DoubleData(3.0);
        Constant conA = new Constant(dataA);
        Node nodeA = new Node(dataA , conA);
        brain.graph.addNode(nodeA);

        Data dataB = new MatrixData(new Matrix64(new double[][]{{1.0, 0}, {0, 1.0}}));
        Constant conB = new Constant(dataB);
        Node nodeB = new Node(dataB, conB);
        brain.graph.addNode(nodeB);

        Operation op = new MultiplyOperation(nodeB.refData(), nodeA.refData());
        Node nodeC = new Node(null, op);
        brain.graph.addNode(nodeC);

        Node[] children = {nodeB, nodeA};
        Group group = new Group(children);

        brain.graph.addEdge(nodeC, group);




        System.out.println("KOKOKOKO");
        brain.execute(nodeC);
    }

}