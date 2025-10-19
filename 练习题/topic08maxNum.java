import java.util.Scanner;

public class topic08maxNum {
    public static void main(String[] args) {
        //接受用户输入的三个整数，将最大值作为输出结果
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个整数");
        int data1 = sc.nextInt();
        int data2 = sc.nextInt();
        int data3 = sc.nextInt();
        int temp =data1>data2?data1:data2;
        int maxData =data3>temp?data3:temp;
        System.out.println("最大整数为"+maxData);
    }
}
