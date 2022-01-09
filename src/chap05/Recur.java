package chap05;

public class Recur {
    /*
    하향식 분석 vs 상향식 분석

    1. 하향식 분석 : 위쪽부터 분석하는 방법
        예) recur(4) -> recur(3) "4" recur(2) : recur(3)이 먼저 실행되므로
        recur(3) -> recur(2) "2" recur(1)
                (생략)
        결과적으로 1 2 3 1 4 1 2 출력

    2. 상향식 분석 : 아래쪽부터 쌓아 올리며 분석하는 방법 -> 하향식 분석에서 중복된 부분을 제거할 수 있음
        예) recur(1) : recur(0) "1" recur(-1) -> 1
            recur(2) : recur(1) "2" recur(0) -> 1 2
            recur(3) : recur(2) "3" recur(1) -> 1 2 3 1
            recur(4) : recur(3) "4" recur(2) -> 1 2 3 1 4 1 2
     */

    static void recur(int n) {
        if (n > 0){
            recur(n-1);
            System.out.println(n);
            recur(n-2);
        }
    }
    public static void main(String[] args) {
        int n = 4;
        recur(4);
    }
}
