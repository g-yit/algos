package com.algos.utils;

import java.util.Random;

/**
 * @author g-yit
 * @description TODO类描述
 * @createtime 2021/09/27  18:22:00
 */
public class ArrayUtils {
    public static int[] DATA = new int[]{
            10, 100, 300, 29, 394, 29384, 102, 3, 1, 98, 8754, 654, 94, 93, 11, 123
    };

    /***
     * 数组是否有序
     * @author zhangyt
     * @date 2021/09/27 18:24
     * @param array
     * @return boolean
     */
    public static boolean isOrdered(int[] array) {
        assetNotNull(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /***
     * 打印一维数组，每十个一行
     * @author zhangyt
     * @date 2021/09/27 18:37
     * @param array
     * @return void
     */
    public static void printArray(int[] array) {
        assetNotNull(array);
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i % 10 != 0) {
                System.out.print(array[i] + "\t");
            } else {//每10个数字一行 换行
                System.out.println(array[i]);
            }
        }
        System.out.println();
    }

    public static void shuffle(int[] array) {
        assetNotNull(array);
        int length = array.length;
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            int index = random.nextInt(length);
            swap(array, index, i);
        }
    }

    public static void assetNotNull(int[] array) {
        if (array == null || array.length <= 0) {
            throw new RuntimeException("array can't be null or empty");
        }
    }

    public static void swap(int[] array, int a, int b) {
        assetNotNull(array);
        int length = array.length;
        if (a < 0 || a >= length || b < 0 || b >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }
}
