import java.util.Scanner;

public class topic09numberEven {
    public static void main(String[] args) {
        //接收用户输入的数据，判断是奇数还是偶数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数用于判断是奇数还是偶数");
        int data1 = sc.nextInt();
        if(data1%2==0){
            System.out.println("这是一个偶数");
        }else {
            System.out.println("这是一个奇数");
        }
    }
}
