package iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iteration {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            list.add(i);
        }
        try {
            for (int i = 0; i < 3; ++i) {
                if (!(list.indexOf(i) == i)) {
                    throw new IllegalStateException("망한 상태");
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("exception 던져서 이곳까지 stackframe이 unwind됬음");
        }

        System.out.println("언와인드 되고 계속 진행됬음");

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            // iterator는 java가 최적화 시키지 못함
            Integer value = iterator.next();
            System.out.println("iterator value: " + value);
        }

        Iteration iteration = new Iteration();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        // 이런게되네
        SomeIter s1 = iteration.new SomeIter(list1);
        while (s1.hasNext()) {
            int value = s1.next();
            System.out.println("iterator implements: " + value);
        }
    }

    private class SomeIter implements Iterator<Integer>{
        List<Integer> list;
        int index = 0;

        public SomeIter(List<Integer> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }
    }
}
