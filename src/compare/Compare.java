package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Compare {

    private static int calls = 0;

    private static class Phone implements Comparable<Phone> {
        String version;

        public Phone(String version) {
            this.version = version;
        }

        @Override
        public int compareTo(Phone thisPhone) {

            calls++;
            String[] versionArr = thisPhone.version.split("\\.");
            // java의 sort 알고리즘은 timSort 알고리즘을 사용한다
            // 이미 정렬됬다면 정렬을 추가로 하지 않는다
            System.out.println("호출된 횟수: " + calls);

            for (String version : versionArr) {
                int ver = Integer.parseInt(version);

            }

            return 0;
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "version='" + version + '\'' +
                    '}';
        }


    }

    public static void main(String[] args) {
        Phone p1 = new Phone("2.00");
        Phone p2 = new Phone("3.01");
        Phone p3 = new Phone("6.02");
        Phone p4 = new Phone("2.03");
        Phone p5 = new Phone("2.04");
        List<Phone> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        System.out.println(list);
        // Comparable<? super T> , 반드시 구현해야하며 구현하지 않으면 컴파일러가 예측에 실패해서 컴파일 에러가 발생한다
        Collections.sort(list);
        System.out.println("sorted list : " + list);

    }
}
