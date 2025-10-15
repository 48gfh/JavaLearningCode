# 方法

## 方法介绍

之前所有的代码都在main方法中写，如果我们都将代码都放到main方法中会显得main方法代码太多、太乱不便于维护。

解决方案： 将不同功能的代码块放到不同方法中，想执行某个功能直接调用方法名就行了，对应的代码就会自动执行。在维护代码的时候就可以直接找到相对应的方法块就可以对其修改维护。

方法：

> *   拥有功能性代码的代码块
> *   将不同功能放在不同的方法中，给每个方法取名字（小驼峰命名法），直接调用方法名，对应的方法就执行起来便于维护与调用。

## 格式

通用格式定义：

```java
修饰符  返回值类型  方法名(参数){
    方法体;
    return  结果
}
```

通用格式细分为四种定义方法的格式：

> *   无参无返回值方法
> *   有参无返回值方法
> *   无参有返回值方法
> *   有参有返回值方法

```java
//定义一个方法，实现两个数相加
public class demon02 {
    //无参无返回值
    public static void main(String[] args) {
        sum();
        System.out.println("少年好功夫");
    }

     public static void sum(){
        int a = 20;
        int b = 30;
        int sum  = a + b;
        System.out.println(sum);
     }
}
```

各部分解释：

```java
修饰符： public  static
返回值类型：	就是方法返回结果的数据类型
	eg:	return  45  //方法返回的就是整数类型，在返回值类型上写int
	    return	3.4 //方法的返回类型上写double
	    return	"hello"   //方法的的返回类型上写String
	 若没有返回值，则不需要写具体的返回值类型,写void就可以

方法名：见名知意 按小驼峰命名法
参数：进入到方法内部参与执行的数据 (数据类型  变量名,数据类型  变量名)
方法体：实现该方法功能的代码
return  结果：若有返回值则可以用  return 结果 将结果返回
```

### 无参无返回值方法

无参无返回值定义：

```java
public static void 方法名(){
    方法体    //实现此方法功能的代码
}
```

调用： 直接调用    在其他方法中：  方法名()

```java
public class demon01 {
    public static void main(String[] args) {
         farmer();
         cook();
         consumer();
    }
    public static void farmer(){
        System.out.println("种菜");
        System.out.print("施肥");
        System.out.println("除草");
        System.out.print("浇水");
        System.out.println("收割");
    }
    public static void cook(){
        System.out.println("买菜");
        System.out.println("切菜");
        System.out.println("炒菜");
    }
    public static void consumer(){
        System.out.println("付餐费");
        System.out.println("吃菜");
    }
}

```

需要注意的是：

> *   `void`表示关键字代表无返回值，写了`void`就不要在方法中写   `return` 结果
> *   方法不调用不执行，但是main方法是`jvm`调用
> *   方法之间进制嵌套互为平级关系
> *   方法的执行顺序之和调用顺序有关

### 无参有返回数值的方法

格式

```java
public static 返回值类型  方法名(){
    方法体;
    return  结果
}
```

调用： 返回值返回给了谁？哪里调用返回给哪里

> *   打印调用 sout(方法名())
> *   赋值调用：调用之后用一个变量接收返回值           数据类型  变量名 = 方法名()

```java
public static void main(String[] args) {
        int data = sum();//赋值调用  推荐使用方便后期调用
        System.out.println(sum()); // 打印调用 不建议使用不方便后期将sum() 传回来的值进行调用
    }
    public static int sum() {
        int a = 90;
        int g = 50;
        int sum = a+g;
        System.out.println(sum);
        return sum;
    }
```

### 有参无返回值的方法

格式：

```java
public static void 方法名(数据类型  变量名){
    方法体
}
```

调用： 直接调用：方法名(具体的值)  —> 调用的时候给参数赋值

```java
public class demon03 {
    //有参无返回值
    public static void main(String[] args) {
        sum(10,30);
    }
    public static void sum(int a, int b) {
        int sum = a+b;
        System.out.print(sum);
    }
}
```

### 有参有返回值的方法

格式

```java
public static 返回值类型  方法名(){
    方法体；
    return  结果
}
```

调用：

> *   打印调用   sout(方法名(具体的值))
> *   复制调用    数据类型  变量名  =  方法名(具体的值)

```java
public class demon04 {
    //有参有返回值定义
/*    public static void main(String[] args) {
        int data = sum(34,43);
        System.out.println(data);
    }
    public static int sum(int a,int b){
        int sum = a+b;
        return sum;
    }*/
    //定义一个方法 比较两个整数的大小，若data1>data2返回并输出true否则输出flase
    public static void main(String[] args) {
        int data1 = 34;
        int data2 = 78;
        boolean result = compre(data1, data2);
        System.out.println(result);
    }
    public static boolean compre(int a,int b){
        return a > b;
    }
}

```

