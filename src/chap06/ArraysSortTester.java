package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysSortTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("요솟수 : ");
        int num = scan.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++){
            arr[i] = rand.nextInt(50) + 1;
            for (int j = 0; j < i; j++){
                if (arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        // 퀵 정렬을 개선한 알고리즘 -> 안정적이지 않다 -> 값이 같은 요소의 순서가 바뀔 수 있음
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
