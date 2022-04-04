package chap06.QuickSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 비재귀적으로 구현한 퀵 정렬
public class QuickSort_Q14 {
    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    static int findMid(int a, int b, int c) {
        int[] arr = {a, b, c};
        int tmp = arr[0];
        int max;
        int min;
        insertionSort(arr, 0, arr.length - 1);

        return arr[1];
    }

    // 단순 삽입 정렬
    static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = arr[i];
            int j;
            for (j = i; j > left && arr[j-1] > tmp; j--)
                arr[j] = arr[j-1];
            arr[j] = tmp;
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        int size = right - left + 1; // 그룹의 요소 개수

        // 퀵 정렬은 요소의 개수가 적은 배열에 대해서는 처리가 아주 빠르게 진행되지 않는다. -> 이유를 아직 모르겠음
        // 그룹의 요소 개수가 9개 이하면 단순 삽입 정렬 수행
        if (size <= 9){
            insertionSort(arr, left, right);
        }else {
            int pl = left;
            int pr = right;
            int pivot = arr[(pl + pr) / 2]; // 배열의 중앙값

            // pivot 선택하기
            // 1. 배열의 요소 개수가 3개 이상이면 임의로 요소 3개를 선택하여 중간값을 요소로 선택
            pivot = findMid(arr[pl], pivot, arr[pr-1]);

            // 퀵 정렬 분할 과정 출력
            System.out.printf("arr[%d] ~ arr[%d] : [ ", left, right);
            for (int i = pl; i <= pr; i++)
                System.out.print(arr[i] + " ");
            System.out.println("]  pivot : " + pivot);

            // 그룹 나누기
            do{
                while (arr[pl] < pivot) pl++; // pl 커서를 오른쪽으로 스캔
                while (arr[pr] > pivot) pr--; // pr 커서를 왼쪽으로 스캔
                if(pl <= pr) // 값 교환 후 커서 이동
                    swap(arr, pl++, pr--);
            }while (pl <= pr); // pl과 pr이 교차하면 -> 그룹이 2개로 나누어짐

            if (left < pr) // 재귀를 통해 분리된 왼쪽 그룹 정렬 -> 그룹의 개수가 1개인 경우 중지
                quickSort(arr, left, pr);
            if (pl < right) // 재귀를 통해 분리된 오른쪽 그룹 정렬 -> 그룹의 개수가 1개인 경우 중지
                quickSort(arr, pl, right);
        }

    }

    // 연습문제 Q.10 -> 매개변수로 n만 받아서 quickSort() 구현하기
    static void quickSort(int[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.print("요소수 : ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        // 1 ~ 50 랜덤 요소 생성
        for (int i = 0; i < n; i++){
            arr[i] = rand.nextInt(50) + 1;
            for (int j = 0; j < i; j++){
                if (arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }
        // 배열 출력
        System.out.println("전 : " + Arrays.toString(arr));
        // 선택 정렬
        quickSort(arr, n);
        // 배열 출력
        System.out.println("후 : " + Arrays.toString(arr));
    }
}
