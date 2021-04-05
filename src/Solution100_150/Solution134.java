package Solution100_150;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        assert gas != null && cost != null && gas.length == cost.length;
        int minIndex = -1, minLeftGas = Integer.MAX_VALUE;
        int currentLeftGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currentLeftGas += gas[i] - cost[i];
            minIndex = (minLeftGas < currentLeftGas) ? minIndex : i;
            minLeftGas = (minLeftGas < currentLeftGas) ? minLeftGas : currentLeftGas;
        }
        return currentLeftGas >= 0 ? (minIndex+1)%gas.length : -1;
    }
}
