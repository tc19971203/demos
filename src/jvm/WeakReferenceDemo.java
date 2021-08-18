package jvm;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        myHashmap();
        System.out.println("=======================");
        myWeakHashMap();
    }

    private static void myWeakHashMap() {

        Map<Integer, String> hashMap = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "WeakHashMap";
        hashMap.put(key,value);
        System.out.println(hashMap);

        key = null;
        System.out.println(hashMap);

        System.gc();
        System.out.println(hashMap+"\t"+hashMap.size());


    }

    private static void myHashmap() {
        Map<Integer, String> hashMap = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";
        hashMap.put(key,value);
        System.out.println(hashMap);

        key = null;
        System.out.println(hashMap);

        System.gc();
        System.out.println(hashMap+"\t"+hashMap.size());
    }
}
