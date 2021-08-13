package juc;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("***********come in callable");
        try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){e.printStackTrace();}
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask,"AA").start();

        int result02 = futureTask.get();

        System.out.println(Thread.currentThread().getName()+"\t **************");
        int result01 = 100;
       // int result02 = futureTask.get();

        System.out.println("******result: "+(result01+result02));
    }

}
