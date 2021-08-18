package jvm;

public class MetaspaceOOMTest {
    static class OOMTest{

    }

    public static void main(String[] args) {
        int i = 0;
        try{
            while (true){
                i++;
            }
        }catch (Throwable e){
            System.out.println("=======多少次发送了异常"+i);
            e.printStackTrace();
        }
    }
}
