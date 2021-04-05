package Solution500_;

public class Solution1603 {
}
class ParkingSystem {
    private int[] parkingLeft = new int[4];

    public ParkingSystem(int big, int medium, int small) {
        this.parkingLeft[1] = big;
        this.parkingLeft[2] = medium;
        this.parkingLeft[3] = small;
    }

    public boolean addCar(int carType) {
        if (this.parkingLeft[carType] == 0)
            return false;
        this.parkingLeft[carType] -= 1;
        return true;
    }
}