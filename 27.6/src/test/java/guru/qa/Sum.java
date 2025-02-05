package guru.qa;

public class Sum {
//    public static void main(String args[]) {
//        int a = 10;
//        int b = 20;
//        int c = 25;
//        int d = 25;
//        System.out.println("a + b = " + (a + b));
//        System.out.println("a - b = " + (a - b));
//        System.out.println("a * b = " + (a * b));
//        System.out.println("b / a = " + (b / a));
//        System.out.println("b % a = " + (b % a));
//        System.out.println("c % a = " + (c % a));
//        System.out.println("a++   = " +  (a++));
//        System.out.println("b--   = " +  (a--));
//
//        System.out.println("d++   = " +  (d++));
//        System.out.println("++d   = " +  (++d));
//    }

    public static void main(String args[]) {

        int a = 7;
        int b = a++;
        System.out.println(b);
        System.out.println(a);

        int c = 7;
        int d = ++a;
        System.out.println(d);
        System.out.println(c);

        byte y = 1;
        byte x = 2;
        byte result = (byte)(a + b);
        System.out.println(result);

        int value = 4;
        System.out.println(8/value);
        System.out.println(9/value);
        System.out.println(10/value);
        System.out.println(11/value);

    }

}
