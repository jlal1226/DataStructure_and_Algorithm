package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    // 배열 2개를 병합하는 함수
    static void merge(int[] a, int na, int[] b, int nb, int[] c) {
        // 커서를 0으로 초기화
        int pa = 0;
        int pb = 0;
        int pc = 0;
        // 배열 a,b에서 작은 요소를 배열 c에 저장하고 커서 이동
        while (pa < na && pb < nb)
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
        // 배열 c에 저장되지 않은 나머지 요소를 배열 c로 복사
        while (pa < na)
            c[pc++] = a[pa++];
        while (pb < nb)
            c[pc++] = b[pb++];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = {2, 4, 6, 8, 11, 13};
        int[] b = {1, 2, 3, 4, 9, 16, 21};
        int[] c = new int[13];

        merge(a, a.length, b, b.length, c);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}
