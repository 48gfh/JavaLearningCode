import java.util.Scanner;
//工厂类
public class Shop {
    Scanner sc =new Scanner(System.in);
    public void ShopShow(){

        System.out.println("================欢迎使用披萨店自助下单系统================");
        while (true){
            System.out.println("请选择想要制作的披萨：1、培根披萨 2、水果披萨 3、退出");
            int ch = sc.nextInt();
            switch (ch){
                default:
                    System.out.println("无效输入，请重新输入");
                case 1:
                    System.out.println("培根披萨");
                    Bp();
                    break;
                case 2:
                    System.out.println("水果披萨");
                    Fp();
                    break;
                case 3:
                    System.out.println("感谢使用，欢迎下次光临");
                    return;
            }
        }
    }

    public void Bp(){
        final String name ="培根披萨";
        System.out.println("请输入培根的克数 ");
        double weigth = sc.nextDouble();
        System.out.println("请输入披萨的大小");
        int size= sc.nextInt();
        System.out.println("请输入披萨的价格");
        double prize =sc.nextDouble();
        FatherPizza Bp1  = new baconPizza(prize,size,name,weigth);
        Bp1.display();
    }
    public void Fp(){
        final  String name = "水果披萨";
        System.out.println("请输入你想加入的水果");
        String dosing= sc.nextLine();
        System.out.println("请输入披萨的大小");
        int size =sc.nextInt();
        System.out.println("请输入披萨的价格");
        double price=sc.nextDouble();
        FatherPizza Fp1  = new fruitPizza(price,size,name,dosing);
        Fp1.display();
    }

}
