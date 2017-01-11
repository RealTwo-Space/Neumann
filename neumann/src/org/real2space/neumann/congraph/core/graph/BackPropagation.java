package org.real2space.neumann.congraph.core.graph;

import org.real2space.neumann.congraph.core.backpropagate.differentiation.Diff;
import org.real2space.neumann.congraph.core.backpropagate.tensor.Tensor;
import org.real2space.neumann.congraph.core.data.Data;
import org.real2space.neumann.congraph.core.data.MatrixData;
import org.real2space.neumann.congraph.core.data.NumberData;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by ryosukesuzuki on 2016/12/31.
 */
public class BackPropagation {
    private static final BackPropagation singleton = new BackPropagation();

    private BackPropagation() {}

    public static BackPropagation getInstance() {
        return singleton;
    }

    public void execute(BackPropagationPool pool, Graph graph) {

        pool.refresh();

        Schedule schedule = pool.getSchedule();
        LinkedList<Layer> layers = schedule.getLayers();
        Layer layer;
        HashSet<Node> nodes;

        Node origin = schedule.getOrigin();
        pool.addData(origin, new Tensor(1.0));
        addPartials(origin, pool, graph);

        for (ListIterator<Layer> itL = layers.listIterator(); itL.hasNext();){
            layer = itL.next();
            nodes = layer.getNodes();
            for (Node node : nodes) {
                addPartials(node, pool, graph);
            }

        }
    }

    private void addPartials(Node node, BackPropagationPool pool, Graph graph) {

        Group children = graph.getChildren(node);
        if (children == null) return;

        int argSize = children.size();

        Tensor[] refs = new Tensor[argSize];
        for (int i = 0; i < argSize; i++) {
            refs[i] = Tensor.convert(children.getNode(i).refData());
        }
        Diff diff = Diff.valueOf((Operation)node.getState());
        Tensor nodeTensor = pool.getTensor(node);
        Tensor[] outputs = diff.execute(nodeTensor, refs);

        for (int i = 0; i < argSize; i++) {

            pool.addData(children.getNode(i), outputs[i]);
        }
    }
}



/*
    0. subeteno data wo zero ni reflesh suru
    1. origin jisin no keisan. origin no kodomo ni add
    2. node no kodomo wo toru
    3. kodomo tati ni diff de keisan sareta yatu to jisin no seki wo tasu
    4. owari
 */