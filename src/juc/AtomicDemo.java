package juc;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    public static void main(String[] args) {
        mod01 mod01 = new mod01();

        for (int i = 0; i < 20; i++){
            new Thread(()->{
                for (int j = 0; j < 1000; j++){
                    mod01.add();
                    mod01.add01();
                }
            },i+"").start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(mod01.num);
        System.out.println(mod01.atomicInteger);
    }

}

class mod01{

    int num = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void add(){
        num++;
    }

    public void add01(){
        atomicInteger.getAndIncrement();
    }

}
