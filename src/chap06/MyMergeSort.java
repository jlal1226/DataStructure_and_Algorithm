package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyMergeSort {
    static void mergeSort(int[] arr) {
        int [] buff = new int[arr.length]; // 임시 버퍼 배열 생성
        mergeSort(arr, buff, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int[] buff, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, buff, start, mid); // 배열 앞부분
            mergeSort(arr, buff, mid + 1, end); // 배열 뒷부분

        }
    }
    // 병합하는 함수
    static void merge(int[] arr, int[] buff, int start, int mid, int end) {
        // 배열의
        for (int i = start; i <= end; i++) {
            buff[i] = arr[i];
        }

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("요솟수 : ");
        int num = scan.nextInt();
/*        int[] arr = new int[num];

        // 1 ~ 50 랜덤 요소 생성
        for (int i = 0; i < num; i++){
            arr[i] = rand.nextInt(50) + 1;
            for (int j = 0; j < i; j++){
                if (arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }*/
        int[] arr = {1, 3, 12, 6, 4, 11, 8, 7, 3, 2, 13, 16};


        System.out.println("정렬 전 : " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }
}
