package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 퀵정렬
// 시간 복잡도 : 평군 O(n log n) -> 파티션을 나누는 횟수는 n번 -> 데이터가 절반씩 줄어들음
public class QuickSort1 {
    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(pl + pr) / 2]; // 배열의 중앙값

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
