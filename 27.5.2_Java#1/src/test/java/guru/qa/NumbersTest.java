package guru.qa;

public class NumbersTest {
    public static void main(String... args){
        String numberFirst = "eleven";
        String numberSecond = "five";
        String firstName = "Влад";
        String secondName = "Антон";
        int age = 37;
        System.out.println(numberFirst.equals(numberSecond));
        System.out.println(firstName.equals("Влад") && age == 37 && numberFirst == "eleven");
        System.out.println(firstName.equals("Антон") || age == 39 || numberFirst == "twelve");
        System.out.println(!(firstName.equals("Антон")));

        System.out.println("Для типа float");
        float aFloat = (float) (3.4 * Math.pow(10,38));
        float aFloat1 = aFloat + aFloat;
        System.out.println(aFloat1);

        byte c = 0;
        byte d = 127;
        c = (byte) (d + 76);
        System.out.println(c);

        short aShort = 32767; // 16b -32768 +32767
        short aShort1 = (short) (aShort + 3);
        System.out.println(aShort1);

        int aInt = 2147483647;
        int aInt1 = aInt + 1;
        System.out.println(aInt1);

        long aLong = 9223372036854775807L;
        long aLong1 = aLong + 1;
        System.out.println(aLong1);

        int a = 1;
        double b = 1.1;
        System.out.println(a + b);
    }

}



