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
            merge(arr, buff, start, mid, end);
        }
    }
    // 병합하는 함수
    static void merge(int[] arr, int[] buff, int start, int mid, int end) {
        //배열을 buff[]에 복사
        for (int i = start; i <= end; i++) {
            buff[i] = arr[i];
        }
        int part1 = start; // 왼쪽 그룹의 시작 index
        int part2 = mid + 1; // 오른쪽 그룹의 시작 index
        int index = start;

        while (part1 <= mid && part2 <= end) {
            arr[index++] = (buff[part1] <= buff[part2]) ? buff[part1++] : buff[part2++];
        }
        // 앞쪽 데이터가 남은 경우
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = buff[part1 + 1];
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
