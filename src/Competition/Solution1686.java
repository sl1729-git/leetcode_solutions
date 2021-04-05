package Competition;

import java.util.*;
        /*Alice 和 Bob 轮流玩一个游戏，Alice 先手。

        一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方都知道对方的评判标准。

        给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。

        所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。

        请你推断游戏的结果，用如下的方式表示：

        如果 Alice 赢，返回 1 。
        如果 Bob 赢，返回 -1 。
        如果游戏平局，返回 0 。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/stone-game-vi
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution1686 {
    private int take(List<int[]> valueList, List<int[]> valueList2, boolean[] cantake, int[] values){
        if (valueList == null || valueList.isEmpty())
            return 0;
        int[] tmp = new int[]{0,-1}, tmp2 = new int[]{0,-1};
        while (!valueList.isEmpty()){
            tmp = valueList.get(0);
            if (!cantake[tmp[1]])
                valueList.remove(0);
            else
                break;
        }
        while (!valueList2.isEmpty()){
            tmp2 = valueList2.get(0);
            if (!cantake[tmp2[1]])
                valueList2.remove(0);
            else
                break;
        }
        if (tmp[1] == -1)
            return 0;
        if (tmp2[1] == -1){
            cantake[tmp[1]] = false;
            valueList.remove(0);
            return tmp[0];
        }
        while (true){
            if (tmp2[0] > tmp[0]){
                valueList2.remove(0);
                cantake[tmp2[1]] = false;
                return values[tmp2[1]];
            }else {
                valueList.remove(0);
                cantake[tmp[1]] = false;
                return tmp[0];
            }
        }
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        List<int[]> alice = new ArrayList<>();
        List<int[]> bob = new ArrayList<>();

        int[] tmp;
        for (int i = 0; i < aliceValues.length; i++) {
            tmp = new int[]{aliceValues[i],i};
            alice.add(tmp);
            tmp = new int[]{bobValues[i],i};
            bob.add(tmp);
        }
        alice.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        bob.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        boolean[] canTake = new boolean[aliceValues.length];
        Arrays.fill(canTake, true);
        boolean aliceTurn = true;
        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < aliceValues.length; i++) {
            if (aliceTurn)
                aliceScore += take(alice, bob, canTake, aliceValues);
            else
                bobScore += take(bob, alice, canTake, bobValues);
            aliceTurn = !aliceTurn;
        }
        return Integer.compare(aliceScore, bobScore);
    }

    public static void main(String[] args) {
        int[] alice = new int[]{2,9,1,1,1,3,5,8,8,6,8,6,2,4};
        int[] bob = new int[]{1,9,7,8,3,4,2,7,8,10,1,7,10,4};
        Solution1686 s = new Solution1686();
        System.out.println(s.stoneGameVI(alice, bob));
    }
}
