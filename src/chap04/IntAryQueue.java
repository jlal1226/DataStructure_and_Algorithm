package chap04;

// 배열 요소를 앞쪽으로 옮기는 큐
public class IntAryQueue {
    private int max;
    private int num;
    private int[] que;

    public static class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException() {}
    }

    public static class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() {}
    }

    public IntAryQueue(int capacity){
        num = 0;
        this.max = capacity;
        try {
            que = new int[max];
        }catch (OutOfMemoryError e){
            max = 0;
        }
    }
    
    // 시간 복잡도 O(1)
    public int enQue(int x) throws OverflowIntStackException {
        return que[num++] = x;
    }
    
    // 시간복잡도 O(n)으로 성능이 좋지 않다
    // 배열 맨 앞의 요소를 꺼내고 모든 요소를 앞으로 한 칸씩 옮긴다
    public int deQue() throws EmptyIntStackException {
        return que[0];
    }

}
