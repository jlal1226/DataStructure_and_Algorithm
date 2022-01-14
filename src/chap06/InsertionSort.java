package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 단순 선택 정렬 알고리즘
public class InsertionSort {
    static void InsertionSort(int[] arr, int n) {
        // 2번째 요소부터 선택 후 앞에 요소와 비교
        // 1씩 증가 시키면서 앞에 정렬 된 요소들 중 알맞은 위치에 삽입
        // tmp <- arr[i]
        // 0 ~ i-1의 알맞은 위치에 tmp 삽입
        // 배열 끝에 도달하거나 or 자신보다 크기가 작은 요소를 만나면 반복문을 통한 교환 중단
        for (int i = 1; i < n; i++){
            int tmp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1] > tmp; j--) { // j-1에 있는 요소를 j로 옮기면서 j를 감소
                arr[j] = arr[j-1];
            }
            arr[j] = tmp; // tmp에 저장해 놓은 i번째 요소를 j번째 위치에 삽입 -> tmp 보다 큰 요소들은 1칸씩 뒤로 다 밀림
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
        // 삽입 정렬
        InsertionSort(arr, n);
        // 배열 출력
        System.out.println("후 : " + Arrays.toString(arr));
    }
}
/*
- 요솟값을 비교하는 횟수 : n^2 / 2
- 안정적인 알고리즘 -> 서로 떨어져있는 요소들이 서로 뒤바뀌지 않기 때문
- 장점 : 정렬을 마쳤거나 정렬을 마친 상태에 가까운면 정렬 속도가 매우 빠름
- 단점 : 십입할 위치가 멀리 떨어져 있으면 이동(대입)해야 하는 횟수가 증가함
- 단순 정렬 (bubble sort, selection sort, insertion sort) 시간 복잡도는 모두 O(n^2) -> 효율이 좋지 않음
 */
