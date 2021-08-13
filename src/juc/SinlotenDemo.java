package juc;

public class SinlotenDemo {
    private static volatile SinlotenDemo instance = null;
    private SinlotenDemo(){};
    public static SinlotenDemo getInstance(){
        if(instance == null){
            synchronized (SinlotenDemo.class){
                if(instance == null){
                    instance = new SinlotenDemo();
                }
            }
        }

        return instance;
    }
}
