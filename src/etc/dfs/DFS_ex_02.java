package etc.dfs;

import java.util.LinkedList;
import java.util.Stack;
// 스택을 활용한 DFS 구현
class Graph {
    int vertex;
    LinkedList<Integer> list[];

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        // 노드와 노드를 연결
        list[source].addFirst(destination); // 가장 왼쪽에 값을 저장
        list[destination].addFirst(source);
    }

    public void DFS(int start) {
        System.out.println("Depth First Traversal: ");
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;
                for (int i = 0; i < list[v].size(); i++) {
                    int dest = list[v].get(i); // 인접 요소를 꺼내옴
                    if(!visited[dest])
                        stack.push(dest); // 스택에 인접 요소 저장 -> 후입 선출
                }
            }
        }
    }

    public void printGraph(){
        for (int i = 0; i < vertex; i++) {
            LinkedList<Integer> nodeList = list[i];
            if (!nodeList.isEmpty()) {
                System.out.print("source = " + i + " is connected to nodes :");
                for (int j = 0; j < nodeList.size(); j++) {
                    System.out.print(" " + nodeList.get(j));
                }
            }
            System.out.println();
        }
    }
}

public class DFS_ex_02 {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.printGraph();
        graph.DFS(0);
    }
}
