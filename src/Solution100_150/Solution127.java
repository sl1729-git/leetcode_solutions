package Solution100_150;

import java.util.*;

public class Solution127 {
    private boolean hasEdge(String s, String t){
        assert s.length() == t.length();
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            diff += s.charAt(i) == t.charAt(i) ? 0 : 1;
        }
        return diff == 1;
    }

    private void addEdge(String s, String t, Map<String, List<String>> graph){
        if (!graph.containsKey(s)){
            graph.put(s, new ArrayList<>());
        }
        graph.get(s).add(t);
    }

    private int search(String s, String t, Map<String, List<String>> graph){
        int ret = 0;
        Set<String> tmp2 = new HashSet<>(), tmp;
        Set<String> visitNode = new HashSet<>();
        visitNode.add(s);
        if (!graph.containsKey(s))
            return 0;
        Set<String> tmp1 = new HashSet<>(graph.get(s));
        boolean flag = false;
        while (tmp1.size() != 0){
            ret ++;
            for (String source:tmp1) {
                flag |= source == t;
                if (graph.containsKey(source)){
                    for(String target:graph.get(source)){
                        if (!visitNode.contains(target))
                            tmp2.add(target);
                    }
                    visitNode.addAll(graph.get(source));
                }
            }
            if (flag)
                break;
            tmp = tmp1;
            tmp1 = tmp2;
            tmp2 = tmp;
            tmp2.clear();
        }
        return flag ? ret+1 : 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ret = 0;
        if (!wordList.contains(endWord))
            return 0;
        if (!wordList.contains(beginWord))
            wordList.add(beginWord);
        endWord = wordList.get(wordList.indexOf(endWord));
        Map<String,List<String>> graph = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String t = wordList.get(j);
                if (hasEdge(s, t)) {
                    addEdge(s, t, graph);
                    addEdge(t, s, graph);
                }
            }
        }
        return search(beginWord, endWord, graph);
    }

    public static void main(String[] args) {
        String s = "hit", t = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList(new String[]{
                "hot","dot","tog","cog"
        }));
//                Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        Solution127 S = new Solution127();
        System.out.println(S.ladderLength(s, t, wordList));
    }
}
