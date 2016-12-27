package org.real2space.neumann.congraph.core.graph;

import org.junit.Test;

import org.real2space.neumann.congraph.core.data.*;
import org.real2space.neumann.congraph.core.graph.*;
import org.real2space.neumann.congraph.core.operation.*;
import org.real2space.neumann.approssi.core.value.*;
import org.real2space.neumann.approssi.core.structure.*;

import static org.junit.Assert.*;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/18/16
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

        Operation op = new MultiplyOperation(nodeB, nodeA);
        Node nodeC = new Node(null, op);
        brain.graph.addNode(nodeC);

        Node[] children = {nodeB, nodeA};
        Group group = new Group(children);

        brain.graph.addEdge(nodeC, group);




        System.out.println("KOKOKOKO");
        brain.execute(nodeC);
        System.out.println("Here " + nodeC);
    }

    @Test
    public void execute2() throws Exception {
        /*
        E(*)-D(C)
            -C(*)-A(C)
                 -B(C)
         */

        Brain brain = new Brain();

        Data dataA = new DoubleData(3.0);
        Constant conA = new Constant(dataA);
        Node nodeA = new Node(dataA , conA);
        brain.graph.addNode(nodeA);

        Data dataB = new MatrixData(new Matrix64(new double[][]{{1.0, 0}, {0, 1.0}}));
        Constant conB = new Constant(dataB);
        Node nodeB = new Node(dataB, conB);
        brain.graph.addNode(nodeB);

        Operation op = new MultiplyOperation(nodeB, nodeA);
        Node nodeC = new Node(null, op);
        brain.graph.addNode(nodeC);

        Node[] children = {nodeB, nodeA};
        Group group = new Group(children);

        brain.graph.addEdge(nodeC, group);

        Data dataD = new MatrixData(new Matrix64(new double[][]{{1.0, 100.0}, {0, 1.0}}));
        Constant conD = new Constant(dataD);
        Node nodeD = new Node(dataD, conD);
        brain.graph.addNode(nodeD);

        Operation op2 = new AddOperation(nodeD, nodeC);
        Node nodeE = new Node(null, op2);
        brain.graph.addNode(nodeE);

        Node[] children2 = {nodeD, nodeC};
        Group group2 = new Group(children2);

        brain.graph.addEdge(nodeE, group2);

        System.out.println("KOKOKOKO");
        brain.execute(nodeE);
        System.out.println("Here " + nodeE);
    }

    @Test
    public void variableTest () {
        /*
        Data daA = new DoubleData(1.0);
        Variable v = new Variable();
        Node a = new Node(daA, v);
        v.setMonomialArgument(a);


        Variable v2 = new Variable(v);
        Node b = new Node();
        */

    }
}