package Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution17_11 {
    private String[] preWords = null;
    private Map<String, int[]> preWordsIndex = new HashMap<>();

    private void build(String[] words){
        if(preWords == words){
            return ;
        }

        preWords = words;
        preWordsIndex.clear();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int[] indexs = preWordsIndex.getOrDefault(word, new int[10]);
            int index = indexs[0] + 1;
            if (indexs[indexs.length - 1] != 0){
                indexs = Arrays.copyOf(indexs, indexs.length * 2);
            }
            indexs[index] = i;
            indexs[0] ++;
            preWordsIndex.put(word, indexs);
        }
    }

    private int getDistance(int[] source, int[] target){
        int ret = Integer.MAX_VALUE;
        int sourceLength = source[0] + 1, targetLength = target[0] + 1;
        int leftIndex = 1, rightIndex = 1;
        int left = 0, right = 0;
        while (leftIndex < sourceLength && rightIndex < targetLength){
            left = source[leftIndex];
            right = target[rightIndex];
            if (left == right)
                return 0;
            else if (left < right)
                leftIndex ++;
            else
                rightIndex ++;
            ret = Math.min(Math.abs(right - left), ret);
        }
        return ret;
    }

    /**
     * 慢的离谱，我就简单写了，其实就是很简单的便利就好，每次找到单词后，就更新单词的索引，然后做差取最小
     *
     * 优化注意对外提供的接口是一个函数，所以我们不能假设新一次的查询和旧查询使用同样的words列表
     * 所以要暂存一份指向单词列表的记录，每次build都查看是否有变化，无变化则直接返回
     *
     * 这锅属于是接口设计的
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        build(words);
        int[] word1Index = preWordsIndex.getOrDefault(word1, null);
        int[] word2Index = preWordsIndex.getOrDefault(word2, null);
        if (word1Index == null || word2Index == null)
            return -1;
        return getDistance(word1Index, word2Index);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a", word2 = "student";
        Solution17_11 solution = new Solution17_11();
        System.out.println(solution.findClosest(words, word1, word2));
    }
}
