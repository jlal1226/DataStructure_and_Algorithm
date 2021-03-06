package chap04;

import java.util.Scanner;

public class IntQueueTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntQueue s = new IntQueue(64);

        System.out.println("================================");
        System.out.println("        IntQueueTester");
        System.out.println("================================");

        // 실험 데이터 삽입
        for(int i = 0; i < 20; i++){
            s.enque(i);
            if(i%3 == 0)
                s.deque();
        }
        s.dump();

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + "/" + s.capacity());
            System.out.print("(1) enque (2) deque (3) peek (4) dump (5) search (0) exit > ");
            int menu = scan.nextInt();

            if (menu == 0) {
                System.out.println("종료합니다.");
                break;
            }
            int x;
            switch (menu) {
                case 1:
                    System.out.print("data > ");
                    x = scan.nextInt();
                    try {
                        s.enque(x);
                    } catch (IntQueue.OverflowIntQueueException e) {
                        System.out.println("큐가 가득 찾습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.deque();
                        System.out.println("deque한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("peek한 데이터는 " + x + "입니다.");
                    } catch (IntQueue.EmptyIntQueException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    System.out.print("찾을 데이터 > ");
                    int input = scan.nextInt();
                    System.out.println(input+"은 큐에서 "+s.search(input)+"번째에 있습니다.");
                    System.out.println(input+"은 큐에서 "+s.indexOf(input)+"번째에 있습니다.");
                    break;
            }
        }
    }
}
