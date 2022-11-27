package corejava.chapter7.lab10;

import java.util.Comparator;

public class Node implements Comparator<Node> {
    private int name;
    private int cost;

    public Node() {
    }

    public Node(int name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Node setName(int name) {
        this.name = name;
        return this;
    }

    public Node setCost(int cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public int compare(Node node1, Node node2) {
        return node1.cost - node2.cost;
    }
}