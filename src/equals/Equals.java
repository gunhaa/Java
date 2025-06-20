package equals;

import java.util.HashSet;

public class Equals {
    private static class StringWrapper1 {
        static String str = "hello";
    }

    private static class StringWrapper2 {
        static String str = "hello";
    }

    public static void main(String[] args) {
        String hello1 = "hello";
        String hello2 = new String("hello");

        System.out.println(StringWrapper1.str == hello1); // true
        System.out.println(StringWrapper1.str == hello2); // false
        System.out.println(StringWrapper1.str.equals(hello1)); // true
        System.out.println(StringWrapper1.str.equals(hello2)); // true

        SomeObj1 someObj1A = new SomeObj1(1);
        SomeObj1 someObj1B = new SomeObj1(1);
        SomeObj1 someObj1C = new SomeObj1(2);
        System.out.println("obj equal1 = " + (someObj1A.equals(someObj1B))); // true
        System.out.println("obj equal1.5 = " + (someObj1A.equals(someObj1C))); // false
        System.out.println("obj equal2 = " + (someObj1A == someObj1B)); // false

        System.out.println("finally의 동작 검증, someObjA.value는 1을 반환해야 한다: " + someObj1A.value);

        SomeObj1 returnObj = SomeFn.logic(someObj1A, someObj1C);
        System.out.println("obj equal3 = " + (someObj1A == returnObj)); // true
        System.out.println("finally의 동작 검증, someObjA.value는 2를 반환해야 한다: " + someObj1A.value);

        HashSet<SomeObj1> set1 = new HashSet<>();
        set1.add(someObj1A);
        set1.add(someObj1B);

        System.out.println("equals만 오버라이딩 하였기에 2가 나와야한다 : " + set1.size());

        HashSet<SomeObj2> set2 = new HashSet<>();
        set2.add(new SomeObj2(1));
        set2.add(new SomeObj2(1));

        System.out.println("equals,hash 둘다 오버라이딩 하였기에 1이 나와야한다 : " + set2.size());
        
    }

    private static class SomeObj1 {
        int value;

        public SomeObj1(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SomeObj1 other = (SomeObj1) obj;
            return this.value == other.value;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    private static class SomeObj2 {
        int value;

        public SomeObj2(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SomeObj2 other = (SomeObj2) obj;
            return this.value == other.value;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(value);
        }
    }

    private abstract static class SomeFn {
        private static SomeObj1 logic(SomeObj1 a, SomeObj1 c) {
            try {
                SomeObj1 innerA = a;
                return innerA;
            } finally {
                a.value = c.value;
            }
        }
    }
}
