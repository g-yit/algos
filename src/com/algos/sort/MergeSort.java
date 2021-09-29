package com.algos.sort;

import com.algos.utils.ArrayUtils;

/**
 * @author g-yit
 * @description TODO类描述
 * @createtime 2021/09/28  01:09:00
 */
public class MergeSort {

    public static void main(String[] args) {
        sort(ArrayUtils.DATA);
        ArrayUtils.printArray(ArrayUtils.DATA);
        System.out.println(ArrayUtils.isOrdered(ArrayUtils.DATA));

    }

    private static int[] aux;

    public static void sort(int[] array) {
        aux = new int[array.length];
        sort(array, 0, array.length - 1);

    }

    public static void sort(int[] array, int start, int end) {
        ArrayUtils.assetNotNull(array);
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    /***
     * 归并排序的辅助merge 函数
     * <p></p>
     * @author zhangyt
     * @date 2021/09/28 12:57
     * @param array
     * @param start
     * @param mid
     * @param end
     * @return void
     */
    public static void merge(int[] array, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            aux[i] = array[i];
        }
        int left = start;
        int right = mid + 1;
        int k = start;

        while (k <= end) {
            if (left > mid) {
                array[k++] = aux[right++];
            } else if (right > end) {
                array[k++] = aux[left++];
            } else if (aux[left] > aux[right]) {
                array[k++] = aux[right++];
            } else {
                array[k++] = aux[left++];
            }
        }
    }


}
