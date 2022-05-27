package Solution500_;

import java.util.*;

public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        Set<String> cityStart = new HashSet<>();
        for (List<String> path:paths) {
            cityStart.add(path.get(0));
        }

        for (List<String> path:paths) {
            if (!cityStart.contains(path.get(1)))
                return path.get(1);
        }

        return null;
    }
}
