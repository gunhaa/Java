package equals;

import java.util.Objects;

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

        SomeObj someObjA = new SomeObj(1);
        SomeObj someObjB = new SomeObj(1);
        SomeObj someObjC = new SomeObj(2);
        System.out.println("obj equal1 = " + (someObjA.equals(someObjB))); // true
        System.out.println("obj equal1.5 = " + (someObjA.equals(someObjC))); // false
        System.out.println("obj equal2 = " + (someObjA == someObjB)); // false

        System.out.println("finally의 동작 검증, someObjA.value는 1을 반환해야 한다: " + someObjA.value);

        SomeObj returnObj = SomeFn.logic(someObjA, someObjC);
        System.out.println("obj equal3 = " + (someObjA == returnObj)); // true
        System.out.println("finally의 동작 검증, someObjA.value는 2를 반환해야 한다: " + someObjA.value);

    }

    private static class SomeObj {
        int value;

        public SomeObj(int value) {
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
            SomeObj other = (SomeObj) obj;
            return this.value == other.value;
        }
    }

    private abstract static class SomeFn {
        private static SomeObj logic(SomeObj a, SomeObj c) {
            try {
                SomeObj innerA = a;
                return innerA;
            } finally {
                a.value = c.value;
            }
        }
    }
}
