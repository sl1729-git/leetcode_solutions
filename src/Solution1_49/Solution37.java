package Solution1_49;

import java.util.*;

public class Solution37 {
    static private int BOARDLEN = 9;
    static private int BLOCKLEN = 3;

    private class Node implements Cloneable{
        char[][] currentBoard;
        int currentBlank = BOARDLEN * BOARDLEN;
        boolean[][][] char2Choose = new boolean[BOARDLEN][BOARDLEN][BOARDLEN];
        int[][] char2ChooseLeft = new int[BOARDLEN][BOARDLEN];
        boolean[][][] hasSearchLeft = new boolean[BOARDLEN][BOARDLEN][BOARDLEN];
        int[][] hasSearchLeftChoose = new int[BOARDLEN][BOARDLEN];
        boolean isSolution = false;
        List<Node> child = new ArrayList<>();
        Node father = null;

        public Node(){

        }

        public Node(char[][] currentBoard) {
            this.currentBoard = currentBoard;
            for (int i = 0; i < BOARDLEN; i++) {
                Arrays.fill(char2ChooseLeft[i], 9);
                for (int j = 0; j < BOARDLEN; j++) {
                    Arrays.fill(char2Choose[i][j],true);
                }
            }
            for (int i = 0; i < BOARDLEN; i++) {
                for (int j = 0; j < BOARDLEN; j++) {
                    if (currentBoard[i][j] != '.'){
                        markSearchNode(j, i, currentBoard[i][j]-'0', char2Choose, char2ChooseLeft);
                        char2ChooseLeft[i][j] = -1;
                        currentBlank --;
                        // todo:这里要有一致性，不过貌似解题不需要也能work
                    }
                }
            }
            hasSearchLeft = char2Choose.clone();
            hasSearchLeftChoose = char2ChooseLeft.clone();
        }

        private void refresh(int col, int row, int num){
            num --; // num is 1-BOARDLEN but as index should be 0-(BOARDLEN-1)
            assert col < BOARDLEN && row < BOARDLEN && num < BOARDLEN;
            if (!char2Choose[row][col][num])
                return;
            currentBoard[row][col] = (char) ('1' + num);
            currentBlank --;
            markSearchNode(col, row, num+1, char2Choose, char2ChooseLeft);
            markSearchNode(col, row, num+1, hasSearchLeft, hasSearchLeftChoose);
        }

        private int index2int(int col, int row, int num){
            return (row << 16)| (col << 8) | num;
        }

        private int[] int2index(int info){
            int[] ret = new int[3];
            ret[0] = ((info & 0xff0000) >> 16); //row
            ret[1] = ((info & 0xff00) >> 8);    //col
            ret[2] = info & 0xff;               //num
            return ret;
        }

        private int findMinChoose(boolean[][][] hasSearchLeft, int[][] hasSearchLeftChoose){
            int col = -1, row = -1, num = -1, ret;
            int minChoose = Integer.MAX_VALUE;
            for (int i = 0; i < BOARDLEN; i++) {
                for (int j = 0; j < BOARDLEN; j++) {
                    if (minChoose > hasSearchLeftChoose[i][j] && hasSearchLeftChoose[i][j] > 0){
                        row = i;
                        col = j;
                        minChoose = hasSearchLeftChoose[i][j];
                    }
                }
            }
            if (row >= 0 && col >= 0) {
                for (int i = 0; i < BOARDLEN; i++) {
                    num = hasSearchLeft[row][col][i] ? i : num;
                }
            }
            ret = index2int(col, row, num+1);
            if (minChoose > BOARDLEN) {
                isSolution = true;
                return -1;
            }
            if (num < 0)
                return -1;
            return ret;
        }

        public void fullFresh(){
            int indexTmp = findMinChoose(char2Choose, char2ChooseLeft);
            int[] tmp = int2index(indexTmp);
            while (indexTmp > 0 && char2ChooseLeft[tmp[0]][tmp[1]] == 1){
                refresh(tmp[1], tmp[0], tmp[2]);
                markSearchNode(tmp[1], tmp[0], tmp[2], char2Choose, char2ChooseLeft);
                indexTmp = findMinChoose(char2Choose, char2ChooseLeft);
                tmp = int2index(indexTmp);
            }
        }

