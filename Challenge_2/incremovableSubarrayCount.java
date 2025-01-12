class Solution {
  public int incremovableSubarrayCount(int[] arr) {
    int count = 0;
    int len = arr.length;

    for (int start = 0; start < len; start++) {
      for (int end = start; end < len; end++) {
        if (isIncreasingSubArray(arr, start, end)) {
          count++;
        }
      }
    }
    return count;
  }

  public boolean isIncreasingSubArray(int[] arr, int start, int end) {
    int len = arr.length;
    int prev = Integer.MIN_VALUE;

    for (int i = 0; i < len; i++) {
      // Skip the subarray [start, end]
      if (i >= start && i <= end) {
        continue;
      }
      if (arr[i] <= prev) {
        return false;
      }
      prev = arr[i];
    }
    return true;
  }
}
