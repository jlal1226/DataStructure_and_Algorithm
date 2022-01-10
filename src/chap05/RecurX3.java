package chap05;

import java.util.Stack;

public class RecurX3 {
    static void recur3(int n) {
        // 재귀적 -> 비재귀적으로 변경
/*        if (n > 0) {
            recur3(n-1);
            recur3(n-2);
            System.out.println(n);
        }*/
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)
                    n = n - 1;
                else if (sw == 1) {
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if (sw == 2) {
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }

    }
    public static void main(String[] args) {
        int n = 4;
        recur3(n);
    }
}
