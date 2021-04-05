public class Solution204 {
    private boolean isPrime(boolean[] tmp, int num){
        for (int i = 2; i < num; i++) {
            if (tmp[i]){
                if (num%i == 0)
                    return false;
            }
        }
        return true;
    }

    private boolean isPrime(int[] nums, int num){
        for (int i = 1; i <= nums[0]; i++) {
            if (num % nums[i] == 0)
                return false;
            if (nums[i]*nums[i] > num)
                break;
        }
        return true;
    }

    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        boolean[] nums = new boolean[n+5];
        int[] primes = new int[n/2+3];
        int ret = 0;
        nums[2] = true;
        nums[3] = true;
        for (int i = 7; i < nums.length; i+=6) {
            nums[i-2] = isPrime(primes, i-2);
            nums[i] = isPrime(primes, i);
            if (nums[i-2])
                primes[++primes[0]] = i-2;
            if (nums[i])
                primes[++primes[0]] = i;
        }
        for (int i = 0; i < n; i++) {
            ret += nums[i] ? 1 : 0;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution204 s = new Solution204();
        System.out.println(s.countPrimes(499979));
    }
}
