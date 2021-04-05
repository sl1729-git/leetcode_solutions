package Solution1_49;

public class Solution6 {

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuffer ret = new StringBuffer();
        int loop = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while(index < s.length()){
                ret.append(s.charAt(index));
                if (0 < i && i < numRows - 1 && index + (loop - i) - i < s.length()){
                    ret.append(s.charAt(index + (loop - 2 * i)));
                }
                index += loop;
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Solution6 s6 = new Solution6();
        String s = "PAYPALISHIRING";
        s6.convert(s,3);
    }
}
