package chap06.QuickSort;

import java.util.Arrays;

public class QuickSort_Re {
    private static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(pr + pl) / 2]; // 피봇값

        do {
            while (arr[pl] < pivot) { // 왼쪽 커서 검색
                pl++;
            }
            while (arr[pr] > pivot) { // 오른쪽 커서 검색
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
