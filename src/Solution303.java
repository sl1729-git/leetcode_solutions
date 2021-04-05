public class Solution303 {

}

class NumArray {
    private int[] numArray = new int[1];

    public NumArray(int[] nums) {
        numArray = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            numArray[i] = sum;
            sum += nums[i];
        }
        numArray[nums.length] = sum;
    }

    public int sumRange(int i, int j) {
        return numArray[j+1] - numArray[i];
    }
}