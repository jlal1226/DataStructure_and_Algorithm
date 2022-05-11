package chap08;

public class BMmatch {
    /**
     * Boyer-Moore 법
     * KMP법보다 효율이 더 좋은 문자열 검색 알고리즘
     *
     * [검색 방법]
     * 1. 패턴의 마지막 문자부터 앞쪽으로 검사를 진행한다
     * 2. 일치하지 않는 문자가 있으면 미리 준비한 표에 따라 패턴을 옮길 크기를 정한다
     *
     * [표 만드는 방법]
     * 검색 필요
     */
    public static void main(String[] args) {
        String txt = "ABABCDEFGHA";
        String pat = "ABC";
        int result = bmMatch(txt, pat);
        System.out.println(result);
    }


    static int bmMatch(String txt, String pat) {

        int pt; // txt pointer
        int pp; // pattern pointer
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        // 건너뛰기 표 만들기 -> 뭔가 이상함
        for (pt = 0; pt <= Character.MAX_VALUE; pt++) {
            skip[pt] = patLen;
        }
        for (pt = 0; pt < patLen - 1; pt++) {
            skip[pat.charAt(pt)] = patLen - pt - 1;
        }

        // 검색
        while (pt < txtLen) {
            pp = patLen - 1;

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0) {
                    return pt; // 검색 성공
                }
                pp--;
                pt--;
            }
            pt += Math.max(skip[txt.charAt(pt)], patLen - pp);
        }
        return -1;
    }
}
