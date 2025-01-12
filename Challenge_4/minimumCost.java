class Solution {
  public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    long[][] dist = new long[26][26];
    // Initialize the dist array with a large value (Infinity)
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        dist[i][j] = (i == j) ? 0 : Long.MAX_VALUE; // Self-loops cost 0
      }
    }

    // Populate distances using the original and changed arrays
    for (int i = 0; i < original.length; i++) {
      int from = original[i] - 'a';
      int to = changed[i] - 'a';
      dist[from][to] = Math.min(dist[from][to], cost[i]);
    }

    // Floyd-Warshall Algorithm to find shortest paths
    for (int node = 0; node < 26; node++) {
      for (int u = 0; u < 26; u++) {
        for (int v = 0; v < 26; v++) {
          if (dist[u][node] != Long.MAX_VALUE && dist[node][v] != Long.MAX_VALUE) {
            dist[u][v] = Math.min(dist[u][v], dist[u][node] + dist[node][v]);
          }
        }
      }
    }

    long ans = 0;

    // Calculate the total cost to transform source to target
    for (int i = 0; i < source.length(); i++) {
      char srcChar = source.charAt(i);
      char tgtChar = target.charAt(i);
      if (srcChar == tgtChar)
        continue; // No cost for equal characters

      int from = srcChar - 'a';
      int to = tgtChar - 'a';

      if (dist[from][to] == Long.MAX_VALUE)
        return -1; // Transformation not possible
      ans += dist[from][to];
    }

    return ans;
  }
}
