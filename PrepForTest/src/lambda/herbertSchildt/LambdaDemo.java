package lambda.herbertSchildt;

public class LambdaDemo {
    public static void main(String[] args) {
        // Declare an interface reference
//        MyNumber myNum;

        // Here, the lambda expression is simply a constant expression.
        // When it is assigned to myNum, a class instance is
        // constructed in which the lambda expression implements
        // the getValue() method in MyNumber.
//        myNum = () -> 123.45;

        // Call getValue(), which is provided by the previously assigned
        // lambda expression
//        System.out.println("A fixed value: " + myNum.getValue());

//        myNum = () -> Math.random() * 100;

//        System.out.println("A random value: " + myNum.getValue());
//        System.out.println("Another random value: " + myNum.getValue());

        /*
         * Lambda Demo 2
         */

//        NumericTest isEven = (n) -> n % 2 == 0;
//        if (isEven.test(10)) System.out.println("10 is even");
//        if (!isEven.test(9)) System.out.println("9 is not even");
//
//        NumericTest isNonNeg = (n) -> n >= 0;
//        if (isNonNeg.test(1)) System.out.println("1 is non-negative");
//        if (!isNonNeg.test(-1)) System.out.println("-1 is negative");

        NumericTest2 isFactor = (n, d) -> n % d == 0;
        if (isFactor.test(10, 2)) System.out.println("2 is factor of 10");
        if (!isFactor.test(10, 3)) System.out.println("3 is not factor of 10");
    }
}
