package etc.graph;

import java.util.ArrayList;

class AdjacentList {
    ArrayList<ArrayList<Integer>> graph;

    public AdjacentList(int initSize) {
        graph = new ArrayList<>();
        initGraph(initSize);
    }

    public void initGraph(int initSize) {
        for (int i = 0; i < initSize + 1; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // 단방향 연결
    public void putSingle(int x, int y) {
        graph.get(x).add(y);
    }

    // 양방향 연결
    public void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    // 그래프 출력
    public void printGraph() {
        for (int i = 1; i < graph.size(); i++) {
            System.out.print("[" + i + "]");
            for (int index : graph.get(i)) {
                System.out.print(" -> " + index);
            }
            System.out.println();
        }
    }

}

public class Graph_Ex1 {

    public static void main(String[] args) {
        int initSize = 5;
        AdjacentList adjacentList = new AdjacentList(initSize);

        adjacentList.put(1, 2);
        adjacentList.put(1, 3);
        adjacentList.put(2, 5);
        adjacentList.put(3, 4);
        adjacentList.put(3, 5);
        adjacentList.put(4, 5);

        adjacentList.printGraph();
    }

}
