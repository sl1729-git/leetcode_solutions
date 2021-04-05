package Solution500_;

import java.util.*;
import java.util.stream.Collectors;

public class Solution870 {
    private int bsearch(List<Integer> list, int start, int end, int target){
        if (start >= end)
            return start;
        int mid = (start + end)/2;
        if (list.get(mid) < target)
            return bsearch(list, mid+1, end, target);
        else
            return bsearch(list, start, mid, target);
    }

    public int[] advantageCount(int[] A, int[] B) {
        assert A.length == B.length;
        int[] ret= new int[A.length];
        List<Integer> listA = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(B).boxed().collect(Collectors.toList());
        listA.sort(Integer::compareTo);
        listB.sort(Integer::compareTo);
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int indexALeft = 0, indexARight = A.length-1;
        int tmpA, tmpB;
        Queue<Integer> tmp;
        for (int i = B.length-1; i >= 0; i--) {
            tmpB = listB.get(i);
            tmpA = listA.get(indexARight);
            if (tmpA <= tmpB){
                tmpA = listA.get(indexALeft ++);
            }else {
                indexARight --;
            }
            if (map.containsKey(tmpB)){
                map.get(tmpB).add(tmpA);
            }else {
                tmp = new ArrayDeque<>();
                tmp.add(tmpA);
                map.put(tmpB, tmp);
            }
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i] = map.get(B[i]).remove();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,0,4,1,2};
        int[] B = new int[]{1,3,0,0,2};
        Solution870 s = new Solution870();
        System.out.println(s.advantageCount(A, B));
    }
}
