package Solution151_300;

class VersionControl{
    private int fitstBadVersion = 3;

    public int getFitstBadVersion() {
        return fitstBadVersion;
    }

    public void setFitstBadVersion(int fitstBadVersion) {
        this.fitstBadVersion = fitstBadVersion;
    }

    boolean isBadVersion(int version){
        return version >= fitstBadVersion;
    }
}

public class Solution278 extends VersionControl{
    /**
     * 这里注意mid的求法
     * @param n 总共的版本数量，应该大于0
     * @return 第一个出错的版本，如果没有就返回-1
     */
    public int firstBadVersion(int n) {
        assert n > 0;
        int left = 0, right = n;
        int ret = -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)){
                ret = mid + 1;
                left = ret;
            }else {
                right = mid;
            }
        }

        return isBadVersion(ret) ? ret : -1;
    }
}
