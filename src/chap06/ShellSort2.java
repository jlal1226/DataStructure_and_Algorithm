package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 개선된 셸 정렬 알고리즘
public class ShellSort2 {
    /*
    [증분값 (h 값) 선택하기] -> 알고리즘 개선
    - h값이 서로 배수가 되지 않도록 한다 -> 예) 2의 배수로 하게 되면 그룹간의 요소가 섞이지 않음 (기억 안나면 책 221p 참고)
    - 셸 정렬 알고리즘을 간단하게 구현 가능
    - 효율적인 결과를 기대할 수 있다.
    - 1부터 시작하여 3배한 값에 1을 더함
    - h의 초기값이 너무 크면 효과가 없음 -> 요솟수 n을 9로 나눈 값을 넘지 않도록 정한다
    - h값은 3으로 나누면서 0이 될때까지 정렬이 된다
    - 시간 복잡도 : O(n^1.25) -> 기존 O(n^2)보다 훨씬 빠름
     */
    static int shellSort2(int[] arr, int n) {
        int cnt = 0;
        int h; // for문 밖에서 초기값 설정
        for (h = 1 ; h < n/9; h = h * 3 +1); // 조건에 맞는 h값 설정

        for ( ; h > 0; h /= 3) {
            for (int i = h; i < n; i++){
                int j;
                int tmp = arr[i];
                for (j = i - h; j >= 0 && arr[j] > tmp; j -= h) {
                    arr[j + h] = arr[j];
                    cnt++;
                }
                arr[j + h] = tmp;
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
        int num = shellSort2(arr, n);
        // 배열 출력
        //System.out.println("후 : " + Arrays.toString(arr));

        System.out.println("전 : " + Arrays.toString(newArr));
        int cnt = shellSort2(newArr, n);
        System.out.println("후 : " + Arrays.toString(newArr));

        System.out.println("교환 횟수 : "+cnt);
    }
}
