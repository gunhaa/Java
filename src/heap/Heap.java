package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap<E extends Comparable<E>> implements PriorityQueue<E> {

    /*
    heap은 트리로 구성되어 있다
    max heap: 부모 노드가 자식 노드보다 항상 크거나 같은 완전 이진 트리
    min heap: 부모 노드가 자식 노드보다 항상 작거나 같은 완전 이진 트리
    완전 이진 트리이기에, bfs의 순서로 insert시 채워진다(들어갈 곳이 정해지고, 이를 통해 거슬러 올라가는 방식으로 insert된다)
    delete() 호출시 root노드를 꺼내며, bfs방식으로 가장 밑의 노드를 root에 넣은 뒤 더 큰 자식과 교환한다,
    트리 구조의 자식 노드 중 더 큰 값과 자리를 바꾸며 밑으로 내려간다
    */

    private List<E> heap = new ArrayList<>();

    public Heap() {
    }

    @Override
    public void insert(E e) {
        heap.add(e);
        int lastIdx = heap.size() -1;
        while(lastIdx > 0) {
            int parentIdx = (lastIdx - 1) / 2;
            if(heap.get(lastIdx).compareTo(heap.get(parentIdx)) >= 0) {
                break;
            }
            swap(lastIdx, parentIdx);
            lastIdx = parentIdx;
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public E delete() {
        if(heap.isEmpty()) {
            return null;
        }

        if(heap.size() == 1) {
            return heap.removeFirst();
        }


        E removedValue = heap.get(0);
        E lastValue = heap.remove(heap.size() - 1);
        heap.set(0, lastValue);

        int currentIdx = 0;
        int size = heap.size();

        while (true) {
            int leftIdx = 2 * currentIdx + 1;
            int rightIdx = 2 * currentIdx + 2;
            int smallestIdx = currentIdx;

            if (leftIdx < size && heap.get(leftIdx).compareTo(heap.get(smallestIdx)) < 0) {
                smallestIdx = leftIdx;
            }

            if (rightIdx < size && heap.get(rightIdx).compareTo(heap.get(smallestIdx)) < 0) {
                smallestIdx = rightIdx;
            }

            if (smallestIdx == currentIdx) {
                break;
            }

            swap(currentIdx, smallestIdx);
            currentIdx = smallestIdx;
        }

        return removedValue;
    }

    public void print() {
        System.out.println(heap);
    }

}
