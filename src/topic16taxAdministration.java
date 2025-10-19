import java.util.Scanner;

public class topic16taxAdministration {
    public static void main(String[] args) {
     /*   小蓝入职一家企业后，税前工资是18000，则他每月该交个税的部分是18000-1800-5000=11200元，
     个税缴纳数额是3000×3%+8200×10%=910元。税后工资15290元。
        请完成一个个税计算程序，在用户输入税前工资后，计算出他对应的纳税数额，以及税后工资为多少？
        0 ~ 3000元的部分，交税3%
        3000 ~ 12000元的部分，交税10%
        12000 ~ 25000的部分 ， 交税20%
        25000 ~ 35000的部分，交税25%
        35000 ~ 55000的部分，交税30%
        55000 ~ 80000的部分，交税35%
        超过80000的部分，交税45%
*/
        Scanner input =new Scanner(System.in);
        System.out.println("请输入税前工资，系统将为您计算税后工资为多少");
        long salary = input.nextInt();
        if(salary<=0){
            System.out.println("无效输入请重新输入");
        }else{
            taxCalculate(salary);
        }
    }
    public static void taxCalculate(long data){
        //计算扣除三险一金后的应发工资
        double insurance =data*0.1;
        double taxableSalary = data - insurance;

        //计算应税所得额,扣除5000起征点
        double taxableIncome = taxableSalary -5000;
        if(taxableIncome <=0){
            System.out.println("您无需缴税务，税后工资为"+taxableIncome);
        }

        //按照累进税率计算个人所得税
        double tax = calculateTax(taxableIncome);
        double afterTaxSalary = taxableSalary-tax;
        System.out.println("您应纳税"+tax+"税后工资为"+afterTaxSalary);
    }
    public  static  double calculateTax(double income){
        double tax =0;
        if(income>80000 ){
            tax=(income-80000)*0.45;
            income = 80000;
        }
        if (income > 55000) {
            tax += (income - 55000) * 0.35;
            income = 55000;
        }
        if (income > 35000) {
            tax += (income - 35000) * 0.30;
            income = 35000;
        }
        if (income > 25000) {
            tax += (income - 25000) * 0.25;
            income = 25000;
        }
        if (income > 12000) {
            tax += (income - 12000) * 0.20;
            income = 12000;
        }
        if (income > 3000) {
            tax += (income - 3000) * 0.10;
            income = 3000;
        }
        if (income > 0) {
            tax += income * 0.03;
        }

        return tax;

    }

}
