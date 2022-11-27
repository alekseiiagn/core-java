package corejava.chapter7.lab10;

import java.util.*;

public class Lab10 {

    static int COUNT = 5;
    static int SOURCE = 0;

    public static void main(String[] args) {
        List<List<Node>> adj = createGraph(COUNT);

        int[] dist = dijkstra(adj, SOURCE);
        for (int i = 0; i < dist.length; i++)
            System.out.println(SOURCE + " -> " + i + " = " + dist[i]);
    }

    private static List<List<Node>> createGraph(int count) {
        List<List<Node>> adj = initialize(count);
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));
        return adj;
    }

    private static List<List<Node>> initialize(int count) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            adj.add(new ArrayList<>());
        }
        return adj;
    }

    public static int[] dijkstra(List<List<Node>> adj, int source) {
        int count = adj.size();
        int[] dist = createArrayDist(count);
        Set<Node> passed = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(count, new Node());

        queue.add(new Node(source, 0));
        dist[source] = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            List<Node> neighbors = adj.get(curr.getName());
            for (Node neighbor : neighbors) {
                if (!passed.contains(neighbor)) {
                    int newDist = dist[curr.getName()] + neighbor.getCost();
                    if (newDist < dist[neighbor.getName()]) {
                        dist[neighbor.getName()] = newDist;
                    }
                    queue.add(new Node(neighbor.getName(), dist[neighbor.getName()]));
                }
            }
            passed.add(curr);
        }
        return dist;
    }

    private static int[] createArrayDist(int count) {
        int[] dist = new int[count];
        for (int i = 0; i < count; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        return dist;
    }
}
