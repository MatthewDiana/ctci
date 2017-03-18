package com.matthewdiana.ctci.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question4_7 {

    public static void main(String[] args) {

        String[] projects = {"a", "b", "c", "d", "f"};
        String[][] dependencies = {new String[]{"a", "d"}, new String[]{"f", "b"}, new String[]{"b", "d"},
                                   new String[]{"f", "a"}, new String[]{"d", "c"}};

        ProjectGraph pg = buildGraph(projects, dependencies);

        System.out.println(Arrays.toString(findGoodOrder(pg)));

    }

    private static Project[] findGoodOrder(ProjectGraph pg) {

        Project[] order = new Project[pg.getNodes().size()];
        int currIndex = 0;
        for (Project p : pg.getNodes()) {
            if (p.getNumDep() == 0) {
                order[currIndex] = p;
                currIndex++;
            }
        }

        int indexPointer = 0;
        while (indexPointer < order.length) {
            Project p = order[indexPointer];
            if (p == null) { return null; }
            ArrayList<Project> children = p.getChildren();
            for (Project child : children) {
                child.decrDep();
                if (child.getNumDep() == 0) {
                    order[currIndex] = child;
                    currIndex++;
                }
            }
            indexPointer++;
        }

        return order;
    }

    private static ProjectGraph buildGraph(String[] projects, String[][] dependencies) {

        ProjectGraph pg = new ProjectGraph();
        for (String name : projects) {
            pg.addProject(name);
        }

        for (String[] dependency : dependencies) {
            pg.addDependency(dependency[0], dependency[1]);
        }

        return pg;
    }

}

class ProjectGraph {

    private ArrayList<Project> nodes;
    private Map<String, Project> projectMap;

    public ProjectGraph() {
        nodes = new ArrayList<>();
        projectMap = new HashMap<>();
    }

    public void addProject(String name) {
        if (!projectMap.containsKey(name)) {
            Project p = new Project(name);
            nodes.add(p);
            projectMap.put(name, p);
        }
    }

    public Project getProject(String name) {
        // ignore null checking for simplicity
        return projectMap.get(name);
    }

    public void addDependency(String p1Name, String p2Name) {
        getProject(p1Name).addChild(getProject(p2Name));
    }

    public ArrayList<Project> getNodes() { return nodes; }
}

class Project {
    private String name;
    private int numDependencies;
    private ArrayList<Project> children;

    public Project(String name) {
        this.name = name;
        this.numDependencies = 0;
        children = new ArrayList<>();
    }
    public String getName() { return name; }
    public void incrDep() { numDependencies++; }
    public void decrDep() { numDependencies--; }
    public int getNumDep() { return numDependencies; }

    public void addChild(Project p) {
        children.add(p);
        incrDep();
    }

    public ArrayList<Project> getChildren() { return children; }
}
