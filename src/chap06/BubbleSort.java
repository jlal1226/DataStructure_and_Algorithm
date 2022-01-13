package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    static int cnt = 0;
    static int check = 0;

    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
    // 버블 정렬
    static void bubbleSort(int[] a, int n){
        for (int i = 0; i < n-1; i++){ // n-1번 실행
            for (int j = n-1; j > i; j--){ // 마지막 요소부터 i번째 요소까지 검사
                check++;
                if (a[j-1] > a[j]){
                    swap(a, j-1, j);
                    cnt++;
                }
            }
        }
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
        // 버블 정렬
        bubbleSort(arr, n);
        // 배열 출력
        System.out.println("후 : " + Arrays.toString(arr));
        System.out.println("전체 비교 횟수 : " + check);
        System.out.println("전체 교환 횟수 : " + cnt);

    }
}
