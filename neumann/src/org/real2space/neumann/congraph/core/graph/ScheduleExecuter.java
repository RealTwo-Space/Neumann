package org.real2space.neumann.congraph.core.graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.HashSet;
import java.util.Iterator;
/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/02/16
 */
 
protected class ScheduleExecuter {
    private static final ScheduleExecuter singleton = new ScheduleExecuter();
    
    private ScheduleExecuter() {}
    
    protected static ScheduleExecuter getInstance() {
        return singleton;
    }
    
    protected void executeSchedule(Schedule schedule) {
        // many fors schedule => layers => group => node.execute()
        LinkedList<Layer> layers = schedule.getLayers();
        Layer layer;
        HashSet<Group> groups;
        Group group;
        Node[] nodes;
    
        for (ListIterator<Layer> itL = layers.listIterator(); itL.hasNext();){
            layer = itL.next();
            groups = layer.getGroups();
            for (Iterator<Group> itG = groups.iterator(); itG.hasNext();) {
                group = itG.next();
                nodes = group.getNodes();
                for (int i = 0, n = nodes.length; i < n; i++) {
                    nodes[i].execute();
                }
            }
        }
        
        schedule.getOrigin().execute();
        
    }
}
