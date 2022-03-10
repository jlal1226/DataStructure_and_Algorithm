package etc.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_ex_02 {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4};
        boolean[] visit = {false, false, false, false, false};
        BFS(numbers, 0, visit);
    }
    static void BFS(int[] numbers, int start, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()) {
            int next = queue.poll();
            System.out.println(next);
            for(int i : numbers) {
                if(!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}
