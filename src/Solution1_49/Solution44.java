package Solution1_49;

public class Solution44 {

    private boolean solution(String s, String p, int indexs, int indexp){
        boolean ret = false;
        while (indexs < s.length() && indexp < p.length()){
            while (indexp+1 < p.length() && p.charAt(indexp+1) == '*' && p.charAt(indexp) == '*')indexp ++;
            if (p.charAt(indexp) == '?'){
                indexs ++;
                indexp ++;
            }else if (p.charAt(indexp) == '*'){
                ret |= solution(s, p, indexs, indexp+1);
                indexs ++;
            }else if (p.charAt(indexp) == s.charAt(indexs)){
                indexp ++;
                indexs ++;
            } else {
                return ret;
            }
        }
        while (indexp < p.length() && p.charAt(indexp) == '*')indexp ++;

        return ret | (indexs == s.length() && indexp == p.length());
    }

    private int findStr(String s, String p, int offset){
        int ret = -1;
        int indexs = offset;
        for (int i = 0; i < p.length(); i++) {
            if (indexs >= s.length())
                break;
            if (s.charAt(indexs) == p.charAt(i) || p.charAt(i) == '?'){
                indexs ++;
            }else {
                indexs -= i-1;
                i = -1;
            }
        }
        return (s.charAt(--indexs) == p.charAt(p.length()-1)) ? indexs : ret;
    }

    private boolean solution2(String s, String p){
        int indexs = 0, indexleft = 0, indexright = 0;
        boolean flag = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*'){
                flag = false;
                continue;
            }
            if (p.charAt(i) == '?')
                indexs++;
            else if (s.charAt(indexs) == p.charAt(i) && flag){
                indexs++;
            } else {
                indexleft = i;
                indexright = findStr(p, "*", indexleft);
                indexright = indexright >= indexleft ? indexright : p.length();
                indexs = findStr(s, p.substring(indexleft, indexright), indexs) + 1;
                i = indexright-1;
            }
            if (indexs < 0)
                return false;
        }
        return indexs == s.length() || p.charAt(p.length()-1) == '*';
    }

    public boolean isMatch(String s, String p) {
        return solution2(s, p);
    }

    public static void main(String[] args) {


        String s = "acdcb",
                p = "a*c?b";
        Solution44 ss = new Solution44();
        System.out.println(ss.isMatch(s, p));
    }
}
