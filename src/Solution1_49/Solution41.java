package Solution1_49;

public class Solution41 {
//    public int firstMissingPositive(int[] nums) {
//        if (nums.length == 0)
//            return 1;
//        int len = nums.length;
//        int tmp = Integer.MIN_VALUE;
//
//        if (nums[0] == nums.length){
//            tmp = nums[0];
//            nums[0] = nums[nums.length-1];
//            nums[nums.length-1] = tmp;
//        }
//        if (nums[len-1] == 1 && len != 1){
//            nums[0] = 1;
//            nums[len-1] = -1;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            tmp = nums[i];
//            if (tmp > 0 && tmp <= len)
//                nums[tmp-1] = 1;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            tmp = i;
//            if (nums[i] != 1)
//                return i+1;
//        }
//        return (tmp == len-1) ? len+1 : 1;
//    }

//    public int firstMissingPositive(int[] nums) {
//        if (nums.length == 0)
//            return 1;
//        int tmp = 0, index = 0, len = nums.length, count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (nums[i] < 0 || nums[i] > nums.length) ? 0 : nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            tmp = nums[i];
//            if (tmp > 0){
//                for (int j = index; j < i; j++) {
//                    if (nums[j] == 0){
//                        index = j;
//                        break;
//                    }
//                }
//                nums[(nums[index] == 0 ? index : i)] = nums[i];
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0){
//                len = i;
//                break;
//            }
//        }
//        index = 0;
//        while (count < len){
//            count ++;
//            tmp = nums[0];
//            nums[0] = nums[tmp-1];
//            nums[tmp-1] = -1;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            tmp = i;
//            if (nums[i] != -1)
//                return i+1;
//        }
//        return tmp == nums.length-1 ? nums.length+1 : 1;
//    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;
        if (nums.length == 1 && nums[0] == 1)
            return 2;
        boolean flag = false;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = nums[i];
            nums[i] = (tmp <= 0 || tmp > nums.length) ? 0 : tmp;
            flag = flag ? flag : nums[i] == nums.length;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            index = i;
            while (true){
                tmp = nums[index];
                if (tmp == nums.length)
                    break;
                if (tmp == index || tmp == 0 || tmp == nums[tmp])
                    break;
                nums[index] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        nums[nums[0] == nums.length ? 0 : nums[0]] = nums[0];
        tmp = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i)
                break;
            tmp = i;
        }
        return tmp == nums.length-1 && flag ? nums.length+1 : tmp+1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3,4,4};
        Solution41 s = new Solution41();
        System.out.println(s.firstMissingPositive(nums));
    }
}
