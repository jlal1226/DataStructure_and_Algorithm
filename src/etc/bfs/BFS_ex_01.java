package etc.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 사용 예: 최단 경로
// 재귀적으로 동작하지 않는다.
// 선입선출
// 큐를 이용해서 구현
public class BFS_ex_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 정점
        int m = scan.nextInt(); // 간선
        int v = scan.nextInt(); // 탐색을 시작할 정점의 번호

        boolean[] visited = new boolean[n+1];
        int[][] adjArray = new int[n+1][n+1];

        // 2차원 배열로 그래프 구현
        for (int i = 0; i < m; i++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            adjArray[v1][v2] = 1;
            adjArray[v2][v1] = 1;
        }
        bfs_array(v, adjArray, visited);

    }
    public static void bfs_array(int v, int[][] adjArray, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int n = adjArray.length - 1;

        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()) {
            v = q.poll(); // 큐에서 첫번째 요소를 꺼냄
            System.out.print(v + " ");

            for (int i = 1; i <= n; i++) {
                if (adjArray[v][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }

            }
        }
    }
}
