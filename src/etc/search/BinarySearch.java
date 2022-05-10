package etc.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 5, 7, 9, 12, 16, 19, 23};
        int result1 = binarySearchByRecursion(16, array, 0, array.length);
        int result2 = binarySearch(16, array);
        System.out.println(result1);
        System.out.println(result2);
    }

    // 정렬된 배열에서 값을 탐색하는 알고리즘
    // 배열의 중간 값을 기준으로 왼쪽 구간 또는 오른쪽 구간을 선택하여 탐색
    // 구현 방법 : 반복문, 재귀 호출

    // 방법 1 : 반복문
    public static int binarySearch(int key, int[] array) {

        int left = 0;
        int right = array.length;

        while (left <= right) {
            int mid = (left + right) / 2; // 중간 값
            int midValue = array[mid];

            if (key == midValue) {
                return mid;
            }

            if (key < midValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // 방법 2 : 재귀 호출
    public static int binarySearchByRecursion(int key, int[] array, int left, int right) {
        // 종료 조건
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = array[mid];

        if (key < midValue) { // 왼쪽 구간 탐색
            return binarySearchByRecursion(key, array, left, mid - 1);
        } else if (key > midValue) { // 오른쪽 구간 탐색
            return binarySearchByRecursion(key, array, mid + 1, right);
        } else {
            return mid;
        }
    }
}
