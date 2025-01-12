import static java.lang.Math.max;
import static java.lang.Math.min;

class Solution {
  public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
    int nearest_x = max(x1, min(x2, xCenter));
    int nearest_y = max(y1, min(y2, yCenter));

    int dist_x = nearest_x - xCenter;
    int dist_y = nearest_y - yCenter;

    return (dist_x * dist_x + dist_y * dist_y) <= (radius * radius);
  }
}