        private void markSearchNode(int col, int row, int num, boolean[][][] char2Choose, int[][] char2ChooseLeft){
            num --;
            for (int i = 0; i < BOARDLEN; i++) {
                char2ChooseLeft[row][i] -= char2Choose[row][i][num] ? 1 : 0;
                char2Choose[row][i][num] = false;
                char2ChooseLeft[i][col] -= char2Choose[i][col][num] ? 1 : 0;
                char2Choose[i][col][num] = false;

            }
            int blockIndexRow = (row/BLOCKLEN)*BLOCKLEN, blockIndexCol = (col/BLOCKLEN)*BLOCKLEN;
            for (int i = 0; i < BLOCKLEN; i++) {
                for (int j = 0; j < BLOCKLEN; j++) {
                    char2ChooseLeft[blockIndexRow + i][blockIndexCol + j] -=
                            char2Choose[blockIndexRow + i][blockIndexCol + j][num] ? 1 : 0;
                    char2Choose[blockIndexRow + i][blockIndexCol + j][num] = false;
                }
            }
        }

        private boolean[][][] copyBoolean(boolean[][][] in){
            boolean[][][] ret = new boolean[in.length][][];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = new boolean[in[i].length][];
                for (int j = 0; j < ret[i].length; j++) {
                    ret[i][j] = in[i][j].clone();
                }
            }
            return ret;
        }

        private int[][] copyInt(int[][] in){
            int[][] ret = new int[in.length][];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = in[i].clone();
            }
            return ret;
        }

        private char[][] copyChar(char[][] in){
            char[][] ret = new char[in.length][];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = in[i].clone();
            }
            return ret;
        }

        public Node next(){
            int indexTmp = findMinChoose(hasSearchLeft, hasSearchLeftChoose);
            if (indexTmp < 0)
                return null;
            int[] tmp = int2index(indexTmp);
            Node nextNode = new Node();
            nextNode.currentBoard = copyChar(currentBoard);
            nextNode.char2Choose = copyBoolean(char2Choose);
            nextNode.char2ChooseLeft = copyInt(char2ChooseLeft);
            nextNode.hasSearchLeftChoose = copyInt(hasSearchLeftChoose);
            nextNode.hasSearchLeft = copyBoolean(hasSearchLeft);
            nextNode.currentBlank = currentBlank;
            nextNode.father = this;
            nextNode.refresh(tmp[1], tmp[0], tmp[2]);
            this.child.add(nextNode);
            nextNode.char2ChooseLeft[tmp[0]][tmp[1]] = -1;
            markSearchNode(tmp[1], tmp[0], tmp[2], hasSearchLeft, hasSearchLeftChoose);
            markSearchNode(tmp[1], tmp[0], tmp[2], char2Choose, char2ChooseLeft);
            return nextNode;
        }


    }

    public void solveSudoku(char[][] board) {
        Node root = new Node(board);
        Node tmp = root;
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0 && tmp != null){
            root = queue.remove(0);
            root.fullFresh();
            if (root.isSolution && root.currentBlank == 0)
                break;
            else{
                tmp = root.next();
                while (tmp == null){

                    root = root.father;
                    if (root == null)
                        break;
                    root.fullFresh();
                    if (root.isSolution && root.currentBlank == 0)
                        tmp = root;
                    tmp = root.next();
                }
                queue.add(tmp);
            }
        }
        board = root.currentBoard;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','.','2','.','.','.','6','3'},
                {'3','.','.','.','.','5','4','.','1'},
                {'.','.','1','.','.','3','9','8','.'},
                {'.','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','3','8','.','.','.'},
                {'.','3','.','.','.','.','.','.','.'},
                {'.','2','6','3','.','.','5','.','.'},
                {'5','.','3','7','.','.','.','.','8'},
                {'4','7','.','.','.','1','.','.','.'},
        };
        Solution37 s = new Solution37();
        s.solveSudoku(board);
    }
}
