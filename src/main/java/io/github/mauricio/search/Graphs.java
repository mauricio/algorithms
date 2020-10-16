package io.github.mauricio.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graphs {

    public static List<Node> shortestPath(Node start, Node end)  {
        var results = pathTo(start, end, Collections.singletonList(start));
        var largest = -1;

        for (int x = 0; x < results.size(); x++) {
            if (results.get(x).size() > largest) {
                largest = x;
            }
        }

        if (largest != -1) {
            return results.get(largest);
        }

        return null;
    }

    public static List<List<Node>> pathTo(Node start, Node end, List<Node> current) {
        if (start.nodes.isEmpty()) {
            return Collections.emptyList();
        }

        var results = new ArrayList<List<Node>>();

        if (start.nodes.contains(end)) {
            results.add(addAndClone(current, end));
            return results;
        }

        for (var n : start.nodes) {
            var list = pathTo(n, end, addAndClone(current, n));
            if (!list.isEmpty()) {
                results.addAll(list);
            }
        }

        return results;
    }

    public static <E> List<E> addAndClone(List<E> items, E e) {
        var list = new ArrayList<>(items);
        list.add(e);
        return list;
    }

}
