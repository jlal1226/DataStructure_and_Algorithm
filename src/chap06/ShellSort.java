package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 셸 정렬 알고리즘
public class ShellSort {
    /*
    - 삽입 정렬의 단점을 보완하고 장점을 살린 정렬 알고리즘
    - 정렬할 배열의 요소를 그룹으로 나눠 각 그룹별로 단순 삽입 정렬을 수행
    - 4-정렬 or 2-정렬로 조금이라도 정렬이 된 상태에 가까운 배열로 만듬
    - 정렬 해야 하는 횟수는 늘지만, 전체적으로는 요소 이동의 횟수가 줄어들어 효율적인 정렬 가능
     */
    static int shellSort(int[] arr, int n) {
        /*
        h값을 반복문으로 돌리면서
        삽입 정렬 수행 -> 범위 잘 생각해야됌
         */
        int cnt = 0;
        for (int h = n/2; h > 0; h /= 2){ // 예) 요소 8개면 h -> 4, 2, 1
            for (int i = h; i < n; i++){ // 그룹으로 나눈 요소를 정렬
                int j;
                int tmp = arr[i]; // i번째 요소를 저장
                for (j = i - h; j >= 0 && arr[j] > tmp; j -= h){ // 예) 4-정렬 시 0번째와 4번째 요소 정렬
                    arr[j+h] = arr[j];
                    cnt++;
                }
                arr[j+h] = tmp; // 반복문을 들어갔다 나오면 j가 h만큼 감소되기 때문에 -> j : -4, h : 4
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("셸 정렬(버전 1)");
        System.out.print("요소수 : ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        // 1 ~ 50 랜덤 요소 생성
        for (int i = 0; i < n; i++){
            arr[i] = rand.nextInt(50)+1;
        }

        int[] newArr = {32, 11, 41, 30, 2, 6, 22, 18};

        // 배열 출력
        //System.out.println("전 : " + Arrays.toString(arr));
        // 셸 정렬
        int num = shellSort(arr, n);
        // 배열 출력
        //System.out.println("후 : " + Arrays.toString(arr));

        System.out.println("전 : " + Arrays.toString(newArr));
        int cnt = shellSort(newArr, n);
        System.out.println("후 : " + Arrays.toString(newArr));

        System.out.println("교환 횟수 : "+cnt);
    }
}
/*

 */
