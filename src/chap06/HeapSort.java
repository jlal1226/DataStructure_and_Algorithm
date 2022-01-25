package chap06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapSort {
    static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    // arr[left] ~ arr[right]를 힙으로 만듬
    static void downHeap(int[] arr, int left, int right) {
        int tmp = arr[left];
        int child;
        int parent;

        for (parent = left; parent < (right+1) / 2; parent = child) {
            int cl = parent * 2 + 1; // 왼쪽 자식
            int cr = cl + 1; // 오른쪽 자식
            child = (cr <= right && arr[cr] > arr[cl])? cr : cl; // 큰 값을 가진 노드를 자식에 대입
            if (tmp >= arr[child])
                break;
            arr[parent] = arr[child];
        }
        arr[parent] = tmp;
    }
    // 힙 정렬
    static void heapSort(int[] arr, int n) {
        for (int i = (n-1) / 2; i >= 0; i--) {
            downHeap(arr, i, n-1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0 ,i);
            downHeap(arr, 0, i-1);
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
        heapSort(arr, num);
        System.out.println(Arrays.toString(arr));
    }
}
