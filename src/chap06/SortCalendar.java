package chap06;

import java.util.Arrays;
import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;

// 클래스 객체 배열의 정렬(병합 정렬)
// Arrays.sort()를 활용하여 자연 정렬하기 -> Object[]를 인자로 받음
// 병합 정렬을 개선한 알고리즘 -> 안전성 보장
public class SortCalendar {
    public static void main(String[] args) {
        GregorianCalendar[] x = {
                new GregorianCalendar(2017, NOVEMBER, 1),
                new GregorianCalendar(1963, OCTOBER, 18),
                new GregorianCalendar(1985, APRIL, 5)
        };
        // 자바에서 같은 타입의 인스턴스를 서로 비교해야만 하는 클래스들은 모두 Comparable 인터페이스를 구현하고 있음
        // GregorianCalendar 클래스 -> Arrays.sort() 사용 가능함
        Arrays.sort(x); // 오름차순 정렬
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%04d년 %02d년 %02d일\n", x[i].get(YEAR), x[i].get(MONTH) + 1, x[i].get(DATE));
        }
    }
}
