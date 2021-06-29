package Solution500_;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution909 {
    /**
     * 我比较菜，所以就直接用广搜了
     * @param board 使用的棋盘
     * @return 到达棋盘最后一格使用的最少步数
     */
    public int snakesAndLadders(int[][] board) {
        int size = board.length * board[0].length;
        int[] boardInArray = new int[size + 1];
        int row = board.length - 1, col = 0, index = 1, step = 1;
        while (index < boardInArray.length){
            boardInArray[index++] = board[row][col];
            col += step;
            if (col < 0 || col >= board[0].length){
                row --;
                step = -step;
                col += step;
            }
        }

        int target = size;
        int current;
        boardInArray[1] = boardInArray[0] = boardInArray[size] = -1;
        boolean[] boardArrived = new boolean[boardInArray.length];
        List<Integer> quene = new ArrayList<>();
        quene.add(1);
        while (!quene.isEmpty()){
            current = quene.remove(0);
            if (boardArrived[current & 0xffff])
                continue;
            boardArrived[current & 0xffff] = true;
            if ((current & 0xffff) == target)
                return current >> 16;
            for (int i = 1; i < 7; i++) {
                int next = current + i + 0x10000;
                if ((next & 0xffff) > size)
                    continue;
                if (boardInArray[next & 0xffff] != -1){
                    next = (next & 0xffff0000) + boardInArray[next & 0xffff];
                }
                quene.add(next);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1},{-1,6,2,8}};
        Solution909 s = new Solution909();
        System.out.println(s.snakesAndLadders(board));
    }
}
