package juc;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for(int i = 1 ; i <= 10 ; i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },i+"").start();
        }
    }
}
