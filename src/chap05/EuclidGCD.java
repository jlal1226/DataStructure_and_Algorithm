package chap05;

import java.util.Scanner;

// 유클리드 호제법 실습
public class EuclidGCD {

    static int gcd(int x, int y){
        // 두번째 인자로 x % y를 받았을때 나머지가 0이면 종료
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("정수 x를 입력하세요 : ");
        int x = scan.nextInt();

        System.out.print("정수 y를 입력하세요 : ");
        int y = scan.nextInt();

        System.out.printf("%d와 %d의 최대 공약수 : %d", x, y, gcd(x,y));
    }
}
