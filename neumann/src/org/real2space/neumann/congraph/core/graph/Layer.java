package org.real2space.neumann.congraph.core.graph;

import java.util.HashSet;

/**
 * Project Neumann
 *
 * @author RealTwo-Space
 * @version 0
 * 
 * created 12/02/16
 */
class Layer {
    private HashSet<Group> groups;
    
    protected Layer() {
        this.groups = new HashSet<Group>();
    }
    
    protected void addGroup (Group group) {
        this.groups.add(group);
    }
    
    protected HashSet<Group> getGroups() {
        return this.groups;
    }
}
