package chap06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyscExamSort {
    static class PhyscData {
        String name;
        int height;
        double vision;

        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
        // comparator 활용 -> 키에 대해 오름차순 정렬
        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return o1.height - o2.height;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PhyscData[] x = {
          new PhyscData("김정락", 173, 0.9),
          new PhyscData("김동휘", 160, 0.9),
          new PhyscData("정민수", 171, 0.9),
          new PhyscData("이성준", 165, 0.9)
        };
        Arrays.sort(x, PhyscData.HEIGHT_ORDER);
        for (PhyscData p : x) {
            System.out.println(p.toString());
        }
    }
}
