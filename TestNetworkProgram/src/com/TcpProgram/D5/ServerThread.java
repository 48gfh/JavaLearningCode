package com.TcpProgram.D5;

import java.io.*;
import java.net.Socket;

/**
 * 多线程接收用户请求
 * */
public class ServerThread extends Thread{
    InputStream is =null;
    ObjectInputStream ois=null;
    OutputStream os = null;
    DataOutputStream dos = null;
    Socket s =null;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {

            is=s.getInputStream();
            ois= new ObjectInputStream(is);
            //读取客户发来的信息
            User user = (User)(ois.readObject());
            //对对象进行验证
            boolean flag = false;
            if((user.getName().equals("lili"))&&(user.getPassword().equals("123456"))){
                System.out.println("验证成功");
                flag=true;
            }

            //向客户端返回验证成果
            os =s.getOutputStream();
            dos= new DataOutputStream(os);
            dos.writeBoolean(flag);
            dos.flush();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
          if(dos!=null){
              try {
                  dos.close();
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }
          if(os!=null) {
              try {
                  os.close();
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }
          if(ois!=null){
              try {
                  ois.close();
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }
          if(is!=null){
              try {
                  is.close();
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }


        }

    }


}
