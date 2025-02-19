class Solution {
  public int[][] imageSmoother(int[][] img) {
    int m = img.length;
    int n = img[0].length;

    int[] x = new int[] { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
    int[] y = new int[] { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
    int[][] res = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int sum = 0;
        int count = 0;

        for (int k = 0; k < 9; k++) {
          int xi = i + x[k];
          int yi = j + y[k];

          if (xi >= 0 && xi < m && yi >= 0 && yi < n) {
            sum += img[xi][yi];
            count++;
          }
        }
        res[i][j] = sum / count;
      }
    }
    return res;
  }
}
