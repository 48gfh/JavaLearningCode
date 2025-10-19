import java.util.Scanner;

public class topic10testDay {
    public static void main(String[] args) {
        //输入数字1~7，输出对应星期几
        Scanner sc = new Scanner(System.in);
        System.out.println("请在1~7范围输入整数，以便于查找对应的星期");
        int num = sc.nextInt();
        switch (num){
            default:
                System.out.println("无效输入，请重新输入有效整数");
                break;
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日，其实也算是工作日");
                break;
        }

    }
}
