package lambda.herbertSchildt;

public class MyStringOps {
    String strReverse(String str) {
        String res = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }

    static String stringOp(SomeFunc<String> sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String str = "Lambdas add power to Java";
        String outStr;
        MyStringOps strOps = new MyStringOps();
        outStr = stringOp(strOps::strReverse, str);

        System.out.println("Original String: " + str);
        System.out.println("String reversed: " + outStr);
    }
}
