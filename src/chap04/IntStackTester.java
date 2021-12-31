package chap04;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntStack s = new IntStack(64);
        System.out.println("================================");
        System.out.println("        IntStackTester");
        System.out.println("================================");
        System.out.println();
        while(true){
            System.out.println("현재 데이터 수 : " + s.size() + "/" + s.capacity());
            System.out.print("(1) push (2) pop (3) peek (4) dump (0) exit > ");
            int menu = scan.nextInt();

            if(menu == 0) {
                System.out.println("종료합니다.");
                break;
            }
            int x;
            switch (menu){
                case 1:
                    System.out.print("data > ");
                    x = scan.nextInt();
                    try{
                        s.push(x);
                    }catch (IntStack.OverflowIntStackException e){
                        System.out.println("스택이 가득 찾습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("pop한 데이터는 "+ x + "입니다.");
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("peek한 데이터는 " + x + "입니다.");
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }

        }
    }
}
