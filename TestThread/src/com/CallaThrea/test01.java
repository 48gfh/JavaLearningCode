package com.CallaThrea;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 通过实现Callable接口，创建进程
 * */
public class test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //定义一个线程对线
        ter t1 = new ter();
        FutureTask ft= new FutureTask(t1);
        Thread th = new Thread(ft);
        th.start();
        //获取线程里的值并返回
        Integer data = (Integer) ft.get();
        System.out.println("从子线程返回的值"+data);

    }
}
class ter implements Callable<Integer> {

    /**
     * 实现Callable接口可以不带泛型，如果不带泛型,那么Call方式的返回值就是Object类型
     * */
    @Override
    public Integer call() throws Exception {

        return new Random().nextInt(10);
    }

}
