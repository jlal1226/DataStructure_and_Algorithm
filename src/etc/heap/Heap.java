package etc.heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

// 최소 힙
public class Heap<E> {

    private final Comparator<? super E> comparator;

    // 기본 크기 -> 배열을 동적으로 관리할 때 최소 크기가 10 미만으로 내려가지 않기 위한 변수
    private static final int DEFAULT_CAPACITY = 10;

    private int size; // 요소 개수

    private Object[] array; // 요소를 담을 배열

    // 셍성자 Type 1 (초기 공간 할당 x)
    public Heap() {
        this(null);
    }
    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    // 생성자 type 2 (초기 공간 할당 o)
    public Heap(int capacity) {
        this(capacity, null);
    }
    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    // 받은 인덱스의 부모 노드 인덱스를 반환
    private int getParent(int index) {
        return index / 2;
    }

    // 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
    private int getLeftChild(int index) {
        return index * 2;
    }

    // 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    private void resize(int newCapacity) {

        // 새로 만들 배열
        Object[] newArray = new Object[newCapacity];

        // 새 배열에 기존에 있던 배열의 요소들을 모두 복사해준다.
        for(int i = 1; i <= size; i++) {
            newArray[i] = array[i];
        }

        /*
         *  현재 배열은 GC 처리를 위해 null로 처리한 뒤,
         *  새 배열을 연결해준다.
         */
        this.array = null;
        this.array = newArray;
    }

    public void add(E value) {

        if (size + 1 == array.length) {
            resize(array.length * 2);
        }

        shiftUp(size + 1, value);
        size++;
    }

    private void shiftUp(int index, E target) {
        if (comparator != null) {
            shiftUpComparator(index, target, comparator);
        }
        else {
            shiftUpComparable(index, target);
        }
    }

    // Compatator를 이용한 shift-up
    private void shiftUpComparator(int index, E target, Comparator<? super E> comp) {
        while (index > 1) {
            int parent = getParent(index); // 삽입 노드의 부모노드 인덱스
            Object parentVal = array[parent]; // 부모 노드 값

            // 부모노드가 target보다 작으면 종료
            if (comp.compare(target, (E) parentVal) >= 0) {
                break;
            }

            array[index] = parentVal;
            index = parent;
        }
        array[index] = target; // 타켓 저장
    }

    private void shiftUpComparable(int index, E target) {
        // 타겟노드가 비교 될 수 있도록 한 변수를 만든다.
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while(index > 1) {
            int parent = getParent(index);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0) {
                break;
            }
            array[index] = parentVal;
            index = parent;
        }
        array[index] = comp;
    }

    public E remove() {
        if (array[1] == null) {
            throw new NoSuchElementException();
        }
        E result = (E) array[1]; // 삭제된 요소를 반환하기 위한 임시 변수
        E target = (E) array[size];
        array[size] = null;

        shiftDown(1, target);

        return result;
    }

    private void shiftDown(int index, E target) {
        // comparator가 존재할 경우 comparator 을 인자로 넘겨준다.
        if(comparator != null) {
            siftDownComparator(index, target, comparator);
        }
        else {
            siftDownComparable(index, target);
        }
    }

    private void siftDownComparator(int index, E target, Comparator<? super E> comp) {
        array[index] = null; // 삭제 할 인덱스의 노드를 삭제
        size--;

        int parent = index;
        int child;

        while ((child = getLeftChild(parent)) <= size) {
            int right = getRightChild(index);

            Object childVal = array[child];

            if(right <= size && comp.compare((E) childVal, (E) array[right]) > 0) {
                child = right;
                childVal = array[child];
            }
            if(comp.compare(target ,(E) childVal) <= 0){
                break;
            }
            array[parent] = childVal;
            parent = child;
        }
    }

    private void siftDownComparable(int idx, E target) {

        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while((child = getLeftChild(parent)) <= size) {

            int right = getRightChild(parent);

            Object childVal = array[child];

            if(right <= size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) > 0) {
                child = right;
                childVal = array[child];
            }

            if(comp.compareTo((E) childVal) <= 0){
                break;
            }
            array[parent] = childVal;
            parent = child;

        }
        array[parent] = comp;

        if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

    }
}
