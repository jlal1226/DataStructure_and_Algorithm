package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 단순 선택 정렬 알고리즘
public class SelectionSort {
    static void selectionSort(int[] arr, int n){
        // 첫번째 요소부터 선택 후 가장 작은 요소와 교환
        // 다음 요소 선택 후 나머지 중 가장 작은 요소와 교환
        for (int i = 0; i < n; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){ // 가장 작은 요소의 index 찾기
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex); // 정렬되지 않은 요소들 중 첫 번째 요소와 가장 작은 요소를 교환
        }
    }

    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.print("요소수 : ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        // 1 ~ 50 랜덤 요소 생성
        for (int i = 0; i < n; i++){
            arr[i] = rand.nextInt(50)+1;
        }

        // 배열 출력
        System.out.println("전 : " + Arrays.toString(arr));
        // 선택 정렬
        selectionSort(arr, n);
        // 배열 출력
        System.out.println("후 : " + Arrays.toString(arr));
    }
}
/*
- 요솟값을 비교하는 횟수 : (n^2 - n) / 2
- 안정적이지 않은 알고리즘 -> 서로 떨어져있는 요소를 교환하기 때문 -> 같은 값의 요소의 순서가 바뀔 수 있음
 */
