package chap05;

import chap04.IntStack;

// 비재귀적 recur 함수 구현
// 스텍을 활용한 재귀 제거 -> 숫자를 스택에 저장하면서 진행
public class RecurX2 {
    static void recur(int n) {
       IntStack stack = new IntStack(n);

       while (true){
           if (n > 0){
               stack.push(n); // 스택에 n의 값을 저장
               n -= 1;
               continue;
           }

           if (!stack.isEmpty()) {
               n = stack.pop(); // 스택에서 맨 위에 데이터를 불러옴
               System.out.println(n);
               n -= 2;  // 데이터 출력 후 2만큼 감소
               continue;
           }
           break;
       }
    }
    public static void main(String[] args) {
        int n = 4;
        recur(4);
    }
}
