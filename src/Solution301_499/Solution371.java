package Solution301_499;

public class Solution371 {
    /**
     * 方式很简单，首先我们需要先证明，补码的求和运算结果的表示与
     * 补码表示求和并截取掉最高位结果进行求和是一样的
     *
     * 然后我们就可以视为原码的进行求和，首先就是先找出进位的部分
     * 这个用a&b可以算出，然后就是不考虑进位的结果，这个是a^b
     *
     * 那么有了进位就需要继续加上进位的部分，也就是再调用getSum(a^b,(a&b)<<1)
     * 即可，这里是使用循环的方式完成的
     *
     * @param a 求和计算的输入一
     * @param b 求和计算的输入二
     * @return a+b
     */
    public int getSum(int a, int b) {
        int ret = a ^ b;
        b = a & b;
        while (b != 0){
            a = ret;
            ret ^= (b << 1);
            b = a & (b << 1);
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution371 s = new Solution371();
        System.out.println(s.getSum(0,0));
    }
}
