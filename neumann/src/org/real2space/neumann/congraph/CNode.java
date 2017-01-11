package org.real2space.neumann.congraph;

import org.real2space.neumann.approssi.core.structure.Matrix;
import org.real2space.neumann.approssi.core.structure.Vector;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.function.ActivationFunction;
import org.real2space.neumann.congraph.core.graph.CongraphInterface;
import org.real2space.neumann.congraph.core.graph.Node;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class CNode {
    private final Node node;
    private final Congraph cg;

    CNode(Node node, Congraph cg) {
        this.node = node;
        this.cg = cg;
    }

    Node getNode() {
        return this.node;
    }

    public void execute() {
        cg.execute(this);
        System.out.println(this.node);
    }

    public void execute(Assign... assigns) {
        cg.execute(this, assigns);
    }

    public Assign assign(double value) {
        return cg.assign(this, value);
    }

    public Assign assign(float value) {
        return cg.assign(this, value);
    }

    public Assign assign(Matrix value) {
        return cg.assign(this, value);
    }

    public Assign assign(double[][] value) {
        return cg.assign(this, value);
    }

    public Assign assign(Vector value) {
        return cg.assign(this, value);
    }

    public Assign assign(double[] value) {
        return cg.assign(this, value);
    }

    public Data getData() {
        return this.node.getData();
    }

    public String toString() {
        return this.node.toString();
    }

    public CNode add(CNode nodeB) {
        return cg.add(this, nodeB);
    }

    public CNode subtract(CNode nodeB) {
        return cg.subtract(this, nodeB);
    }

    public CNode multiply(CNode nodeB) {
        return cg.multiply(this, nodeB);
    }

    public CNode entrywizeMultiply(CNode nodeB) {
        return cg.entrywizeMultiply(this, nodeB);
    }

    public CNode matMultiply(CNode nodeB) {
        return cg.matMultiply(this, nodeB);
    }

    public CNode divide(CNode nodeB) {
        return cg.divide(this, nodeB);
    }

    public CNode entrywizeDivide(CNode nodeB) {
        return cg.entrywizeDivide(this, nodeB);
    }

    public CNode substitute(CNode nodeB) {
        return cg.substitute(this, nodeB);
    }

    public CNode incrementalSubstitute(CNode node) {
        return cg.incrementalSubstitute(this, node);
    }

    public CNode decrementalSubstitute(CNode node) {
        return cg.decrementalSubstitute(this, node);
    }

    public CNode sum() {
        return cg.sum(this);
    }

    public CNode normSq() {
        return cg.normSq(this);
    }

    public CNode partialDiff(CNode by) {
        return cg.partialDiff(this, by);
    }

    public CNode activate(ActivationFunction func) {
        return cg.activate(this, func);
    }

    public CNode sin() {
        return cg.sin(this);
    }

    public CNode cos() {
        return cg.cos(this);
    }

    public CNode tan(CNode nodeA) {
        return cg.tan(this);
    }


}
