package juc;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousBlockingDemo {
    public static void main(String[] args) {
        BlockingQueue<String> objects = new SynchronousQueue<>();

        //如果是其他的阻塞队列，会连续put，但是SynchronousQueue只会放入一个，如果没有取就不会再次放入
        new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                objects.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                objects.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                objects.put("3");
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t1").start();



        new Thread(()->{
            try{
                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"\t"+objects.take());
                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"\t"+objects.take());
                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"\t"+objects.take());
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t2").start();
    }
}
