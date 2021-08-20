package javase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEnterLockDemo {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->{
            lock.lock();
            try{
                System.out.println("=======外层");
                lock.lock();
                try{
                    System.out.println("=======内层");

                } catch(Exception e){
                    e.printStackTrace();
                }finally{
                    lock.unlock();
                }
            } catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"t1").start();
    }
}
