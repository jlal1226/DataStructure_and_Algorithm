package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Fsort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = scan.nextInt();
        int[] arr = new int[nx];

        // 1 ~ 50 랜덤 요소 생성
        for (int i = 0; i < nx; i++){
            arr[i] = rand.nextInt(50) + 1;
            for (int j = 0; j < i; j++){
                if (arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }

        // 최대값 설정
        int max = arr[0];
        for (int i = 1; i < nx; i++) {
            if (arr[i] > max) max = arr[i];
        }

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(arr));
        // 도수 정렬
        fSort(arr, nx, max);

        System.out.println("정렬 완료");
        System.out.println(Arrays.toString(arr));
    }

    static void fSort(int[] arr, int n, int max) {
        int[] f = new int[max+1];
        int[] b = new int[n];

        // 1단계 : 도수분포표 만들기
        for (int i = 0; i < n; i++) {
            f[arr[i]]++;
        }
        // 2단계 : 누적도수분포표 만들기
        for (int i = 1; i <= max; i++) {
            f[i] += f[i-1];
        }
        // 3단계 : 목적 배열 만들기
        for (int i = 0; i < n; i++) {
            b[--f[arr[i]]] = arr[i];
        }
        // 4단계 : 배열 복사하기
        for (int i = 0; i < n; i++) {
            arr[i] = b[i];
        }
    }
}
