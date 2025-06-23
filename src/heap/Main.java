package heap;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(5);
//        pq.add(3);
//        pq.add(2);
//        pq.add(1);
//        pq.add(4);
//        Integer p1 = pq.poll();
//        Integer p2 = pq.poll();
//        Integer p3 = pq.poll();
//        Integer p4 = pq.poll();
//        Integer p5 = pq.poll();

        // Heap 구현체도 같은 동작을 해야함
//        JavaHeap<Integer> pq = new JavaHeap<>();
        Heap<Integer> pq = new Heap<>();
        pq.insert(5);
        pq.insert(3);
        pq.insert(2);
        pq.insert(1);
        pq.insert(4);
        Integer p1 = pq.delete();
        Integer p2 = pq.delete();
        Integer p3 = pq.delete();
        Integer p4 = pq.delete();
        Integer p5 = pq.delete();

        // [1, 2, 3, 5, 4] (o)
        // pq.print();
        // 1,2,3,4,5
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("p3 = " + p3);
        System.out.println("p4 = " + p4);
        System.out.println("p5 = " + p5);
    }
}
