public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        int stackdeep = 0;
        preorder = preorder + ",";
        for (int i = 0; i < preorder.length(); i++) {
            if (preorder.charAt(i) == '#') {
                stackdeep --;
                i ++;
            }
            else {
                while (preorder.charAt(i) != ',')
                    i ++;
                if (stackdeep < 0)
                    return false;
                stackdeep ++;
            }
        }
        return stackdeep == -1;
    }
}
