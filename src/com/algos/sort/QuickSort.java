package com.algos.sort;

import com.algos.utils.ArrayUtils;

/**
 * 快速排序，需要partition函数作为辅助函数
 * partition有两种方式，一种是使用单边扫描，一种是使用双边扫描
 * 使得，大于 pivot的放在pivot的右边，小于pivot的放在pivot的左边
 *
 * @author g-yit
 * @description 快排
 * @createtime 2021/09/27  23:23:00
 */
public class QuickSort {
    public static void main(String[] args) {

        ArrayUtils.printArray(ArrayUtils.DATA);
        sort(ArrayUtils.DATA);
        ArrayUtils.printArray(ArrayUtils.DATA);
        System.out.println(ArrayUtils.isOrdered(ArrayUtils.DATA));
    }

    public static void sort(int[] array) {
        ArrayUtils.assetNotNull(array);
        sort(array, 0, array.length - 1);

    }

    public static void sort(int[] array, int start, int end) {
        ArrayUtils.assetNotNull(array);
        if (start >= end) {
            return;
        }
        int index = partitionV2(array, start, end);
        sort(array, start, index - 1);
        sort(array, index + 1, end);
    }

    /***
     *
     * 使用单边扫描法完成partition的过程
     * 以左边第一个元素为pivot
     * @author zhangyt
     * @date 2021/09/27 23:41
     * @param array
     * @param start
     * @param end
     * @return int
     */
    public static int partition(int[] array, int start, int end) {
        ArrayUtils.assetNotNull(array);
//        int length = array.length;
        if (start == end) {
            return start;
        }
        int pivot = array[start];
        int mark = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] <= pivot) {
                ArrayUtils.swap(array, mark, i);
                mark++;
            }
        }
        ArrayUtils.swap(array, start, mark - 1);
        return mark - 1;
    }

    /**
     * 双边扫描法
     * 维护两个指针
     * left right
     * <p><p/>
     *
     * @param array
     * @param start
     * @param end
     * @return int
     * @author zhangyt
     * @date 2021/09/28 00:07
     */
    public static int partitionV2(int[] array, int start, int end) {
        ArrayUtils.assetNotNull(array);
        if (start == end) {
            return start;
        }
        int pivot = array[start];
        int left = start + 1;
        int right = end;
        while (left < right) {
            while (array[right] > pivot && left < right) {
                right--;
            }

            while (array[left] < pivot && left < right) {
                left++;
            }
            if (left >= right) {
                break;
            }
            if (left < right) {
                ArrayUtils.swap(array, left, right);
            }
        }
        if (array[left] < pivot) {//只有两个数的时候的极端情况  2 1
            ArrayUtils.swap(array, left, start);
        }
        return left;

    }
}
