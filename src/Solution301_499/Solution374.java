package Solution301_499;

class GuessGame{
    private int num = 3;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    int guess(int num){
        return -Integer.compare(num, this.num);
    }
}


public class Solution374 extends GuessGame{
    /**
     * 注意这里要注意int一旦超出范围溢出会是负数的问题，所以先左移后相加
     * @param n 猜数的范围上线
     * @return 猜数的结果
     */
    public int guessNumber(int n) {
        int left = 0, right = n;
        while (left <= right){
            //算法导论貌似有相关的说明，一个正确无bug的二分搜索
            //之所以这么麻烦就是因为不允许使用更大的范围
            //没记错算法导论的更优美
            int guess = (left / 2 + right / 2) + (((left & 1) == 1) && ((right & 1) == 1) ? 1 : 0);
            int result = guess(guess);
            if (result == 0)
                return guess;
            else if (result < 0)
                right = guess - 1;
            else
                left = guess + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution374 s = new Solution374();
        s.setNum(1702766719);
        System.out.println(s.guessNumber(2126753390));
    }
}
