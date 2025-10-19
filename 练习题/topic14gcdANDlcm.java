import java.util.Scanner;

public class topic14gcdANDlcm {
   /* 求指定两个数的最大公约数和最小公倍数*/
    public static void main(String[] args) {
        System.out.println("请输入连个整数");
        Scanner input = new Scanner(System.in);
        int data1= input.nextInt();
        int data2=input.nextInt();
        //调用计算最大公约数计算方法
        int result1= gcd(data1,data2);
        int result2= lcm(data1,data2);
        if (result1!=0){
            System.out.println(data1+"与"+data2+"最大公约数的结果为"+result1);
        }else{
            System.out.println("没有公约数");
        }
        if (result2!=0){
            System.out.println(data1+"与"+data2+"最小公倍数的结果为"+result2);
        }

    }

    public static int gcd(int num1,int num2){
        int maxNum=num1>num2?num1:num2;
        for (int i = 1; i <= maxNum; i++) {
            if(num1%i==0&&num2%i==0){
                return i;
            }

        }
        return 0;
    }

    public static  int lcm(int num3,int num4){
        for (int i = 1; true; i++) {
            if (i%num3==0&&i%num4==0){
                return i;
            }
        }

    }
}
