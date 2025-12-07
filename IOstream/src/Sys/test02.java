package com.Sys;

import java.io.*;

/**
 * 模拟录入内同进入文件中
 * */
public class test02 {
    public static void main(String[] args) throws IOException {
        //键盘录入
        InputStream in = System.in;
        //字节转字符
        InputStreamReader isr= new InputStreamReader(in);
        //在isr外面再套一个缓冲流
        BufferedReader br = new BufferedReader(isr);

        //输出方向
        File f = new File("D:\\Desktop\\Test\\ttt1.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        //开始动作
        String st =br.readLine();
        while (!st.equals("exit")){
            bw.write(st);
            bw.newLine();//文件中进行换行
            st=br.readLine();
        }
        bw.close();
        br.close();
    }
}
