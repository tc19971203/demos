package juc;

import java.util.concurrent.*;

public class MyThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        //模拟10个用户办理业务，每个用户就是一个来自外部的请求线程
        try{
            for (int i = 1; i <= 10 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
    /*public static void threadPoolInit() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        //模拟10个用户办理业务，每个用户就是一个来自外部的请求线程
        try{
            for (int i = 1; i <= 10 ; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }*/

