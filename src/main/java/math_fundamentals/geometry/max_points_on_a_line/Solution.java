package math_fundamentals.geometry.max_points_on_a_line;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        int result = 2;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int bestFromCurrentPoint = 0;

            for (int j = i + 1; j < points.length; j++) {
                String slope = calculateSlope(points[i], points[j]);
                int count = slopeCount.getOrDefault(slope, 0) + 1;
                slopeCount.put(slope, count);
                bestFromCurrentPoint = Math.max(bestFromCurrentPoint, count);
            }

            result = Math.max(result, bestFromCurrentPoint + 1);
        }

        return result;
    }

    private String calculateSlope(int[] point1, int[] point2) {
        int dy = point2[1] - point1[1];
        int dx = point2[0] - point1[0];

        if (dx == 0) {
            return "1/0";
        }

        if (dy == 0) {
            return "0/1";
        }

        int g = gcd(Math.abs(dy), Math.abs(dx));
        dy = dy / g;
        dx = dx / g;

        if (dx < 0) {
            dx = -dx;
            dy = -dy;
        }

        return dy + "/" + dx;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a < b) {
            return gcd(b, a);
        }
        return gcd(a % b, b);
    }
}
