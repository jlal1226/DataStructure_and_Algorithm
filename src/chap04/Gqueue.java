package chap04;

// 제네릭 큐 클래스
public class Gqueue<E> {
    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;

    // 실행할 때 예외：큐가 비어 있음
    public static class EmptyQueException extends RuntimeException {
        public EmptyQueException() {}
    }

    // 실행할 때 예외 : 큐가 가득 참
    public static class OverflowQueException extends RuntimeException {
        public OverflowQueException() {}
    }

    public Gqueue(int capacity) {
        max = capacity;
        num = front = rear = 0;
        try{
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public E enque(E x){
        if(num > max){
            throw new OverflowQueException();
        }
        que[rear++] = x;
        num ++;

        if(rear == max)
            rear = 0;
        return x;
    }

    public E deque(){
        if(num <= 0){
            throw new EmptyQueException();
        }
        E x = que[front++];

        if(front == max)
            front = 0;
        return x;
    }

    // 큐 안에서 데이터가 몇번째에 있는가가
    public int search(E x){
        for(int i = 0; i < num; i++){
            if (x == que[(front+i) % max]) {
                return i;
            }
        }
        return -1;
    }

    public void dump(){
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");

        for(int i = 0; i < num; i++){
            System.out.print(que[(front + i) % max]);
        }
        System.out.println();
    }
}
