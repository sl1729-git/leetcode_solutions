package Solution500_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution839 {
    class UnionFind{
        private int[] father;
        private int[] rank;

        public UnionFind(int n){
            assert n >= 0;
            father = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 0);
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int x){
            return (x == father[x]) ? x : (father[x] = find(father[x]));
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return false;

            if (rank[rootX] < rank[rootY])
                father[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                father[rootY] = rootX;
            else {
                father[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }
    }

    private boolean checkAnagram(String a, String b){
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            diffCount += (a.charAt(i) == b.charAt(i)) ? 0 : 1;
            if (diffCount > 2)
                break;
        }
        return diffCount <= 2;
    }

    public int numSimilarGroups(String[] strs) {
        UnionFind union = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (union.find(i) == union.find(j))
                    continue;
                if (checkAnagram(strs[i], strs[j]))
                    union.union(i, j);
            }
        }

        Set<Integer> group = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            group.add(union.find(i));
        }

        return group.size();
    }
}
