package chap06.QuickSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 배열을 두 그룹으로 나누기
public class Partition {
    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    static void partition(int[] arr, int n) {
        int pl = 0;
        int pr = n - 1;
        int x = arr[n/2]; // 배열의 중앙값

        // 베열을 x를 기준으로 나눈다
        do{
            while (arr[pl] < x) pl++; // pl 커서를 오른쪽으로 스캔
            while (arr[pr] > x) pr--; // pr 커서를 왼쪽으로 스캔
            if(pl <= pr) // 값 교환
                swap(arr, pl++, pr--);
        }while (pl <= pr); // pl과 pr이 교차하면 -> 그룹이 2개로 나누어짐

        System.out.println("pivot : " + x);
        System.out.println("pivot 이하 그룹");
        for (int i = 0; i <= pl - 1; i++) // pivot을 기준으로 오른쪽으로 한칸 더 위치해 있음
            System.out.print(arr[i] + " ");
        System.out.println();

        System.out.println("pivot과 일치하는 그룹");
        for (int i = pr + 1; i <= pl - 1; i++) // pivot과 일치하는 값을 가지는 그룹으로 만들어질 수 있음
            System.out.print(arr[i] + " ");
        System.out.println();

        System.out.println("pivot 이상 그룹"); // pivot을 기준으로 왼쪽으로 한칸 더 위치해 있음
        for (int i = pr + 1; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
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
        partition(arr, n);
        // 배열 출력
        System.out.println("후 : " + Arrays.toString(arr));
    }
}
