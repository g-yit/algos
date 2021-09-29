package com.algos.sort;


import com.algos.utils.ArrayUtils;

public class SimpleSort {
    public static int[] DATA = new int[]{
            10, 100, 300, 29, 394, 29384, 102, 3, 1, 98, 8754, 654, 94, 93, 11, 123
    };

    public static void main(String[] args) {
        System.out.println("sort");
        ArrayUtils.printArray(DATA);
        insertSort(DATA);
        System.out.println(ArrayUtils.isOrdered(DATA));
        ArrayUtils.printArray(DATA);
//        System.out.println(ArrayUtils.isOrdered(DATA));
//        ArrayUtils.printArray(ArrayUtils.isOrdered(DATA));

    }

    /***
     *
     * 冒泡排序,每一趟选择最大的往下沉
     * <p>
     * @author zhangyt
     * @date 2021/09/27 22:24
     * @param array
     * @return void
     */
    public static void bubbleSort(int[] array) {
        ArrayUtils.assetNotNull(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtils.swap(array, j, j + 1);
                }
            }
        }
    }

    /***
     * 选择排序，每一次选择最小的放在左边
     * @author zhangyt
     * @date 2021/09/27 22:47
     * @param array
     * @return void
     */
    public static void selectSort(int[] array) {
        ArrayUtils.assetNotNull(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    ArrayUtils.swap(array, i, j);
                }
            }
        }
    }

    /**
     * 插入排序，和扑克牌一样，假设初始的序列是有序的，后面的往前面插
     *
     * @param array
     * @return void
     * @author zhangyt
     * @date 2021/09/27 22:54
     */
    public static void insertSort(int[] array) {
        ArrayUtils.assetNotNull(array);
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    ArrayUtils.swap(array, j, j - 1);
                }
            }
        }
    }


}
