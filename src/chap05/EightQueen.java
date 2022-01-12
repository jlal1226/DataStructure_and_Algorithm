package chap05;

// [규칙 1] 각 열에 퀸을 1개만 배치
// [규칙 2] 각 행에 퀸을 1개만 배치
// [규칙 3] 대각선으로 퀸
// 92개의 조합
public class EightQueen {
    static boolean[] flag_a = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15]; // 오른쪽 위 방향으로 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15]; // 오른쪽 아래 방향으로 퀸을 배치했는지 체크
    static int[] pos = new int[8]; // 각 열의 퀸의 위치

    // 각 열의 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    // i열에 알맞은 위치에 퀸을 배치
    // 각은 행에 퀸을 배치하지 않도록 flag 활용
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
