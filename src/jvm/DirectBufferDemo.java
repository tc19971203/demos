package jvm;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class DirectBufferDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory: "+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
        try{
            TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);

    }
}
