package Solution1_49;

import java.util.*;

public class Solution22 {
    public Set<String> generate(int n){
        Set<String> ret = new HashSet<>();
        StringBuffer tmp = new StringBuffer();
        for (int j = 0; j < n; j++) {
            tmp.append('(');
        }
        for (int j = 0; j < n; j++) {
            tmp.append(')');
        }
        ret.add(tmp.toString());
        tmp.delete(0,tmp.length());

        for (int i = 1; i < n; i++) {
            for (String s1:generate(i)) {
                for (String s2:generate(n-i)) {
                    ret.add(s1+s2);
                }
            }
        }
        return ret;
    }

    public Set<String> generate2(int n){
        Set<String> ret = new HashSet<>();
        List<Set<String>> tmp = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        if (n <= 0){
            ret.add("");
            return ret;
        }
        if (n == 1){
            ret.add("()");
            return ret;
        }
        for (int i = 1; i < n; i++) {
            tmp.add(generate2(i));
        }
        for (String s : generate2(n-1)){
            builder.append("(");
            builder.append(s);
            builder.append(")");
            ret.add(builder.toString());
            builder.delete(0,builder.length());
        }
        for (int i = 0; i < tmp.size(); i++) {
            for (String s1 : tmp.get(i)){
                for (String s2 : tmp.get(tmp.size()-i-1)){
                    ret.add(s1+s2);
                }
            }
        }

        return ret;
    }
    
    public List<String> generateParenthesis(int n) {
        Set<String> tmp = generate2(n);
        List<String> ret = new ArrayList<>(tmp);
        return ret;
    }

    public static void main(String[] args) {
        Solution22 s = new Solution22();
        System.out.println(s.generate2(4));
    }
}
