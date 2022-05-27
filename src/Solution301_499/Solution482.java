package Solution301_499;

public class Solution482 {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-","");
        StringBuffer ret = new StringBuffer(s);
        int index = ret.length() - k;
        while (index >= 0){
            ret.insert(index, '-');
            index -= k;
        }

        return ret.toString().toUpperCase();
    }
}
