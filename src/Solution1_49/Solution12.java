package Solution1_49;

public class Solution12 {
    public String intToRoman(int num) {
        String numStr = String.valueOf(num);
        int digits = numStr.length();
        char currentNum;
        String romanChar = "IVXLCDM";
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < numStr.length(); i++) {
            currentNum = numStr.charAt(i);
            if (currentNum == '9' && digits < 4) {
                ret.append(romanChar.charAt(2*(digits-1)));
                ret.append(romanChar.charAt(2*digits));
            }else if (currentNum == '4' && digits < 4){
                ret.append(romanChar.charAt(2*(digits-1)));
                ret.append(romanChar.charAt(2*digits-1));
            }else if (currentNum - '5' >= 0){
                ret.append(romanChar.charAt(2*digits-1));
                for (int j = 0; j < currentNum-'5'; j++) {
                    ret.append(romanChar.charAt(2*digits-2));
                }
            }else {
                for (int j = 0; j < currentNum - '0'; j++) {
                    ret.append(romanChar.charAt(2*(digits-1)));
                }
            }
            digits--;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution12 s12 = new Solution12();
        System.out.println(s12.intToRoman(3));
    }
}
