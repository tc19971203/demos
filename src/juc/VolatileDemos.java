package juc;

import java.util.concurrent.TimeUnit;

public class VolatileDemos {

    public static void main(String[] args) {
        mod mod = new mod();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"come in");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            mod.edit();
            System.out.println(Thread.currentThread().getName()+"="+mod.a);
        },"t1").start();

        while (mod.a == 0){}

        System.out.println(Thread.currentThread().getName()+"="+mod.a);

    }

}

class mod{
    volatile int a = 0;
    public void edit(){
        this.a = 100;
    }
}
