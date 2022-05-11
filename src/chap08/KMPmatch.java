package chap08;

public class KMPmatch {
    /*
    KMP법 : 다른 문자를 만나면 패턴을 1칸씩 옮긴 다음 다시 패턴의 처음부터 검사하는 브루트포스법과는 다르게
            중간 검사 결과를 효율적으로 사용하는 알고리즘
    -> 검사했던 위치 결과를 버리지 않고 효율적으로 활용
     */
    public static void main(String[] args) {
        String txt = "ZABCABXACCADEFABCABDX";
        String pat = "ABCABD";
        int num = kmpMatch(txt, pat);
        System.out.println("패턴 시작 index : " + num);
    }
    static int kmpMatch(String txt, String pat) {
        int pt = 1; // txt 커서 -> 건너뛰기 표 작성을 위해 1로 초기화
        int pp = 0; // pattern 커서
        int[] skip = new int[pat.length() + 1]; // 건너뛰기 표 -> [0, 0, 0, 1, 2, 0]

        // 건너뛰기 표 생성
        skip[pp] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp)) // 패턴 발견하면
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }

        // 검색
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0) {
                pt++;
            } else // 패턴 발견되면
                pp = skip[pp]; // 건너뛰기 표를 참고해서 pp 값 수정
        }
        if (pp == pat.length())
            return pt - pp;
        return -1;
    }
}
