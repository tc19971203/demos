package javase;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //带入一个银行办理业务的案例来模拟AQS如何进行线程的管理和通知唤醒机制
        //3个线程模拟3个人来银行网点，受理窗口办理业务的顾客。

        //第一个线程办理20分钟
        new Thread(()->{
            lock.lock();
            try{
                System.out.println("-----A thread come in");
                try{
                    TimeUnit.MINUTES.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
            } catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"A").start();



        new Thread(()->{
            lock.lock();
            try{
                System.out.println("-----B thread come in");
            } catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"B").start();



        new Thread(()->{
            lock.lock();
            try{
                System.out.println("-----C thread come in");
            } catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"C").start();
    }
}
