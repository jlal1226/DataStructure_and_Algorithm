package chap05;

// 분기 한정법
// [규칙 1] 각 열에 퀸을 1개만 배치
// [규칙 2] 각 행에 퀸을 1개만 배치
// 262,144개의 조합 생성
public class QueenBB {
    static boolean[] flag = new boolean[8]; // 각 행에 퀸을 배치했는지 체크
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
        for (int j = 0; j < 8; j++) {
            if (!flag[i]){
                pos[i] = j;
                if (i == 7)
                    print();
                else {
                    flag[i] = true; // j행에 퀸을 배치하면
                    set(i+1);
                    flag[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        set(0);
    }
}
