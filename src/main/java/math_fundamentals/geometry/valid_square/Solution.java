package math_fundamentals.geometry.valid_square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Long> distance = new ArrayList<>();
        distance.add(calculateDistance(p1, p2));
        distance.add(calculateDistance(p1, p3));
        distance.add(calculateDistance(p1, p4));
        distance.add(calculateDistance(p2, p3));
        distance.add(calculateDistance(p2, p4));
        distance.add(calculateDistance(p3, p4));

        Map<Long, Integer> distanceCount = new HashMap<>();
        for (var dis : distance) {
            distanceCount.put(dis, distanceCount.getOrDefault(dis, 0) + 1);
        }

        // either side or diag
        if (distanceCount.size() != 2) {
            return false;
        }

        long side = Integer.MAX_VALUE, diag = Integer.MIN_VALUE;
        for (var edge : distanceCount.keySet()) {
            side = Math.min(side, edge);
            diag = Math.max(diag, edge);
        }

        // 4 side + 2 diag; Pythagoras check.
        return side > 0 && distanceCount.get(side) == 4 && distanceCount.get(diag) == 2 && diag == 2 * side;
    }

    private Long calculateDistance(int[] point1, int[] point2) {
        return (long) (point1[0] - point2[0]) * (point1[0] - point2[0])
                + (long) (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
