package javase;

public class StringPool58Demo {
    public static void main(String[] args) {

        String str1 = new StringBuilder("ha").append("llo").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());


        System.out.println();


        String str2 = new StringBuilder("wo").append("rld").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
        System.out.println();



        String str3 = new StringBuilder("ja").append("va").toString();
        System.out.println(str3);
        System.out.println(str3.intern());
        System.out.println(str3 == str3.intern());

    }
}
