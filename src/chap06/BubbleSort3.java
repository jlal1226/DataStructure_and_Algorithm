package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 알고리즘 개선 버전 2
public class BubbleSort3 {
    static int cnt = 0;
    static int check = 0;

    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
    // 버블 정렬
    // 1.더 이상 교환하지 않는 배열 뒷부분 제외 -> 종료 조건 추가하여 알고리즘 개선
    // 2.이미 정렬된 배열의 앞부분 제외
    static void bubbleSort(int[] a, int n){
        int k = 0;
        while (k < n-1){
            check++;
            int exchg = 0;
            int last = n-1;
            for (int j = n-1; j > k; j--){ // 마지막 요소부터 i번째 요소까지 검사
                if (a[j-1] > a[j]){
                    swap(a, j-1, j);
                    cnt++; // 전체 교환 횟수
                    exchg++; // 교환하는지 확인
                    last = j;
                }
            }
            k = last;
/*            if (exchg == 0) // 교환 횟수가 0이면 마지막 요소까지 정렬이 완료된거임
                break;*/
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
