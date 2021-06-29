package Solution500_;

import java.util.*;

public class Solution773 {
    class Node{
        int[][] board;
        int step = 0;
        Node father = null;

        Node(){}

        Node(int[][] board){
            this.board = board;
        }

        Node(Node father, int preRow, int preCol, int row, int col){
            int[][] board = father.board;
            this.board = new int[board.length][];
            for (int i = 0; i < this.board.length; i++) {
                this.board[i] = board[i].clone();
            }
            int tmp = this.board[preRow][preCol];
            this.board[preRow][preCol] = this.board[row][col];
            this.board[row][col] = tmp;
            this.step = father.step + 1;
            this.father = father;
        }

        /**
         * @return 从当前状态出发，能够到达的所有可能状态
         */
        public Node[] getNext(){
            if (board == null)
                return new Node[0];
            int col = 0, row = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0){
                        row = i;
                        col = j;
                        break;
                    }
                }
            }

            List<Node> ret = new ArrayList<>();
            if (row > 0)
                ret.add(new Node(this, row, col, row - 1, col));
            if (col > 0)
                ret.add(new Node(this, row, col, row, col - 1));
            if (row < board.length - 1)
                ret.add(new Node(this, row, col, row + 1, col));
            if (col < board[0].length - 1)
                ret.add(new Node(this, row, col, row, col + 1));

            return ret.toArray(new Node[0]);
        }

        @Override
        //偷懒用IDEA的代码生成，记得不要用JDK7的模板
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return Arrays.deepEquals(board, node.board);

        }

        @Override
        public int hashCode() {
            return Arrays.deepHashCode(board);
        }
    }

    /**
     * 不想优化，这个是一个通用的，可以姐小规模的
     * @param board 2x3的板子，里面是0-5，且不能重复
     * @return 到达[[1,2,3],[4,5,0]需要的最少步数，若不能则返回-1
     */
    public int slidingPuzzle(int[][] board) {
        if (board == null)
            return -1;
        Node source = new Node(board);
        int[][] end = {{1,2,3},{4,5,0}};
        Node target = new Node(end);
        Set<Node> arrive = new HashSet<>();
        List<Node> quene = new ArrayList<>();
        quene.add(source);
        while (!quene.isEmpty()){
            source = quene.remove(0);
            if (arrive.contains(source))
                continue;
            arrive.add(source);
            if (source.equals(target))
                return source.step;
            Node[] nexts = source.getNext();
            Collections.addAll(quene, nexts);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {{1,2},{3,4}};
        int[][] board2 = {{1,2},{3,4}};
        System.out.println(Arrays.deepEquals(board,board2));
    }
}
