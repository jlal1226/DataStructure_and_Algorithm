package chap04;

public class IntQueue {
    private int max; // que의 용량
    private int front; // 첫 번째 요소 커서
    private int rear; // 마지막 요소 커서
    private int num; // 현재 데이터 수
    private int[] que; // que 본체
    
    // 실행시 예외 처리 : 큐가 비어 있음
    public class EmptyIntQueException extends RuntimeException{
        public EmptyIntQueException(){}
    }
    // 실행시 예외 처리 : 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }
    
    // 생성자
    public IntQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max]; // que 본체용 배열 생성
        }catch (OutOfMemoryError e){ // 생성할 수 없음
            max = 0;
        }
    }

    // 큐에 데이터를 저장
    public int enque(int x) throws OverflowIntQueueException {
        if(num >= max)
            throw new OverflowIntQueueException(); // 큐가 가득 함

        que[rear++] = x;
        num++;
        if(rear == max) // 링 버퍼에서 최대값을 넘어가면 안됌
            rear = 0; // 0으로 초기화 -> 순환 구조
        return x;
    }

    // 큐에서 데이터를 반환
    public int deque() throws EmptyIntQueException {
        if(num <= 0)
            throw new EmptyIntQueException(); // 큐가 비었음
        
        int x = que[front++];
        num--;

        if(front == max) // 링 버퍼에서 최대값을 넘어가면 안됌
            front = 0; // 0으로 초기화 -> 순환 구조

        return x;
    }

    // 큐에서 데이터를 들여다봄
    public int peek() throws EmptyIntQueException {
        if(num <= 0)
            throw new EmptyIntQueException(); // 큐가 비어있음

        return que[front];
    }

    // 큐에서 x를 검색하여 index를 반환한다.
    public int indexOf(int x) {
        for(int i = 0; i < num; i++){
            int index = (i + front) % max;
            if(que[index] == x){
                return index;
            }
        }

        return -1;
    }

    // 큐에서 몇번째에 있는가
    public int search(int x){
        for(int i = 0; i < num; i++){
            if (que[(i + front) % max] == x) // 검색성공
                return i + 1;
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isFull() {
        return num >= max;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐의 모든 데이터를 front -> rear 순서로 출력
    public void dump() {
        if(num <= 0)
            System.out.println("큐가 비었습니다.");
        else {
            for(int i =0; i < num; i++){
                System.out.print(que[(i + front) % max]+" ");
            }
            System.out.println();
        }
    }
}
