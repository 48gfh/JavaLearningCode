import java.util.Scanner;

public class topic13absoluteValue {
    /*绝对值是指一个数在数轴上所对应点到原点的距离，用“| |”来表示。
    负数的绝对值是他去掉负号以后的值，而非负数（0和正数）的绝对值是他本身。
    请定义一个方法，接收用户输入的数字，输出绝对值结果。*/
    public static void main(String[] args) {
        System.out.println();
    }
    public static  int value(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个负数，程序将计算出绝对值");
        int Data = sc.nextInt();
        if(Data<0){
            return (Data*-1);
        }else {
         return Data;
        }
    }
}
