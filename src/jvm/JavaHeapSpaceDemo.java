package jvm;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "tc";
        while (true){
            str += str + new Random(111111)+new Random().nextInt(22222);
            str.intern();
        }
    }
}
