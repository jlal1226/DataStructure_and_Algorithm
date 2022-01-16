package chap06;

import chap04.IntStack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 비재귀적으로 구현한 퀵 정렬
public class QuickSort_Q12 {
    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    // 스택을 활용항 비재귀적 퀵 정렬
    static void quickSort(int[] arr, int left, int right) {
        // 스택 2개가 붙어있다고 생각하자
        IntStack lStack = new IntStack(right - left + 1);
        IntStack rStack = new IntStack(right - left + 1);
        lStack.push(left);
        rStack.push(right);

        // 스택이 비어있으면 종료
        while (!lStack.isEmpty()) {
            // 스택에서 커서 값을 받아옴
            int pl = left =  lStack.pop();
            int pr = right = rStack.pop();
            int pivot = arr[(pl + pl) / 2];

            // 그룹 나누기
            do {
                while (arr[pl] < pivot) pl++;
                while (pivot < arr[pr]) pr--;
                if (pl <= pr)
                    swap(arr, pl++, pr--);
            } while (pl <= pr);

            // 요소의 개수가 적은 그룹을 나중에 스택에 저장 -> 스택에 쌓이는 데이터의 최대 개수가 log n 보다 작음
            // 요소의 개수가 백만 개여도 스택의 최대 용량은 20개면 충분해짐
            if ((pr - left) < (right - pl)) { // 왼쪽 그룹의 요소 개수가 적으면 그룹간 index 교환
                int tmp = left;
                left = pl;
                pl = tmp;

                tmp = pr;
                pr = right;
                right = tmp;
            }

            // 스택에 왼쪽 그룹의 시작과 끝 index 저장
            if (left < pr) {
                lStack.push(left);
                rStack.push(pr);
            }
            // 스택에 오른쪽 그룹의 시작과 끝 index 저장
            if (pl < right) {
                lStack.push(pl);
                rStack.push(right);
            }
            // 반복문에 의해 stack에 저장된 시작과 끝 index를 꺼내서 정렬 수행 -> 비재귀적 퀵 정렬 수행
        }
    }

    // 연습문제 Q.10 -> 매개변수로 n만 받아서 quickSort() 구현하기
    static void quickSort(int[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.print("요소수 : ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        // 1 ~ 50 랜덤 요소 생성
        for (int i = 0; i < n; i++){
            arr[i] = rand.nextInt(50) + 1;
            for (int j = 0; j < i; j++){
                if (arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }
        // 배열 출력
        System.out.println("전 : " + Arrays.toString(arr));
        // 선택 정렬
        quickSort(arr, n);
        // 배열 출력
        System.out.println("후 : " + Arrays.toString(arr));
    }
}
