import java.util.HashMap;
import java.util.Map;

class Solution {
  public long maximumSubarraySum(int[] nums, int k) {
    long ans = 0; // Store the maximum sum of subarrays of size k
    long cs = 0; // Current sum of the sliding window
    int begin = 0; // Start of the sliding window
    int end = 0; // End of the sliding window

    Map<Integer, Integer> lastseen = new HashMap<>();

    while (end < nums.length) {
      int curr = nums[end];
      int j = lastseen.getOrDefault(curr, -1);

      // Adjust the sliding window if necessary
      while (j >= begin || (end - begin + 1) > k) {
        cs -= nums[begin];
        begin++;
      }

      // Add the current element to the sum
      cs += nums[end];
      lastseen.put(curr, end);

      // If the window size is exactly k, check for the maximum sum
      if (end - begin + 1 == k) {
        ans = Math.max(ans, cs);
      }

      end++;
    }

    return ans;
  }
}
