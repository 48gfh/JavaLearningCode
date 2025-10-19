import java.util.Scanner;

public class topic17numberPhone {
    public static void main(String[] args) {
        /*练习题: 手机选号:根据用户输入的手机号来确认用户实际支付的价格
        如果尾数为8，需支付办卡费50元
        如果尾数为4，需支付办卡费用0元
        如果是其他尾号,需支付办卡费用20元*/
        numberPrice();

    }

    public static void numberPrice(){
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();

        //验证手机号
        String numberstr = String.valueOf(number);
        if (numberstr.length()!=11){
            System.out.println("手机号必须为11位。请重新输入手机号");
        }



        int tailNumber = (int) (number%10);
        /*System.out.println(tailNumber);*/
        switch (tailNumber){
            case 8:
                System.out.println("需要支付办卡费用50元");
                break;
            case 4:
                System.out.println("无需支付办卡费用");
                break;
            default:
                System.out.println("需要支付办卡费用20元");
                break;
        }

     }
}
