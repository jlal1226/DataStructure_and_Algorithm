package chap08;

import java.util.Scanner;

public class BFmatch {
    // 브루트-포스법으로 문자열을 검색하는 함수
    static int bfMatch(String txt, String pat) {
        int pt = 0; // txt 커서
        int pp = 0; // pat 커서

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length()) {
            return pt - pp;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("text : ");
        String txt = scan.next();

        System.out.print("pattern : ");
        String pat = scan.next();

        int index = bfMatch(txt, pat);

        System.out.println(index);
    }
}
