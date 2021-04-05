import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution316 {
    public String solutionWrong(String s) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer ret = new StringBuffer();
        List<Character> charList = new ArrayList<>();
        if (s == null || s.length() == 1)
            return s;
        int left = 0, right = 0;
        int[] charCount = new int[256];
        for (int i = 0; i < s.length(); i++)
            charCount[s.charAt(i)&0xff] ++;
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0)
                charList.add((char)i);
        }
        int chatTmp = 0;
        for (int i = 0; i < s.length(); i++) {
            chatTmp = s.charAt(i)&0xff;

            charCount[chatTmp] --;
            if (charCount[chatTmp] == 0){
                buffer.append(s.charAt(i));
                charList.remove(Character.valueOf(s.charAt(i)));
                for (right = i-1; right >= left; right--) {
                    if (s.charAt(right) < chatTmp && charCount[s.charAt(right)&0xff] > 0) {
                        buffer.append(s.charAt(right));
                        charCount[s.charAt(right)&0xff] = -1;
                        charList.remove(Character.valueOf(s.charAt(right)));
                        chatTmp = s.charAt(right)&0xff;
                    }
                }
                ret.append(buffer.reverse());
                buffer.delete(0,buffer.length());
                left = i + 1;
            }else if (charList.size() > 0 && chatTmp == charList.get(0) && charCount[chatTmp] > 0){
                ret.append(s.charAt(i));
                left = i + 1;
                charCount[chatTmp] = -1;
                charList.remove(0);
            }
        }
        return ret.toString();
    }

    public String solutionWrong2(String s) {
        char[] stack = new char[256];
        int[] charCoumt = new int[256];
        int stackSize = 0, index = 0;
        boolean[] stackContain = new boolean[256];
        Arrays.fill(stackContain, false);
        for (int i = 0; i < s.length(); i++) {
            charCoumt[s.charAt(i)&0xff] ++;
        }
        while (index < s.length()){
            charCoumt[s.charAt(index)&0xff] --;
            if (stackSize == 0 || charCoumt[s.charAt(index)] == 0 || s.charAt(index) > stack[stackSize-1]) {
                while (stackSize > 0 && s.charAt(index) < stack[stackSize-1] &&
                        charCoumt[stack[stackSize-1]&0xff] != 0)
                    stackSize--;
                stackContain[s.charAt(index)] = true;
                stack[stackSize++] = s.charAt(index++);
            }
            else if (s.charAt(index) < stack[stackSize-1] && !stackContain[s.charAt(index)]){
                while (stackSize > 0 && s.charAt(index) < stack[stackSize-1] &&
                charCoumt[stack[stackSize-1]&0xff] != 0)
                    stackSize--;
                stackContain[s.charAt(index)] = true;
                stack[stackSize++] = s.charAt(index++);
            }else
                index++;

        }
        return new String(stack, 0, stackSize);
    }

    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "mitnlruhznjfyzmtmfnstsxwktxlboxutbic";
        Solution316 s = new Solution316();
        System.out.println(s.removeDuplicateLetters(S));
    }
}
