package guru.qa;

public class Ternary {
//    переменная x = (выражение) ? значение if true : значение if false
    public static void main (String [] args){
        int money = 100;
        int price = 50;
        int spentMoney = money -price;
        int myMoney = spentMoney >= 70 ? 10 : 5;
        spentMoney -= spentMoney >= 70 ? 10 : 5;
        System.out.println(myMoney);
        System.out.println(spentMoney);

    }
}
