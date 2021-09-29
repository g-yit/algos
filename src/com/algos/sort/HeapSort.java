package com.algos.sort;

import com.algos.utils.ArrayUtils;

/**
 * @author g-yit
 * @description 构建大顶堆 每一次将顶部的元素换到最后，重复操作
 * @createtime 2021/09/28  13:00:00
 */
public class HeapSort {
    public static void sort(int[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            ArrayUtils.swap(a, 1, N--);
            sink(a, 1, N);
        }
    }

    /***
     * sink的操作保证将
     * @author g-yit
     * @date 2021/09/28 16:08
     * @param array
     * @param start
     * @param end
     * @return void
     */
    public static void sink(int[] array, int start, int end) {
        while (2 * start < end) {
            int k = 2 * start;
            if (k < end && array[k] < array[k + 1]) {
                k++;
            }
            if (array[start] < array[k]) {
                break;
            }
            ArrayUtils.swap(array, start, k);
            start = k;
        }
    }

    /**
     * @param array
     * @param start
     * @param end
     * @return void
     * @author g-yit
     * @date 2021/09/28 13:06
     */
    public static void swim(int[] array, int start, int end) {

    }

}
