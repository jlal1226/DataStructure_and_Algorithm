package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 알고리즘 개선 버전 1
public class BubbleSort2 {
    static int cnt = 0;
    static int check = 0;

    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
    // 버블 정렬 -> 종료 조건 추가하여 알고리즘 개선
    static void bubbleSort(int[] a, int n){
        for (int i = 0; i < n-1; i++){ // n-1번 실행
            check++;
            int exchg = 0;
            for (int j = n-1; j > i; j--){ // 마지막 요소부터 i번째 요소까지 검사
                if (a[j-1] > a[j]){
                    swap(a, j-1, j);
                    cnt++;
                    exchg++; // 교환 횟수 증가
                }
            }
            if (exchg == 0) // 교환 횟수가 0이면 마지막 요소까지 정렬이 완료된거임
                break;
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

        int[] arr1 = {6, 4, 3, 7, 1, 9, 8};
        // 배열 출력
        System.out.println("전 : " + Arrays.toString(arr1));
        // 버블 정렬
        bubbleSort(arr1, 7);
        // 배열 출력
        System.out.println("후 : " + Arrays.toString(arr1));
        System.out.println("전체 비교 횟수 : " + check);
        System.out.println("전체 교환 횟수 : " + cnt);
    }
}
