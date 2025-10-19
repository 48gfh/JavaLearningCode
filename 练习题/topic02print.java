public class topic02print {
    public static void main(String[] args) {
        //打印个人信息，将一个人的一些信息打印出来
        System.out.println("张三");
        System.out.println("年龄"+3);
        System.out.println("大陆");
        System.out.println(true);//打印Boolean类型
        System.out.println(false);
        System.out.println(10.333);//打印小数类型

        //拼接打印：输出：XXX：这是我学习JAVA的第X年，我的期望薪资是XXX
         int year = 3;
         int salary = 10000;
         String name = "张三";
        System.out.println("我是"+name+"这是我学习java的第"+year+"期望薪资是"+salary);

    }
}
