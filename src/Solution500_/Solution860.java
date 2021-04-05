package Solution500_;

public class Solution860 {

    public boolean lemonadeChange(int[] bills) {
        boolean ret = true;
        if (bills == null || bills.length == 0)
            return ret;
        int dollar5 = 0, dollar10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                dollar5 ++;
            else if (bills[i] == 10){
                dollar5 --;
                dollar10 ++;
            }else if (bills[i] == 20){
                dollar10 --;
                dollar5 --;
            }
            if (dollar10 < 0){
                dollar10 ++;
                dollar5 -= 2;
            }
            if (dollar5 < 0)
                return false;
        }
        return ret;
    }
}
