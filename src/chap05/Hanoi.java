package chap05;

import java.util.Scanner;

public class Hanoi {
    static int count = 0;

    // n-1개의 원반을 그룹화하여 이동시킴
    // 시간 복잡도 : O(2^n - 1)
    static void hanoi(int n, int start, int dest){
        if (n > 0){
            // n-1개의 원반을 start에서 나머지 기둥으로 이동
            hanoi(n-1, start, 6 - start - dest);
            // n번째 기둥을 이동
            System.out.printf("%d를 %d 기둥에서 %d 기둥으로 이동\n", n, start, dest);
            count++;
            // n-1개의 원반을 나머지 기둥에서 dest로 이동
            hanoi(n-1, 6 - start - dest, dest);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("정수를 입력 : ");
        int n = scan.nextInt();

        hanoi(n, 1, 3);
        System.out.println("이동 횟수 : " + count);
    }
}
