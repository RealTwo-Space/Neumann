package org.real2space.neumann.congraph.core.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/03/16
 */
public class Scheduler {
    private static final Scheduler singleton = new Scheduler();
    
    private Scheduler() {}
    
    protected static Scheduler getInstance() {
        return singleton;
    }

    protected Schedule createSchedule(Node origin, Graph graph) {
        Schedule schedule = new Schedule(origin);
        
        Node[] nodes;
        LinkedList linkedList = schedule.getLayers();
        ListIterator<Layer> it = linkedList.listIterator();
        
        ArrayDeque<Group> stack = new ArrayDeque<Group>();

        Group originsChildren = graph.getChildren(origin);

        if (originsChildren == null) {
            return schedule;
        }

        stack.push(originsChildren);

        while(!stack.isEmpty()) {
            Group group = stack.pop();
            if (it.hasNext()) {
                it.next().addGroup(group);
            } else {
                it.add(new Layer());
                it.previous().addGroup(group);
                it.next();
            }

            nodes = group.getNodes();
            
            for (int i = 0, n = nodes.length; i < n; i++) {
                Group children = graph.getChildren(nodes[i]);
                if (children != null) {
                    stack.push(children);
                }
            }
        }
        
        return schedule;
    }
}
