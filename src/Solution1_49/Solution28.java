package Solution1_49;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int ret = -1;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            boolean flag = true;
            if (haystack.charAt(i) == needle.charAt(0)){
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)){
                        flag =false;
                        break;
                    }
                }
                if (flag){
                    ret = i;
                    break;
                }
            }
        }
        return ret;
    }
}
