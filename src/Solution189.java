import java.math.BigInteger;

public class Solution189 {
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int gcd(int a, int b){
        return b > 0 ? gcd(b, a % b) : a;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int pass = gcd(len, k);
        int tmp, next;
        for (int start = 0; start < pass; start++) {
            int current = start, prev = nums[start];
            do {
                next = (current + k) % len;
                tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                current = next;
            }while (current != start);
        }
    }

    public void SolutionWrong(int[] nums, int k) {
        k = k % nums.length;
        int index = 0, diff = 0;
        if (k == 0)
            return;
        if (k >= nums.length/2){
            diff = nums.length-k;
            while (index < nums.length){
                for (int i = index+diff; i > index; i--) {
                    swap(nums, i, i + diff);
                }
                index += diff;
            }
        }else {
            diff = k;
            index = nums.length - 1;
            while (index >= 0){
                for (int i = index - diff; i < index; i++) {
                    swap(nums, i, i + diff);
                }
                index -= diff;
            }
        }
    }
}