### 方法编写注意事项

> *   方法不调用不执行
>
> *   方法执行顺序之和调用顺序有关
>
> *   方法之间不能互相嵌套
>
> *   void不能和  return 结果   共存，但是void能和  return  共存
>
> ​	    void： 代表没有返回值
>
> ​	    return 结果：代表有返回值，先将结果返回然后结束方法
>
> ​	    return： 代表结束方法，没有返回值
>
> *   一个方法不能连续写多个return(也就是一个方法不能都多个返回值)
> *   调用方法的时候要看看下面有没有这个方法，没有这个方法会直接报错

## 实参与形参的区别

> *   形式参数（形参）：在定义方法的时候形式上定义的参数，此参数没有值
> *   实际参数（实参）：在调用方法的时候给形参赋予具体值

## 参数与返回值使用的时机

参数：当想将方法A的数据传递到方法B的时候，那么定义方法B时就需要带参数。在方法A中调用方法B时，可以将方法A中的数据通过参数传递到方法B中。

返回值：调用方法A时，想要方法A的结果，去参与其他的操作，那么方法A就需要将自己的结果返回。

## 变量作为实参使用

```java
public class demon04 {
    //定义一个方法 比较两个整数的大小，若data1>data2返回并输出true否则输出flase
    public static void main(String[] args) {
        int data1 = 34;
        int data2 = 78;
        boolean result = compre(data1, data2);
        System.out.println(result);
    }
    public static boolean compre(int a,int b){
        return a > b;
    }
}

```

## 方法的练习

```java
public class exam01 {
    //键盘录入一个整数，将整数传递到另一个方法中,在此方法中判断这个数的奇偶性。若是偶数则方法返回"偶数"否则返回"奇数"
    public static void main(String[] args) {
        Scanner data =new Scanner(System.in);
        int data1 = data.nextInt();
        String result = compare(data1);
        System.out.println(result);
    }
    public static String compare(int data1){
        if (data1 % 2 ==0 ){
            return "偶数";
        }else {
            return "奇数";
        }
    }
}


public class exam02 {
    //求出1~100的和，并将结果返回
    public static void main(String[] args) {
        int result = sum();
        System.out.println("1~100的值是"+result);
    }
    public static int sum(){
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
             sum += i;
        }
        return sum;
    }
}

public class exam03 {
   //需求： 定义一个方法，给这个方法传几，就让这个方法循环打印几次“我是java开发工程师”
    public static void main(String[] args) {
        number(7);
    }
    public  static void number(int count){
        for (int i = 0; i < count; i++) {
            System.out.println("我是有一个java开发工程师");
        }
    }

}


public class exam04 {
    //在main方法中定义一个数组，将数组传递到另一个方法中，在此方法中遍历数组
    public static void main(String[] args) {
        int arr[] = {1,23,4,5};
        method(arr);
    }
    public static void method(int[] arr2){  // int[] arr2 = arr
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}


public class exam05 {
    //数组做为
    public static void main(String[] args) {
        int[] arr2 = method();
        for (int i = 0; i <arr2.length ; i++) {
            System.out.println(arr2[i]);
        }
    }
    public static int[] method() {
        int a =10;
        int b =20;
        int sum = a+b;
        int sub = b-a;
        int[] arr1= {sum,sub};
        return  arr1;
    }


}

```

## 方法的重载

```java
//重新定义三个方法，分别求出两个整数相加、三个整数相加、四个整数相加
public class demon05 {
    public static void main(String[] args) {
        sum(10,20);
        sum(10,20,30);
        sum(10,20,30,40);
    }

    //两个整数相加
    public static void sum(int a,int b){
        System.out.println(a+b);
    }

    //三个整数相加
    public static void sum(int a,int b,int c){
        System.out.println(a+b+c);
    }

    //四个整数相加
    public static void sum(int a,int b,int c,int d){
        System.out.println(a+b+c+d);
    }
}
```

概述：方法名相同，参数列表不同的方法

什么时参数列表不同：

> *   参数个数不同
> *   参数类型不同
> *   参数类型顺序不同

判断两个方法是否为重载方法，和什么无关

> *   和参数名无关
> *   和返回值无关

如果定义方法功能一样,只不过实现细节不一样,就可以考虑定义成重载的方法

# 方法总结

![数组.png](https://note.youdao.com/yws/res/1575/WEBRESOURCEa1a41590444b3aec3b428d7fdfe7acc1)
