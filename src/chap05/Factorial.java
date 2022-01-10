package chap05;

import java.util.Scanner;

public class Factorial {

    static int factorial(int n){
/*        if (n > 0)
            return n * factorial(n-1);
        else
            return 1;*/


        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int input = scan.nextInt();

        System.out.println(input+" factorial : " + factorial(input));
    }
}
