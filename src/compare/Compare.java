package compare;

import java.util.ArrayList;
import java.util.Arrays;
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
        public int compareTo(Phone thatPhone) {

            calls++;
            String[] anotherVer = thatPhone.version.split("v");
            String[] thisVer = this.version.split("v");
            // java의 sort 알고리즘은 timSort 알고리즘을 사용한다
            // 이미 정렬됬다면 정렬을 추가로 하지 않는다
            // 7번 호출
            double dAnotherVer = Double.parseDouble(anotherVer[1]);
            double dThisVer = Double.parseDouble(thisVer[1]);
            System.out.println("호출된 횟수: " + calls);
//            if (dThisVer > dAnotherVer) {
//                return 1;
//            }
//
//            if (dThisVer < dAnotherVer) {
//                return -1;
//            }
//
//            return 0;
//            return Double.compare(dThisVer, dAnotherVer);
            return Double. valueOf(dThisVer).compareTo(Double. valueOf(dAnotherVer));
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "version='" + version + '\'' +
                    '}';
        }


    }

    public static void main(String[] args) {
        Phone p1 = new Phone("v2.00");
        Phone p2 = new Phone("v3.01");
        Phone p3 = new Phone("v6.02");
        Phone p4 = new Phone("v2.03");
        Phone p5 = new Phone("v2.04");
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
