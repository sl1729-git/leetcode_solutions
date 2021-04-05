package Solution500_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<Node> nodes = new ArrayList<>();
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(graph, i));
        }
        List<Node> tmp = new ArrayList<>();
        Node[] tmp2;
        for (int i = 0; i < m; i++) {
            tmp.clear();
            for (int j = 0; j < group.length; j++) {
                if (group[j] == i)
                    tmp.add(graph.get(j));
            }
            tmp2 = tmp.toArray(new Node[0]);
            nodes.add(new Node(graph, tmp2));
        }

        for (int i = group.length - 1; i > 0; i--) {
            if (group[i] != -1)
                nodes.remove(i);
        }

        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> beforeItem = beforeItems.get(i);
            for (int j = 0; j < beforeItem.size(); j++) {
                nodes.get(0).add(i);
            }
        }



        return null;
    }
}

class Node{
    private Node[] vector1 = null;
    private int vector2 = -1;
    private int inNodeNUm = 0;
    public int tag = -1;
    Map<Integer, Node> graph;
    
    public Node(Map<Integer, Node> graph, int vector){
        this.graph = graph;
        this.vector2 = vector;
        this.graph.put(vector, this);
    }
    
    public Node(Map<Integer, Node> graph, Node[] vector){
        this.graph = graph;
        this.vector1 = vector;
        Map<Integer, Node> subGraph = new HashMap<>();
        for (Node node:vector) {
            this.graph.remove(node.vector2);
            subGraph.put(node.vector2, node);
            node.graph = subGraph;
            this.graph.put(node.vector2, this);
        }
    }
    
    public void add(int to){
        if (graph.get(to).vector2 == -1){
            this.vector1[0].add(to);
        }else 
            graph.get(to).inNodeNUm ++;
    }
    
    public void remove(int to){
        if (graph.get(to).vector2 == -1){
            this.vector1[0].add(to);
        }else
            graph.get(to).inNodeNUm --;
    }
}