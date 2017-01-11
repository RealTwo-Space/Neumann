package org.real2space.neumann.congraph;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.structure.Vector;
import org.real2space.neumann.approssi.core.value.Matrix32;
import org.real2space.neumann.approssi.core.value.Matrix64;
import org.real2space.neumann.approssi.core.value.Vector64;
import org.real2space.neumann.congraph.core.data.*;
import org.real2space.neumann.congraph.core.differentialequation.condition.DECondition;
import org.real2space.neumann.congraph.core.function.ActivationFunction;
import org.real2space.neumann.congraph.core.graph.CongraphInterface;
import org.real2space.neumann.congraph.core.graph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringJoiner;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class Congraph {
    private final CongraphInterface cgi;
    public final CUtil util;
    public static final CFunc func = new CFunc();
    private HashMap<CNode, Assign> assignsSet;

    public Congraph() {
        this.cgi = new CongraphInterface();
        this.util = new CUtil(this);
        this.assignsSet = new HashMap<CNode, Assign>();
    }

    public Congraph(long randomSeed) {
        this.cgi = new CongraphInterface();
        this.util = new CUtil(this, randomSeed);
        this.assignsSet = new HashMap<CNode, Assign>();
    }

    public void execute(CNode node) {
        this.cgi.execute(node.getNode());
    }

    public void execute(CNode node, Assign... assigns) {
        int N = assigns.length;
        for (int i = 0; i < N; i++) {
            assignToPlaceholder(assigns[i]);
        }
        this.cgi.execute(node.getNode());
    }

    private void assignToPlaceholder(Assign assign) {
        this.cgi.assign(assign.getNode(), assign.getData());
    }

    public Assign assign(CNode node, double value) {
        return assign(node, new DoubleData(value));
    }

    public Assign assign(CNode node, float value) {
        return assign(node, new FloatData(value));
    }

    public Assign assign(CNode node, Matrix value) {
        return assign(node, new MatrixData(value));
    }

    public Assign assign(CNode node, double[][] value) {
        return assign(node, new MatrixData(new Matrix64(value)));
    }

    public Assign assign(CNode node, Vector value) {
        return assign(node, new VectorData(value));
    }

    public Assign assign(CNode node, double[] value) {
        return assign(node, new VectorData(new Vector64(value)));
    }

    private Assign assign(CNode node, Data data) {
        Assign assign;
        if (this.assignsSet.containsKey(node)) {
            assign = this.assignsSet.get(node);
            assign.setData(data);
        }
        assign = new Assign(node.getNode(), data);
        this.assignsSet.put(node, assign);
        return assign;
    }

    public CNode constant(double value) {
        Node node = this.cgi.constant(value);
        return new CNode(node, this);
    }

    public CNode constant(double[][] value) {
        Node node = this.cgi.constant(new Matrix64(value));
        return new CNode(node, this);
    }

    public CNode constant(Matrix64 value) {
        Node node = this.cgi.constant(value);
        return new CNode(node, this);
    }

    public CNode variable(double value) {
        Node node = this.cgi.variable(value);
        return new CNode(node, this);
    }

    public CNode variable(double[][] value) {
        Node node = this.cgi.variable(new Matrix64(value));
        return new CNode(node, this);
    }

    public CNode variable(Matrix64 value) {
        Node node = this.cgi.variable(value);
        return new CNode(node, this);
    }

    public CNode placeholder() {
        Node node = this.cgi.placeholder();
        return new CNode(node, this);
    }

    public CNode add(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.add(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode subtract(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.subtract(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode multiply(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.multiply(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode entrywizeMultiply(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.entrywizeMultiply(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode matMultiply(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.matrixMultiply(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode divide(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.divide(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode entrywizeDivide(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.entrywizeDivide(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode substitute(CNode nodeA, CNode nodeB) {
        Node node = this.cgi.substitute(nodeA.getNode(), nodeB.getNode());
        return new CNode(node, this);
    }

    public CNode incrementalSubstitute(CNode nodeA, CNode nodeB) {
        CNode out = nodeA.add(nodeB);
        return substitute(nodeA, out);
    }

    public CNode decrementalSubstitute(CNode nodeA, CNode nodeB) {
        CNode out = nodeA.subtract(nodeB);
        return substitute(nodeA, out);
    }

    public CNode sum(CNode nodeA) {
        Node node = this.cgi.sum(nodeA.getNode());
        return new CNode(node, this);
    }

    public CNode normSq(CNode nodeA) {
        Node node = this.cgi.normSquared(nodeA.getNode());
        return new CNode(node, this);
    }

    public CNode partialDiff(CNode target, CNode by) {
        Node node = this.cgi.partialDiff(target.getNode(), by.getNode());
        return new CNode(node, this);
    }

    public CNode batch(CNode... cnodes) {
        int size = cnodes.length;
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = cnodes[i].getNode();
        }
        Node node = this.cgi.batch(nodes);
        return new CNode(node, this);
    }

    public CNode activate(CNode nodeA, ActivationFunction func) {
        Node node = this.cgi.activate(nodeA.getNode(), func);
        return new CNode(node, this);
    }

    public CNode sin(CNode nodeA) {
        Node node = this.cgi.sin(nodeA.getNode());
        return new CNode(node, this);
    }

    public CNode cos(CNode nodeA) {
        Node node = this.cgi.cos(nodeA.getNode());
        return new CNode(node, this);
    }

    public CNode tan(CNode nodeA) {
        Node node = this.cgi.tan(nodeA.getNode());
        return new CNode(node, this);
    }

    // nodeA = u, nodeB = dx
    public CNode nabla (CNode nodeA, CNode nodeB, DECondition cond) {
        Node node = this.cgi.nabla(nodeA.getNode(), nodeB.getNode(), cond);
        return new CNode(node, this);
    }

    public CNode laplacian (CNode nodeA, CNode nodeB, DECondition cond) {
        Node node = this.cgi.laplacian(nodeA.getNode(), nodeB.getNode(), cond);
        return new CNode(node, this);
    }
}
