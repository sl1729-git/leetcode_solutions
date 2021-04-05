package Solution500_;

public class Solution1046 {
    private void swap(int[] nums, int a, int b){
        assert nums != null && nums.length > a && nums.length > b;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void adjust(int[] nums, int index, int len){
        int nextIndex;
        boolean flag = true;
        while (index < len){
            nextIndex = index * 2;
            if (nextIndex + 1 < len){
                if (nums[nextIndex] < nums[nextIndex + 1])
                    nextIndex ++;
            }
            if (nextIndex < len && nums[index] < nums[nextIndex])
                swap(nums, index, nextIndex);
            index = nextIndex;
        }
    }

    private int remove(int[] nums, int len){
        int ret = nums[1];
        nums[1] = nums[len];
        adjust(nums, 1, len);
        return ret;
    }

    private boolean add(int[] nums, int len, int num){
        if (len + 1 >= nums.length)
            return false;
        nums[len + 1] = num;
        int index = len + 1;
        while (index > 1){
            if (nums[index] > nums[index/2]) {
                swap(nums, index, index/2);
            }
            index = index/2;
        }
        return true;
    }

    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        int[] nums = new int[stones.length+1];
        for (int i = 0; i < stones.length; i++)
            nums[i + 1] = stones[i];
        for (int i = 0; i < len; i++) {
            add(nums, i, stones[i]);
        }
        int stoneA, stoneB;
        while (len > 1){
            stoneA = remove(nums, len--);
            stoneB = remove(nums, len--);
            if (stoneA == stoneB)
                continue;
            add(nums, len++, stoneA - stoneB);
        }
        return len == 0 ? 0 : nums[1];
    }

    public static void main(String[] args) {
        int[] stones = new int[]{434,667,378,919,212,902,240,257,208,996,411,222,557,
                634,425,949,755,833,785,886,40,159,932,157,764,916,85,300,130,278};
        Solution1046 s = new Solution1046();
        System.out.println(s.lastStoneWeight(stones));
    }
}
