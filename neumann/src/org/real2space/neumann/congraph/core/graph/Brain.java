package org.real2space.neumann.congraph.core.graph;

import java.util.HashMap;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/04/16
 */
public class Brain {
    private HashMap<Node, Schedule> schedules;
    private Scheduler scheduler;
    private ScheduleExecuter scheduleExecuter;
    public Graph graph;
    
    public Brain() {
        this.scheduler = Scheduler.getInstance();
        this.scheduleExecuter = ScheduleExecuter.getInstance();
        this.graph = new Graph();
        this.schedules = new HashMap<Node, Schedule>();
    }
    
    public void execute(Node origin) {
        Schedule schedule;
        if (this.schedules.containsKey(origin)) {
            schedule = this.schedules.get(origin);
        } else {
            schedule = this.scheduler.createSchedule(origin, this.graph);
        }
        this.scheduleExecuter.executeSchedule(schedule);
    }

    public Graph getGraph() {
        return this.graph;
    }

    public Scheduler getScheduler() {
        return this.scheduler;
    }
    
    public void addNode(Node node) {
        this.graph.addNode(node);
    }
    
    public void addEdge(Node node, Group group) {
        this.graph.addEdge(node, group);
    }
}
