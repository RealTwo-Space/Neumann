package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.approssi.core.function.Function;
import org.real2space.neumann.approssi.core.structure.*;
import org.real2space.neumann.congraph.core.differentialequation.condition.DECondition;
import org.real2space.neumann.congraph.core.differentialequation.operation.*;
import org.real2space.neumann.congraph.core.function.ActivationFunction;
import org.real2space.neumann.congraph.core.operation.*;
import org.real2space.neumann.congraph.core.data.*;

import java.util.HashMap;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/24/16
 */
public class CongraphInterface {
    private Brain brain;
    private HashMap<Node, Node> backProps;
    private HashMap<Node, BackPropagationPool> backPropPools;

    public CongraphInterface() {
        this.brain = new Brain();
        this.backProps = new HashMap<Node, Node>();
        this.backPropPools = new HashMap<Node, BackPropagationPool>();
    }
    
    /*
    public Node Constant(Data data) {
        Data nodeData = data.deepCopy();
        Constant con = new Constant(nodeData);
        Node node = new Node(nodeData, con);
        this.brain.addNode(node);
        return node;
    }
    */

    public void execute(Node node) {
        this.brain.execute(node);
        //System.out.println(node);
    }
    
    public Node constant(float constant) {
        Data data = new FloatData(constant);
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node constant(double constant) {
        Data data = new DoubleData(constant);
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node constant(Vector constant) {
        Data data = new VectorData((Vector)constant.deepCopy());
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node constant(Matrix constant) {
        Data data = new MatrixData((Matrix)constant.deepCopy());
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node constant(DualNumber constant) {
        Data data = new DualNumberData((DualNumber)constant.deepCopy());
        Constant con = new Constant(data);
        Node node = new Node (data, con);
        this.brain.addNode(node);
        return node;
    }
    
    public Node variable(Data data) {
        Variable var = new Variable();
        Node node = new Node(data.deepCopy(), var);
        var.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node variable(float variable) {
        Variable var = new Variable();
        Data data = new FloatData(variable);
        Node node = new Node(data, var);
        var.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node variable(double variable) {
        Variable var = new Variable();
        Data data = new DoubleData(variable);
        Node node = new Node(data, var);
        var.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node variable(Vector variable) {
        Variable var = new Variable();
        Data data = new VectorData((Vector)variable.deepCopy());
        Node node = new Node(data, var);
        var.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node variable(Matrix variable) {
        Variable var = new Variable();
        Data data = new MatrixData((Matrix) variable.deepCopy());
        Node node = new Node(data, var);
        var.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }
    
    public Node variable(DualNumber variable) {
        Variable var = new Variable();
        Data data = new DualNumberData((DualNumber)variable.deepCopy());
        Node node = new Node(data, var);
        var.setMonomialArgument(node);
        this.brain.addNode(node);
        return node;
    }

    public Node placeholder() {
        Placeholder plac = new Placeholder();
        Node node = new Node(null, plac);
        this.brain.addNode(node);
        return node;
    }

    public void assign(Node node, Data data) {
        Placeholder plac = (Placeholder) node.getState();
        plac.setData(data);
    }
    
    public Node add(Node nodeA, Node nodeB) {
        Operation op = new AddOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    public Node subtract(Node nodeA, Node nodeB) {
        Operation op = new SubtractOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    public Node multiply(Node nodeA, Node nodeB) {
        Operation op = new MultiplyOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node matrixMultiply(Node nodeA, Node nodeB) {
        Operation op = new MatrixMultiplyOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addNode(node);
        this.brain.addEdge(node, group);
        return node;
    }

    public Node entrywizeMultiply(Node nodeA, Node nodeB) {
        Operation op = new EntrywizeMultiplyOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node entrywizeDivide(Node nodeA, Node nodeB) {
        Operation op = new EntrywizeDivideOperation(nodeA, nodeB);
        Node node = new Node(null, op);
        Node[] children = {nodeA, nodeB};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    public Node divide(Node nodeA, Node nodeB) {
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
    
    public Node function(Function func, HashMap<String, Node> args) {
        Operation op = new FunctionOperation(func, args);
        Node node = new Node(null, op);

        Object[] tempArray = args.values().toArray();
        Node[] children = new Node[tempArray.length];
        for (int i = 0, n = tempArray.length; i < n; i++) {
            children[i] = (Node)tempArray[i];
        }

        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node backPropagate(Node target) {
        BackPropagationPool pool;
        Schedule schedule = brain.getScheduler().createSchedule(target, brain.getGraph());
        pool = new BackPropagationPool(schedule);
        Operation op = new BackPropagateOperation(pool, brain.getGraph());
        Node node = new Node(null, op);
        Node[] children = {target};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        this.backPropPools.put(target, pool);
        this.backProps.put(target, node);

        return node;
    }

    // target wo by de partial diff sita atai wo kaesu
    public Node partialDiff(Node target, Node by) {
        Node backProp;
        if (backProps.containsKey(target)) {
            backProp = backProps.get(target);
        } else {
            backProp = backPropagate(target);
        }
        Operation op = new PartialDifferentiateOperation(by, this.backPropPools.get(target));
        Node node = new Node(null, op);
        Node[] children = {backProp, by};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node sum(Node nodeA) {
        Operation op = new SumOperation(nodeA);
        Node node = new Node(null, op);
        Node[] children = {nodeA};
        Group group = new Group(children);
        this.brain.addNode(node);
        this.brain.addEdge(node, group);
        return node;
    }

    public Node normSquared(Node nodeA) {
        Operation op = new NormSquaredOperation(nodeA);
        Node node = new Node(null, op);
        Node[] children = {nodeA};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node batch(Node... nodes) {
        Operation op = new BatchOperation(nodes);
        Node node = new Node(null, op);
        Group group = new Group(nodes);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node activate(Node nodeA, ActivationFunction func) {
        Operation op = new ActivateOperation(nodeA, func);
        Node node = new Node(null, op);
        Node[] children = {nodeA};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node sin(Node nodeA) {
        Operation op = new SinOperation(nodeA);
        Node node = new Node(null, op);
        Node[] children = {nodeA};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node cos(Node nodeA) {
        Operation op = new CosOperation(nodeA);
        Node node = new Node(null, op);
        Node[] children = {nodeA};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node tan(Node nodeA) {
        Operation op = new TanOperation(nodeA);
        Node node = new Node(null, op);
        Node[] children = {nodeA};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
    
    // Ryu added from here
    public Node nabla (Node u, Node dx, DECondition cond) {
        Operation op = new NablaOperation(u, dx, cond);
        Node node = new Node(null, op);
        Node[] children = {u, dx};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }

    public Node laplacian (Node u, Node dx, DECondition cond) {
        Operation op = new LaplacianOperation(u, dx, cond);
        Node node = new Node(null, op);
        Node[] children = {u, dx};
        Group group = new Group(children);
        this.brain.addEdge(node, group);
        this.brain.addNode(node);
        return node;
    }
}
