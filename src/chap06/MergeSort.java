package chap06;

import java.util.Arrays;

public class MergeSort {
    static int[] buff;
    static void mergeSort(int[] arr) {
        int len = arr.length;
        buff = new int[len];
        __mergeSort(arr, 0, len - 1);
    }

    static void __mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            __mergeSort(arr, left, center);
            __mergeSort(arr, center + 1, right);
            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        int p = 0; // 버퍼 끝부분 커서
        int b_start = 0; // 버퍼 커서
        int pa = left; // 배열 a의 커서
        int pr = center + 1; // 배열의 오른쪽 부분 커서

        // 배열의 왼쪽부분을 버퍼에 저장
        for (int i = left; i <= center; i++) {
            buff[p++] = arr[i];
        }

        // 버퍼와 배열의 오른쪽 부분을 크기 순으로 배열 a에 다시 저장
        while (b_start < p && pr <= right) {
            arr[pa++] = (buff[b_start] <= arr[pr]) ? buff[b_start++] : arr[pr++];
        }
        // 버퍼에 남아있는 요소를 배열 a로 복사 -> 배열의 오른쪽 부분의 요소가 남아있는건 그대로 두면 됌
        while (b_start < p) {
            arr[pa++] = buff[b_start++];
        }

    }

    public static void main(String[] args) {
        int[] arr = {7, 22, 5, 10, 45, 30, 1, 13, 27};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
