package Solution500_;

import java.util.ArrayList;
import java.util.List;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp;
        int index = 2, start = -1, end = -1;
        if (s == null || s.length() <= 2)
            return ret;
        while (index < s.length()){
            if (s.charAt(index - 2) == s.charAt(index - 1) &&
                s.charAt(index -1) == s.charAt(index)){
                start = index - 2;
                while (index < s.length() && s.charAt(index) == s.charAt(index-1))
                    index++;
                end = index - 1;
                tmp = new ArrayList<>();
                tmp.add(start);
                tmp.add(end);
                ret.add(tmp);
            }else
                index ++;
        }
        return ret;
    }
}
