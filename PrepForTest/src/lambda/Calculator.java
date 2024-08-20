package lambda;

import javax.print.attribute.IntegerSyntax;

public class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
        private static int getVal(){
            return 1;
        }
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator myApp = new Calculator();
        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, Integer::sum));
        System.out.println("20 - 12 = " + myApp.operateBinary(20, 12, (a, b) -> a - b));
    }
}
