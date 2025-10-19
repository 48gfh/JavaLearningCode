import java.util.Scanner;

public class topic15Profit {
/*    某银行推出了整存整取定期储蓄业务，其存期分为一年、两年、三年、五年，到期凭存单支取本息。存款年利率表如下：
             存期 年利率（%）
             一年 2.25
             两年 2.7
             三年 3.25
             五年 3.6
    请存入一定金额（1000起存），存一定年限（四选一），计算到期后得到的本息总额。
    提示：
            存入金额和存入年限均由键盘录入
            本息计算方式：本金+本金×年利率×年限

*/
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("请输入存入的金额，1000起存");
    int inputMoney=input.nextInt();
    System.out.println("请选择定期业务的年限：1年，2年，3年，五年；请输入数字选择对应的年限");
    int year = input.nextInt();
    calculate(inputMoney,year);

 }

 public static void calculate(int Mdata,int Ydata){
    if (Ydata>=1&&Ydata<=5){
        switch (Ydata){
            case 1:
                double sumMoney = (Mdata*2.25*1)+Mdata;
                System.out.println("总额为"+sumMoney);
                break;
            case 2:
                sumMoney = (Mdata * 2.7 * 2) + Mdata;
                System.out.println("总额为"+sumMoney);
                break;
            case 3:
                sumMoney = (Mdata*3.25*3)+Mdata;
                System.out.println("总额为"+sumMoney);
                break;
            case 5:
                sumMoney = (Mdata*3.65*5)+Mdata;
                System.out.println("总额为"+sumMoney);
                break;


        }
    }else{
        System.out.println("无效输入请重新输入");
    }
 }

}
