package Solution500_;

import java.util.*;

public class Solution1202 {
//    private int[] buildGraph(List<List<Integer>> pairs, int len){
//        int[] ret = new int[len];
//        Arrays.fill(ret, -1);
//        int index = 0, a, b, minAB, maxAB;
//        List<Integer> tmp;
//        for (int i = 0; i < pairs.size(); i++) {
//            tmp = pairs.get(i);
//            a = tmp.get(0);
//            b = tmp.get(1);
//            if (ret[a] == -1 && ret[b] == -1)
//                ret[a] = ret[b] = index++;
//            else if (ret[a] != -1 && ret[b] != -1){
//                a = ret[a];
//                b = ret[b];
//                minAB = Math.min(a, b);
//                for (int j = 0; j < len; j++) {
//                    ret[i] = (ret[i] == a || ret[i] == b) ? minAB : ret[i];
//                }
//            }else {
//                maxAB = Math.max(ret[a], ret[b]);
//                ret[a] = ret[b] = maxAB;
//            }
//        }
//        return ret;
//    }

    private Map<Integer, Set<Integer>> buildGraph(List<List<Integer>> pairs){
        Map<Integer, Set<Integer>> ret = new HashMap<>();
        Map<Integer, Integer> keyMap = new HashMap<>();
        List<Integer> tmp;
        Set<Integer> tmp2;
        int a, b, keyA, keyB, indextmp, index = 0;
        for (int i = 0; i < pairs.size(); i++) {
            tmp = pairs.get(i);
            a = tmp.get(0);
            b = tmp.get(1);
            if (keyMap.containsKey(a) && keyMap.containsKey(b)){
                keyA = keyMap.get(a);
                keyB = keyMap.get(b);
                if (keyA == keyB)
                    continue;
                tmp2 = ret.remove(keyA);
                for (Integer key:tmp2) {
                    keyMap.put(key, keyB);
                }
                ret.get(keyB).addAll(tmp2);
            }else if (!keyMap.containsKey(a) && !keyMap.containsKey(b)){
                keyMap.put(a, index);
                keyMap.put(b, index);
                tmp2 = new HashSet<>();
                tmp2.add(a);
                tmp2.add(b);
                ret.put(index++, tmp2);
            }else {
                if (keyMap.containsKey(a)){
                    keyMap.put(b, keyMap.get(a));
                    ret.get(keyMap.get(a)).add(b);
                }else {
                    keyMap.put(a, keyMap.get(b));
                    ret.get(keyMap.get(b)).add(a);
                }
            }
        }
        return ret;
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs == null || pairs.size() == 0 || s == null)
            return s;
        Map<Integer, Set<Integer>> graph = buildGraph(pairs);
        char[] tmp = s.toCharArray();
        List<Character> listSort = new ArrayList<>();
        List<Integer> group;
        for (Integer key:graph.keySet()) {
            group = new ArrayList<>(graph.get(key));
            group.sort(Integer::compareTo);
            int listIndex = 0;
            for (Integer index:group) {
                listSort.add(tmp[index]);
            }
            listSort.sort(Character::compareTo);
            for (Integer index:group) {
                tmp[index] = listSort.get(listIndex++);
            }
            listSort.clear();
        }
        return String.valueOf(tmp);
    }
    public static void main(String[] args) {
        String S = "yhiihxbordwyjybyt";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> tmp;
        tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(9);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(5);
        tmp.add(11);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(9);
        tmp.add(7);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(2);
        tmp.add(7);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(14);
        tmp.add(16);
        pairs.add(tmp);

        tmp = new ArrayList<>();
        tmp.add(6);
        tmp.add(16);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(0);
        tmp.add(5);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(12);
        tmp.add(9);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(6);
        tmp.add(5);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(9);
        tmp.add(10);
        pairs.add(tmp);

        tmp = new ArrayList<>();
        tmp.add(4);
        tmp.add(7);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(3);
        tmp.add(2);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(10);
        tmp.add(1);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(3);
        tmp.add(15);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(12);
        tmp.add(4);
        pairs.add(tmp);

        tmp = new ArrayList<>();
        tmp.add(10);
        tmp.add(10);
        pairs.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(15);
        tmp.add(12);
        pairs.add(tmp);


        Solution1202 s = new Solution1202();
        System.out.println(s.smallestStringWithSwaps(S, pairs));

    }
}
