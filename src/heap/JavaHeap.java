package heap;

public class JavaHeap<E> implements PriorityQueue<E>{

    private final java.util.PriorityQueue<E> pq = new java.util.PriorityQueue<E>();

    @Override
    public void insert(E e) {
        pq.add(e);
    }

    @Override
    public E delete() {
        return pq.poll();
    }
}
