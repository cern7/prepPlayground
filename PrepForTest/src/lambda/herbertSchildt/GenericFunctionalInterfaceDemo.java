package lambda.herbertSchildt;


public class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SomeFunc<String> revers = str -> {
            String res = "";
            for (int i = str.length() - 1; i >= 0; i--)
                res += str.charAt(i);
            return res;
        };

        System.out.println("Lambda reversed is " + revers.func("lambdA"));
        System.out.println("Expression reversed is " + revers.func("expressioN"));

        SomeFunc<Integer> factorial = n -> {
            int res = 1;
            for (int i = 1; i <= n; i++)
                res *= i;
            return res;
        };

        System.out.println("Factorial of 3 is " + factorial.func(3));

        /*
         *
         */

        String inStr = "Lambdas add power to Java";
        String outStr;
        System.out.println("Input String: " + inStr);

        outStr = stringOp(str -> str.toUpperCase(), inStr);
        System.out.println("The string to uppercase: " + outStr);

        outStr = stringOp(str -> {
            String res = "";
            int i;
            for (i = 0; i < str.length(); i++)
                if (str.charAt(i) != ' ')
                    res += str.charAt(i);

            return res;
        }, inStr);
        System.out.println("The string with spaces removed: " + outStr);
    }

    static String stringOp(SomeFunc<String> sf, String s) {
        return sf.func(s);
    }
}
