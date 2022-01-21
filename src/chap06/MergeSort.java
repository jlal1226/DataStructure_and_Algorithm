package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    static int[] buff; // 작업용 배열
    // arr[left] ~ arr[right] 재귀적으로 병합 정렬
    static void __mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(arr, 0, center); // 앞부분
            __mergeSort(arr, center + 1, right); // 뒷부분

            // 배열의 앞부분을 buff[]에 복사
            for (i = left; i <= center; i++)
                buff[p++] = arr[i];
            // 배열의 뒷부분과 buff[]의 요소를 비교하면서 작은 요소를 배열 arr에 병합
            while ( i <= right && j < p)
                arr[k++] = (buff[j] <= arr[i]) ? buff[j++] : arr[i++];
            // buff[]의 나머지 요소를 배열 arr에 복사
            while (j < p)
                arr[k++] = buff[j++];
        }
    }
    // 병합 정렬
    static void mergeSort(int[] arr, int n) {
        buff = new int[n]; // 작업용 배열 생성
        __mergeSort(arr, 0, n-1); // 병합 정렬
        buff = null; // 작업용 버퍼 해제
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
        mergeSort(arr, num);
        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }
}
