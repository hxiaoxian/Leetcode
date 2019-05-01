package array.medium;

import java.util.*;

/**
 * Created by Hxg
 * Date: 2019/4/27
 * Time: 15:02
 * Version 1.0
 * Description : LeetCode
 */
public class leetcode15 {

    //时间复杂度O(n^3) Time Limit Exceeded
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> List = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;
                    for (int k = j + 1; k < nums.length; k++) {
                        if (k > j + 1 && nums[k] == nums[k - 1])
                            continue;
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            List.add(list);
                            break;
                        }
                    }
                }
            }
            return List;
        }
    }

    //时间复杂度O(n^2)，空间复杂度O(n)，使用hashset避开重复的值
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            HashSet<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1, k = nums.length - 1; j < k; ) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        if (set.add(l))
                            list.add(l);
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0)
                        j++;
                    else
                        k--;
                }
            }
            return list;
        }
    }

    //时间复杂度O(N^2)，空间复杂度O(1) 指针法
    class Solution3 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i + 2 < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1, k = nums.length - 1;
                int target = -nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1])
                            j++;  // 避开重复值
                        while (j < k && nums[k] == nums[k + 1])
                            k--;  // 避开重复值
                    } else if (nums[j] + nums[k] > target) {
                        k--;      // k左移
                    } else {
                        j++;      // k右移
                    }
                }
            }
            return res;
        }
    }

}
