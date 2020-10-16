package io.github.mauricio.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

    public Node(String name, Node ... nodes) {
        this.name = name;
        this.nodes = Arrays.asList(nodes);
    }

    String name;
    List<Node> nodes = new ArrayList<>();
}
