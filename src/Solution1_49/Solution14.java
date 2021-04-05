package Solution1_49;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        StringBuffer ret = new StringBuffer();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = minLength > strs[i].length() ? strs[i].length() : minLength;
        }
        char tmp = ' ';
        boolean sameHead = true;
        for (int i = 0; i < minLength; i++) {
            tmp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                sameHead &= tmp == strs[j].charAt(i);
            }
            if (sameHead) {
                ret.append(tmp);
            }else {
                break;
            }
        }
        return ret.toString();
    }
}
