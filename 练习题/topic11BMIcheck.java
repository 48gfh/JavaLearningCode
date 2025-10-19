import java.util.Scanner;

public class topic11BMIcheck {
    public static void main(String[] args) {
       /* 接收用户输入的身高和体重,将判断结果输出
        过轻：低于18.5
        正常：18.5 ~ 22.9
        偏胖：23 ~ 24.9
        肥胖：25 ~ 29.9
        重度肥胖：高于30
        极度肥胖：高于40*/
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你体重/kg");
        double weight = sc.nextDouble();
        System.out.println("请输入你的身高/m");
        double height = sc.nextDouble();

        double BMI = weight / (height * height);
        if (BMI > 40){
            System.out.println("极度肥胖");
        }else if (BMI > 30){
            System.out.println("重度肥胖");
        } else if (BMI > 25 && BMI < 29.9) {
            System.out.println("偏胖");
        } else if (BMI > 23 && BMI < 24.9) {
            System.out.println("肥胖");
        }else if (BMI > 18.5 && BMI < 22.9) {
            System.out.println("正常");
        } else if  (BMI < 18.5) {
            System.out.println("过轻");
        }
    }
}
