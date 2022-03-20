package chap06;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeArray {
    // 배열 2개를 병합하는 함수
    static void merge(int[] a, int[] b, int[] c) {
        int pa = 0, pb = 0, pc = 0;
        int len_a = a.length;
        int len_b = b.length;
        // 크기가 작은 요소를 c 배열에 복사
        while (pa < len_a && pb < len_b) {
            int tmp = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
            c[pc++] = tmp;
        }
        // 나머지 요소 복사
        while (pa < len_a) {
            c[pc++] = a[pa++];
        }
        // 나머지 요소 복사
        while (pb < len_b) {
            c[pc++] = b[pb++];
        }
    }
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 11, 13};
        int[] b = {1, 2, 3, 4, 9, 16, 21};
        int[] c = new int[a.length + b.length];
        merge(a,b,c);
        System.out.println(Arrays.toString(c));
    }
}
