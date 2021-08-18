package jvm;

import java.util.Random;

public class GCDemo {
    public static void main(String[] args) {
        try{
            String str = "tc";
            while (true){
                str += str + new Random(111111)+new Random().nextInt(22222);
                str.intern();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
