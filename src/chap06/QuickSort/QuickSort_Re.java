package chap06.QuickSort;

import java.util.Arrays;

public class QuickSort_Re {
    private static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(right - left) / 2];

        do {
            while (arr[pl] < pivot) {
                pl++;
            }
            while (arr[pr] > pivot) {
                pr--;
            }
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort(arr, left, pr);
        }
        if (pl < right) {
            quickSort(arr, pl, right);
        }
    }

    private static void swap(int arr[], int pl, int pr) {
        int tmp = arr[pl];
        arr[pl] = arr[pr];
        arr[pr] = tmp;
    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        int[] arr= {7, 1, 4, 10, 13, 32, 5, 26};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
