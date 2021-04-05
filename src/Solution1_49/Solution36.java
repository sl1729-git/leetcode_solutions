package Solution1_49;

import java.util.Arrays;

public class Solution36 {
    private int[][] transfer(char[][] board){
        int[][] ret = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ret[i][j] = board[i][j] == '.' ? -1 : board[i][j]-'1';
            }
        }
        return ret;
    }

    private boolean checkRow(int[][] board){
        boolean[] checkFlag = new boolean[board[0].length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(checkFlag, false);
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1)
                    continue;
                if (checkFlag[board[i][j]])
                    return false;
                checkFlag[board[i][j]] = true;
            }
        }
        return true;
    }

    private boolean checkCol(int[][] board){
        boolean[] checkFlag = new boolean[board.length];
        for (int i = 0; i < board[0].length; i++) {
            Arrays.fill(checkFlag, false);
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == -1)
                    continue;
                if (checkFlag[board[j][i]])
                    return false;
                checkFlag[board[j][i]] = true;
            }
        }
        return true;
    }

    private boolean checkCell(int[][] board){
        boolean[] checkFlag = new boolean[9];
        int indexRow, indexCol;
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[0].length; j+=3) {
                Arrays.fill(checkFlag, false);
                for (indexRow = 0; indexRow < 3; indexRow++){
                    for (indexCol = 0; indexCol < 3; indexCol++){
                        if (board[i+indexRow][j+indexCol] == -1)
                            continue;
                        if (checkFlag[board[i+indexRow][j+indexCol]])
                            return false;
                        checkFlag[board[i+indexRow][j+indexCol]] = true;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] tmp = transfer(board);
        return checkRow(tmp) && checkCol(tmp) && checkCell(tmp);
    }

    public static void main(String[] args) {

    }
}
