package chap05;

public class EightQueenUI {
    static int[] pos = new int[8]; // 열에 퀸을 배치
    static boolean[] flag_a = new boolean[8]; // 행에 퀸이 배치되었는지 체크
    static boolean[] flag_b = new boolean[15]; // 오른쪽 위 대각선에 퀸이 배치됬는지 체크
    static boolean[] flag_c = new boolean[15]; // 오른쪽 아래 대각선엔 퀸이 배치됬는지 체크
    static int cnt = 1;
    static void print() {
        System.out.println("["+cnt++ + "번째 조합]");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (pos[i] == j)
                    System.out.print("■  ");
                else
                    System.out.print("□  ");
            }
            System.out.println();
        }
        for (int i = 0; i < 8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
        System.out.println();

    }

    static void set(int i) {
        for (int j = 0; j < 8; j++){
            if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]){
                pos[j] = i;
                if (i == 7)
                    print();
                else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        set(0);
    }
}
