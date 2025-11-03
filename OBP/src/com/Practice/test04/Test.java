package com.Practice.test04;

public class Test {
    public static void main(String[] args) {
        //创建一个boy类的具体对象
        boy boy =new boy(40,"zhangsan");
        //创建一个gril类的对象
        girl g1 = new girl("lisi",12);
        //开始谈恋爱
        g1.love(boy);

        //可以跟妈妈聊天
        g1.m =new Mom();
        g1.wechat();  
    }
}
