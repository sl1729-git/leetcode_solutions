package Solution301_499;

import java.util.*;

public class Solution399 {
    private Map<List<String>, Double> cache = new HashMap<>();

    private boolean check(List<List<String>> equations, double[] values, List<List<String>> queries){
        return true;
    }
//    规模太小，深搜不合适
//    private void putEdge(Map<String, Set<String>> graph, List<String> edge){
//        Set<String> tmp2;
//        if (graph.containsKey(edge.get(0))){
//            graph.get(edge.get(0)).add(edge.get(1));
//        }else {
//            tmp2 = new HashSet<>();
//            tmp2.add(edge.get(1));
//            graph.put(edge.get(0), tmp2);
//        }
//
//        if (graph.containsKey(edge.get(1))){
//            graph.get(edge.get(1)).add(edge.get(0));
//        }else {
//            tmp2 = new HashSet<>();
//            tmp2.add(edge.get(0));
//            graph.put(edge.get(1), tmp2);
//        }
//    }
//
//    private void build(List<List<String>> equations, double[] values, Map<String, Set<String>> graph,
//                       Map<List<String>, Double> valueMap){
//        for (int i = 0; i < values.length; i++) {
//            List<String> tmp = equations.get(i);
//            Set<String> tmp2;
//            valueMap.put(tmp, values[i]);
//            putEdge(graph, tmp);
//        }
//    }
//
//    private double solve(Map<String, Set<String>> graph, Map<List<String>, Double> valueMap, List<String> query){
//        if (query.get(0).equals(query.get(1)))
//            return 1;
//        if (!graph.containsKey(query.get(0)))
//            return -1;
//
//    }
//
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        check(equations, values, queries);
//        Map<String, Set<String>> graph = new HashMap<>();
//        Map<List<String>, Double> valueMap = new HashMap<>();
//        build(equations, values, graph, valueMap);
//
//
//    }

    public double[] solutionBadWrong(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> equation2value = new HashMap<>();
        Set<String> charSet = new HashSet<>();
        double[] ret = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            equation2value.put(a+b, values[i]);
            equation2value.put(b+a, 1/values[i]);
            charSet.add(a);
            charSet.add(b);
            for (int j = i; j < equations.size(); j++) {
                String c = equations.get(j).get(0);
                String d = equations.get(j).get(1);
                if (c.equals(a)){
                    equation2value.put(d+b,values[i]/values[j]);
                    equation2value.put(b+d,values[j]/values[i]);
                }else if (d.equals(a)){
                    equation2value.put(c+b,values[i]*values[j]);
                    equation2value.put(b+c,1/values[i]*values[j]);
                }

                if (c.equals(b)){
                    equation2value.put(a+d,values[i]*values[j]);
                    equation2value.put(d+a,1/values[i]*values[j]);
                }else if (d.equals(b)){
                    equation2value.put(a+c,values[i]/values[j]);
                    equation2value.put(c+a,values[j]/values[i]);
                }
            }
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (query.get(0).equals(query.get(1)) && charSet.contains(queries.get(0))){
                ret[i] = 1;
            }else
                ret[i] = equation2value.getOrDefault(query.get(0)+query.get(1),-1.0);
        }
        return ret;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> charSet = new HashSet<>();
        for (List<String> equation:equations) {
            charSet.add(equation.get(0));
            charSet.add(equation.get(1));
        }
        Map<String, Integer> charIndexMap = new HashMap<>();
        int index = 0;
        for (String s:charSet) {
            charIndexMap.put(s,index++);
        }
        
        double[][] graph = new double[index][index];
        for (int i = 0; i < values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph[charIndexMap.get(a)][charIndexMap.get(b)] = values[i];
            graph[charIndexMap.get(b)][charIndexMap.get(a)] = 1/values[i];
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 0)
                    continue;
                for (int k = 0; k < graph.length; k++) {
                    if (graph[i][k] != 0){
                        graph[k][j] = graph[i][j] / graph[i][k];
                        graph[j][k] = graph[i][k] / graph[i][j];
                    }
                    if (graph[k][j] != 0){
                        graph[k][i] = graph[k][j] / graph[i][j];
                        graph[i][k] = graph[i][j] / graph[k][j];
                    }
                    if (graph[j][k] != 0){
                        graph[i][k] = graph[i][j] * graph[j][k];
                        graph[k][i] = 1/graph[i][k];
                    }
                    if (graph[k][i] != 0){
                        graph[k][j] = graph[k][i] * graph[i][j];
                        graph[j][k] = 1/graph[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = (graph[i][j] != 0) ? graph[i][j] : -1;
            }
        }

        double[] ret = new double[queries.size()];
        index = 0;
        for (List<String> query:queries) {
            if (!charSet.contains(query.get(0)) || !charSet.contains(query.get(1)))
                ret[index++] = -1;
            else
                ret[index++] = graph[charIndexMap.get(query.get(0))][charIndexMap.get(query.get(1))];
        }

        return ret;
    }


    public static void main(String[] args) {
        List<String> tmp = new ArrayList<>();
        tmp.add("a");
        tmp.add("b");
        List<List<String>> equations = new ArrayList<>();
        equations.add(tmp);
        tmp = new ArrayList<>();
        tmp.add("c");
        tmp.add("d");
        equations.add(tmp);

        double[] values = new double[]{2,3};

        Solution399 s = new Solution399();
        s.calcEquation(equations, values, equations);
    }
}
