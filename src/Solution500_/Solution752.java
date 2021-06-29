package Solution500_;

import Solution50_99.Solution75;

import java.util.*;

public class Solution752 {

    private static int[] NEXT = new int[]{0x0001,0x0010,0x0100,0x1000};

    /**
     *
     * @param state 长度为4的且每一个字符只能是0到9
     * @return 编码为step::state，step表示使用步数，state为每4位编码一位
     */
    private int str2int(String state){
        char[] tmp = state.toCharArray();
        return (tmp[0] - '0' << 12) + (tmp[1] - '0' << 8) + (tmp[2] - '0' << 4) + (tmp[3] - '0');
    }

    /**
     *
     * @param current 当前的状态
     * @return 从当前状态进入的所有下一状态
     */
    private int[] getNEXT(int current){
        int[] ret = new int[8];
        ret[0] = (current & 0xf) == 9 ? (current & 0xfffffff0) : (current + NEXT[0]);
        ret[1] = ((current >> 4) & 0xf) == 9 ? (current & 0xffffff0f) : (current + NEXT[1]);
        ret[2] = ((current >> 8) & 0xf) == 9 ? (current & 0xfffff0ff) : (current + NEXT[2]);
        ret[3] = ((current >> 12) & 0xf) == 9 ? (current & 0xffff0fff) : (current + NEXT[3]);

        ret[4] = (current & 0xf) == 0 ? (current + 0x0009) : (current - NEXT[0]);
        ret[5] = ((current >> 4) & 0xf) == 0 ? (current + 0x0090) : (current - NEXT[1]);
        ret[6] = ((current >> 8) & 0xf) == 0 ? (current + 0x0900) : (current - NEXT[2]);
        ret[7] = ((current >> 12) & 0xf) == 0 ? (current + 0x9000) : (current - NEXT[3]);

        for (int i = 0; i < ret.length; i++) {
            ret[i] += 0x10000;
        }

        return ret;
    }

    /**
     *
     * @param deadends 不可以处于的状态
     * @param target 目标状态
     * @return 从0000到目标状态所需要的最小步数
     */
    public int openLock(String[] deadends, String target) {
        if (target == null)
            return -1;
        //将不可以进入的状态编码
        deadends = deadends == null ? new String[0] : deadends;
        Set<Integer> deadstep = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadstep.add(str2int(deadends[i]));
        }

        //如果一开始的状态就不可以有，那就不可能到目标状态
        if (deadstep.contains(0))
            return -1;

        //广搜的队列
        List<Integer> quene = new ArrayList<>();
        //避免重复到达的计算
        Set<Integer> arrived = new HashSet<>();
        arrived.add(0);
        int current = 0;
        int targetInt = str2int(target);
        int state = 0;
        quene.add(0);
        while (!quene.isEmpty()){
            current = quene.remove(0);
            if ((current & 0xffff) == targetInt)
                return (current >> 16);
            int[] nexts = getNEXT(current);
            for (int next:nexts) {
                state = next & 0xffff;
                if (deadstep.contains(state) || arrived.contains(state))
                    continue;
                quene.add(next);
                arrived.add(state);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution752 s = new Solution752();
        String[] deadend = new String[]{"8888"};
        String target = "0009";
        System.out.println(s.openLock(deadend, target));
    }
}
