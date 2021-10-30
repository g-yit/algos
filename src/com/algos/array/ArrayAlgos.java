package com.algos.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author g-yit
 * @description 关于数组的相关算法
 * @createtime 2021/10/11  18:06:00
 */
public class ArrayAlgos {
    /**
     * 删除数组中的重复元素
     * 使用双指针的方法来做
     * 往前赶 赶
     *
     * @param nums
     * @return int
     * @author g-yit
     * @date 2021/10/11 18:15
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        //下一个不同的元素需要填充的位置
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];//替换
                slow++;
            }
        }
        return slow;
    }


    /**
     * 数组中三数之和为0
     *
     * @param nums
     * @return int
     * @author g-yit
     * @date 2021/10/11 19:59
     * [-1,0,1,2,-1,-4]
     * [-4,-1,-1,0,1,2]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] > 0 || nums[length - 1] < 0) {
            return result;
        }
        for (int pivotIndex = 0; pivotIndex < length; pivotIndex++) {
            int lo = pivotIndex + 1;
            int hi = length - 1;
            if (nums[pivotIndex] > 0) {
                return result;
            }
            if (pivotIndex > 0 && nums[pivotIndex] == nums[pivotIndex - 1]) {
                continue;
            }
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[pivotIndex];
                if (sum > 0) {
                    hi--;
                    while (lo < hi && nums[hi + 1] == nums[hi]) {
                        hi--;
                    }
                } else if (sum < 0) {
                    lo++;
                    while (lo < hi && nums[lo - 1] == nums[lo]) {
                        lo++;
                    }
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[pivotIndex]);
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    result.add(list);
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo - 1] == nums[lo]) {
                        lo++;
                    }
                    while (lo < hi && nums[hi + 1] == nums[hi]) {
                        hi--;
                    }
                }

            }
        }
        return result;
    }

    private static void swap(int[] array, int i, int j) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (i >= length || j >= length || i < 0 || j < 0) {
            return;
        }

        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }


}
