package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.approssi.core.structure.*;
import org.real2space.neumann.congraph.core.operation.*;
import org.real2space.neumann.congraph.core.data.*;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/24/16
 */
public class Congraph {
    private Brain brain;
    public Congraph() {
        this.brain = new Brain();
    }
    
    public Node Constant(Data data) {
        Data nodeData = data.deepCopy();
        Constant con = new Constant(nodeData);
        Node node = new Node(nodeData, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node floatConstant (float constant) {
        Data data = new FloatData(constant);
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node doubleConstant (double constant) {
        Data data = new DoubleData(constant);
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node vectorConstant (Vector constant) {
        Data data = new VectorData(constant.deepCopy());
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node matrixConstant (Matrix constant) {
        Data data = new MatrixData(constant.deepCopy());
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node variable (Data data) {
        Variable var = new Variable();
        Node node = new Node(data.deepCopy(), var);
        var.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node floatVariable (float variable) {
        Variable var = new Variable();
        Data data = new FloatData(variable);
        Node node = new Node(data, var);
        vat.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node doubleVariable (double variable) {
        Variable var = new Variable();
        Data data = new DoubleData(variable);
        Node node = new Node(data, var);
        vat.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node vectorVariable (Vector variable) {
        Variable var = new Variable();
        Data data = new VectorData(variable.deepCopy());
        Node node = new Node(data, var);
        vat.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node matrixVariable (Matrix variable) {
        Variable var = new Variable();
        Data data = new MatrixData(variable.deepCopy());
        Node node = new Node(data, var);
        vat.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node add (Node nodeA, Node nodeB) {
        Operation op = new AddOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    public Node subtract (Node nodeA, Node nodeB) {
        Operation op = new SubtractOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    public Node multiply (Node nodeA, Node nodeB) {
        Operation op = new MultiplyOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    public Node divide (Node nodeA, Node nodeB) {
        Operation op = new DivideOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    public Node substitute(Node nodeA, Node nodeB) {
        Operation op = new SubstituteOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    public void execute(Node node) {
        this.brain.execute(node);
        System.out.println(node);
    }
}
