package Solution1_49;

import java.util.Arrays;

public class Solution43 {

    private void plus(char[] in1, char[] in2, char[] out){
        int len = Math.min(in1.length, in2.length);
        int indexIn1 = in1.length-1, indexIn2 = in2.length-1, indexOut = out.length-1;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            out[indexOut-i] = (char) (in1[indexIn1-i] + in2[indexIn2-i]);
            if (flag)
                out[indexOut-i]++;
            flag = out[indexOut-i] >= 10;
            out[indexOut-i] = (char) (out[indexOut-i] % 10);
        }
        out[indexOut-len] += flag ? 1 :0;
    }

    private void mult(char[] in, int num, char[] out, int offset){
        assert num < 10 && offset >= 0;
        int indexIn = in.length-1, indexOut = out.length-1;
        int flag = 0;
        for (int i = 0; i < in.length; i++) {
            out[indexOut-i-offset] = (char)(in[indexIn-i] * num);
            out[indexOut-i-offset] += flag;
            flag = out[indexOut-i-offset]/10;
            out[indexOut-i-offset] = (char) (out[indexOut-i-offset]%10);
        }
        out[indexOut-in.length-offset] += flag;
    }

    public String multiply(String num1, String num2) {
        String swapTmp = num1;
        num1 = (num1.length() > num2.length()) ? num1 : num2;
        num2 = (num1 == num2) ? swapTmp : num2;
        char[] tmp = new char[num1.length() + num2.length() + 1];
        char[] num1Char = num1.toCharArray(), num2Char = num2.toCharArray();
        char[] ret = new char[num1.length() + num2.length() + 2];
        Arrays.fill(ret,(char)0);
        for (int i = 0; i < num1Char.length; i++) {
            num1Char[i] -= '0';
        }
        for (int i = 0; i < num2Char.length; i++) {
            num2Char[i] -= '0';
        }
        for (int i = 0; i < num2Char.length; i++) {
            Arrays.fill(tmp, (char) 0);
            mult(num1Char, num2Char[num2Char.length-i-1], tmp, i);
            plus(tmp, ret, ret);
        }
        int zeroNum = 0;
        for (int i = 0; i < ret.length; i++) {
            zeroNum += ret[i] == 0 ? 1 : 0;
            if (ret[i] != 0)
                break;
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i] += '0';
        }
        zeroNum -= (zeroNum == ret.length) ? 1 : 0;
        return String.valueOf(ret).substring(zeroNum);
    }

    public static void main(String[] args) {
        Solution43 s = new Solution43();
        String num1 = "0", num2 = "0";
        System.out.println(s.multiply(num1, num2));
    }
}
