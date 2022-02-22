package etc.dfs;

public class DFS_ex_01 {

    static boolean[] visited = new boolean[9];
    // 인덱스 번호 : 노드 번호 -> 0번 인덱스 노드는 없음
    // 1번 노드의 연결된 노드 : 2,3,8 / 2번 노드의 연결된 노드 : 1,6,8
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args) {
        dfs(1); // 1번 노드부터 탐색 시작
    }

    static void dfs(int nodeIndex) {
        // 방문 처리
        visited[nodeIndex] = true;

        // 방문 노드 출력
        System.out.print(nodeIndex + " -> ");

        for (int node : graph[nodeIndex]) {
            if (!visited[node]){
                dfs(node);
            }
        }
    }
}
