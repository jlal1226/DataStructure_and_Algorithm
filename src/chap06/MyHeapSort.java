package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 힙 정렬 -> 안정적이지 않은 정렬
// 완전 이진 트리
public class MyHeapSort {
    // 부모 인덱스를 얻는 함수
    private static int getParent(int child) {
        return (child - 1) / 2; // 배열이 0부터 시작하므로
    }

    // 요소 교환 함수
    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void heapSort(int[] arr) {
        int size = arr.length;

        if (size < 2)
            return;

        // 가장 마지막 노드의 부모 노드 인덱스
        int parentIdx = getParent(size - 1);

        // 초기 배열을 max 힙으로 만들기 -> 시간 복잡도 : O(N)
        for (int i = parentIdx; i >= 0; i--) {
            // 부모 노드를 1씩 줄이면서 heap 조건을 만족하도록 구성
            heapify(arr, i, size-1);
        }

        // 정렬 과정
        for (int i = size - 1; i > 0; i--) {
            // root인 0번째 인덱스와 i번째 인덱스 값을 교환
            // 0 ~ (i-1) 까지의 부분트리에 대해 max heap 재구성
            swap(arr, 0, i);
            heapify(arr, 0, i - 1); // 시간 복잡도 : O(nlogn)
        }
    }

    private static void heapify(int[] a, int parentIdx, int lastIdx) {
        // 자식 인덱스
        int leftChildIdx = parentIdx * 2 + 1;
        int rightChildIdx = parentIdx * 2 + 2;
        int largestIdx = parentIdx; // 현재 부모 인덱스에 가장 큰 값이 있다고 가정

        // left child node와 비교
        // 왼쪽 자식 노드의 값이 더 큰 경우 largestIdx를 자식 인덱스로 바꾼다
        if (leftChildIdx < lastIdx && a[leftChildIdx] > a[largestIdx])
            largestIdx = leftChildIdx;

        // right child node와 비교
        // 오른쪽 자식 노드의 값이 더 큰 경우 largestIdx를 자식 인덱스로 바꾼다
        if (rightChildIdx < lastIdx && a[rightChildIdx] > a[largestIdx])
            largestIdx = rightChildIdx;

        // 부모 노드 값보다 큰 자식 노드가 있으면
        // 부모 노드와 자식 노드를 교환하고
        // 교환된 자식 노드를 부모 노드로 삼는 서브트리를 검사하도록 재귀 호출
        if (parentIdx != largestIdx) {
            swap(a, largestIdx, parentIdx);
            heapify(a, largestIdx, lastIdx); // top-down 재귀 호출 발생 -> 성능 저하 -> bottom-up 방식으로 성능 개선 가능
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("요솟수 : ");
        int num = scan.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++){
            arr[i] = rand.nextInt(50) + 1;
            for (int j = 0; j < i; j++){
                if (arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
