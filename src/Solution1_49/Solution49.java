package Solution1_49;

import java.util.*;

public class Solution49 {
    class CharCount{
        int[] count = new int[26];

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharCount charCount = (CharCount) o;
            return Arrays.equals(count, charCount.count);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(count);
        }
    }

    private CharCount string2int(String s){
        CharCount ret = new CharCount();
        for (int i = 0; i < s.length(); i++) {
            ret.count[s.charAt(i)-'a']++;
        }
        return ret;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<CharCount,List<String>> tmp = new HashMap<>();
        List<String> tmp2;
        CharCount key;
        for (int i = 0; i < strs.length; i++) {
            key = string2int(strs[i]);
            if (tmp.containsKey(key)){
                tmp.get(key).add(strs[i]);
            }else {
                tmp2 = new ArrayList<>();
                tmp2.add(strs[i]);
                tmp.put(key,tmp2);
            }
        }
        List<List<String>> ret = new ArrayList<>();
        for (CharCount aKey:tmp.keySet()) {
            ret.add(tmp.get(aKey));
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tan"};
        Solution49 s = new Solution49();
        System.out.println(s.groupAnagrams(strs));
    }
}
