package etc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class MyInteger{
    int num;

    public MyInteger(int num) {
        this.num = num;
    }
}

public class ComparatorSort {
    public static void main(String[] args) {
        Random rand = new Random();


        MyInteger[] arr = new MyInteger[10];

        for(int i = 0; i < 10; i++) {
            arr[i] = new MyInteger((int)rand.nextInt(50)+1);
        }

        System.out.println("정렬 전");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i].num+" ");
        }
        System.out.println();

        Arrays.sort(arr,comp);

        System.out.println("정렬 후");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i].num+" ");
        }

    }

    static Comparator<MyInteger> comp = new Comparator<MyInteger>() {

        @Override
        public int compare(MyInteger o1, MyInteger o2) {
            // 오름차순
            return o1.num - o2.num;
        }

    };
}
