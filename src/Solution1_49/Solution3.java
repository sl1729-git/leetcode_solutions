package Solution1_49;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        String s = "abcdaabcde";
        Solution3 s3 = new Solution3();
        System.out.printf("Out:%d\r\n",s3.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int current_max_len = 0;
        int min_index = -1;
        int[] flags = new int[256];
        Arrays.fill(flags,-1);
        // s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (flags[tmp] >= 0){
                ret = (ret < current_max_len) ? current_max_len : ret;
                min_index = flags[tmp];
                for (int j = 0; j < flags.length; j++) {
                    flags[j] = (flags[j] < min_index) ? -1 : flags[j];
                }
                current_max_len = i - min_index;
                flags[tmp] = i;
            }else {
                flags[tmp] = i;
                current_max_len ++;
            }
        }
        return (ret < current_max_len) ? current_max_len : ret;
    }
}
