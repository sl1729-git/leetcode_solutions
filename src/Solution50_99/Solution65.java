package Solution50_99;

public class Solution65 {

    /**
     * 判断当前指向的字符是否是数字
     * @param s
     * @param index
     * @return true，如果指向的是一个十进制的数
     */
    private boolean isDigital(char[] s, int index){
        char currentChar = index < s.length ? s[index] : '\0';
        return currentChar >= '0' && currentChar <= '9';
    }

    /**
     * 判断指向的是不是英文的'.'
     * @param s
     * @param index
     * @return
     */
    private boolean isDot(char[] s, int index){
        char currentChar = index < s.length ? s[index] : '\0';
        return currentChar == '.';
    }

    /**
     * 注意这里没有符号的数
     * @param s 待检测字符串
     * @param index 当前开始的位置
     * @return 返回从当前index开始，到第一个不是数字的index为止的index
     */
    private int getUintIndex(char[] s, int index){
        while (isDigital(s, index))
            index++;
        return index;
    }

    /**
     * 注意这里没有符号的
     * @param s 待检测的字符串
     * @param index 当前开始位置
     * @return 返回从当前index开始，能够最大长度的float数的index
     */
    private int getUfloatIndex(char[] s, int index){
        int startIndex = index;
        while (isDigital(s, index))
            index++;
        if (isDot(s, index))
            index++;
        while (isDigital(s, index))
            index++;
        return (startIndex + 1 == index && isDot(s, startIndex)) ? startIndex : index;
    }

    private int getIntIndex(char[] s, int index){
        if (index >= s.length)
            return index;
        int ret = index + (s[index] == '+' || s[index] == '-' ? 1 : 0);
        ret = getUintIndex(s, ret);
        return ((index + 1) == ret && !isDigital(s, index)) ? index : ret;

    }

    private int getFloatIndex(char[] s,int index){
        if (index >= s.length)
            return index;
        int ret = index + (s[index] == '+' || s[index] == '-' ? 1 : 0);
        ret = getUfloatIndex(s, ret);
        return ((index + 1) == ret && !isDigital(s, index)) ? index : ret;
    }

    /**
     * 检查输入的字符串是否是一个合规的数
     * @param s 一个待检查字符串
     * @return false，如果s为null或不是合规的数
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;
        char[] sChars = s.toCharArray();
        int currentIndex = 0;
        int check = currentIndex;
        currentIndex = getFloatIndex(sChars, currentIndex);
        if (check == currentIndex)
            return false;
        if (currentIndex == sChars.length)
            return true;
        if (sChars[currentIndex] == 'e' || sChars[currentIndex] == 'E'){
            check = currentIndex + 1;
            currentIndex = getIntIndex(sChars, check);
            return currentIndex == sChars.length && check != currentIndex;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution65 s = new Solution65();
        s.isNumber("+1e2");
        String[] tests = {"",".","+.","-.","..","12.","1",".1",".-1","+1e2","1.e2",".2e-2","e9","6+1","0e","e0"};
        for (String test:tests) {
            System.out.println(test+":"+s.isNumber(test));
        }
    }
}
