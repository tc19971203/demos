package juc;

public class Instruction {
    int a = 0;
    boolean flag = false;

    public void method01(){
        a = 1;
        flag = true;
    }

    public void method02(){
        if(flag){
            a = a+5;
        }
        System.out.println(a);
    }
}
