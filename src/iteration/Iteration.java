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

    }
}
