package lambda.herbertSchildt;

public class BlockLambdaDemo {
    public static void main(String[] args) {

        NumericFunc factorial = (n) -> {
            int res = 1;
            for (int i = 1; i <= n; i++)
                res = i * res;
            return res;
        };

        System.out.println("The factorial of 3 is " + factorial.func(3));
        System.out.println("The factorial of 5 is " + factorial.func(5));
    }
}
