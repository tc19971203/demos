package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//一个初始值为0的变量，两个线程对其交替操作，一个加1一个减1，来5轮。
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();


        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}

class ShareData{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //加方法
    public void increment() throws InterruptedException {
        lock.lock();
        try{
            //如果当前线程的值不为0，不进行加操作，等待。

            /**
             * 防止虚假唤醒：在单参数版本中，中断和虚假唤醒是可能的，这种方法应该始终在循环中使用
             * As in the one argument version, interrupts and spurious wakeups are possible, and this method should always be used in a loop:
             *
             *      synchronized (obj) {
             *          while (<condition does not hold>)
             *              obj.wait();
             *          ... // Perform action appropriate to condition
             *      }
             */
            while (number!=0){
                //等待
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName()+"\t "+number);

            condition.signalAll();
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


    //减方法
    public void decrement() throws InterruptedException {
        lock.lock();
        try{
            while (number==0){
                //等待
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName()+"\t "+number);

            condition.signalAll();
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

}
