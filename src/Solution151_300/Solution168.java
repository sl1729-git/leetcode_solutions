package Solution151_300;

public class Solution168 {
    /**
     *
     * @param columnNumber 需要转换的第i列列名
     * @return null，如果columnNumber小于等于0；Excel列命，如果columnNumber大于0
     */
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0)
            return null;
        int[] ret = new int[10];
        int size = 0;
        while (columnNumber > 0){
            ret[size] = (columnNumber - 1) % 26;
            columnNumber = (columnNumber - ret[size++]) / 26;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            builder.append((char) ('A' + ret[i]));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution168 s = new Solution168();
        System.out.println(s.convertToTitle(701));
    }
}
