import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums); // Sort the array to enable two-pointer approach
    for (int i = 0; i < nums.length; i++) {
      // Avoid duplicates for the first element
      if (i == 0 || nums[i - 1] != nums[i]) {
        twoSumSorted(i + 1, nums.length - 1, nums, -nums[i]);
      }
    }
    return res;
  }

  void twoSumSorted(int i, int j, int[] nums, int target) {
    int a = nums[i - 1]; // The fixed element in the three-sum
    while (i < j) {
      if (nums[i] + nums[j] > target) {
        j--; // Decrease j if sum is greater than target
      } else if (nums[i] + nums[j] < target) {
        i++; // Increase i if sum is less than target
      } else { // nums[i] + nums[j] == target
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(nums[i]);
        list.add(nums[j]);

        res.add(list);

        // Skip duplicates for nums[i]
        while (i < j && nums[i] == nums[i + 1]) {
          i++;
        }
        // Skip duplicates for nums[j]
        while (i < j && nums[j] == nums[j - 1]) {
          j--;
        }
        // Move both pointers after processing the current pair
        i++;
        j--;
      }
    }
  }
}
 