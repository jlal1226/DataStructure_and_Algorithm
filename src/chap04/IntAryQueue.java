package chap04;

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

    public int enQue(int x) throws OverflowIntStackException {
        return que[num++] = x;
    }

    public int deQue() throws EmptyIntStackException {
        return que[0];
    }

}
