package Solution151_300;

public class Solution263 {
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;

        while (n > 1 && n % 2 == 0) n /= 2;
        while (n > 1 && n % 3 == 0) n /= 3;
        while (n > 1 && n % 5 == 0) n /= 5;

        return n == 1;
    }
}
