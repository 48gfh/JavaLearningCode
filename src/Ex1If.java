import java.util.Scanner;
public class Ex1If {
    public static void main(String[] args) {
            System.out.println("学号：2510241013姓名：余晓飞");
            Scanner scanner = new Scanner(System.in);
            // 输入年份
            System.out.println("请输入年份：");
            int year = scanner.nextInt();
            // 输入月份
            System.out.println("请输入月份：");
            int month = scanner.nextInt();
            // 校验月份合法性
            if (month < 1 || month > 12) {
                System.out.println("输入的月份不合法！月份应在1-12之间。");
                scanner.close();
                return;
            }
            int day;
            // 判断2月份，考虑闰年
            if (month == 2) {
                // 闰年判断：能被4整除且不能被100整除，或者能被400整除
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    day = 29;
                } else {
                    day = 28;
                }
            }
            // 判断30天的月份
            else if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = 30;
            }
            // 其他月份都是31天
            else {
                day = 31;
            }
            System.out.println(year + "年" + month + "月份有" + day + "天");
            scanner.close();
        }
}
