package Solution500_;

public class Solution738 {
    public int solutionWrong(int N) {
        assert N >= 0;
        if (N < 10)
            return N;
        String num = String.valueOf(N);
        int[] minAfterNumDigtail = new int[num.length()];
        minAfterNumDigtail[minAfterNumDigtail.length-1] = num.charAt(minAfterNumDigtail.length-1) - '0';
        for (int i = minAfterNumDigtail.length-2; i >= 0; i--) {
            minAfterNumDigtail[i] = (num.charAt(i)-'0') < minAfterNumDigtail[i+1] ? (num.charAt(i)-'0') : minAfterNumDigtail[i+1];
        }
        StringBuffer ret = new StringBuffer();
        int currentNum = num.charAt(0) - '0';
        boolean isFull = false;
        for (int i = 0; i < minAfterNumDigtail.length-1; i++) {
            if (currentNum > minAfterNumDigtail[i] && currentNum > 1) {
                ret.append(currentNum-1);
                for (int j = i+1; j < minAfterNumDigtail.length; j++)
                    ret.append(9);
                isFull = true;
                break;
            }
            else if (currentNum <= minAfterNumDigtail[i])
                ret.append(currentNum);
            currentNum = num.charAt(i+1) - '0';
        }
        if (!isFull)
            ret.append((num.charAt(num.length()-1)));

        return Integer.valueOf(ret.toString());
    }

    public int monotoneIncreasingDigits(int N) {
        assert N >= 0;
        if (N < 10)
            return N;
        String num = String.valueOf(N);
        StringBuffer ret = new StringBuffer();
        int left = 0, right = 1;
        while (right < num.length()){
            if (num.charAt(left) < num.charAt(right)) {
                while (left < right)
                    ret.append(num.charAt(left++));
                right++;
            }else if (num.charAt(left) == num.charAt(right))
                right++;
            else {
                ret.append((char)(num.charAt(left)-1));
                for (int i = left+1; i < num.length(); i++)
                    ret.append(9);
                return Integer.valueOf(ret.toString());
            }
        }
        while (left < right)
            ret.append(num.charAt(left++));
        return Integer.valueOf(ret.toString());
    }

    public static void main(String[] args) {
        Solution738 s = new Solution738();
        System.out.println(s.monotoneIncreasingDigits(556205));
    }
}
