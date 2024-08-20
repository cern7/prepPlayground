package lambda.herbertSchildt;

public class VarCapture {
    int instanceVar = 10;
    public static void main(String[] args) {
        int num = 10;
        NumericFunc myLambda = n -> {
            new VarCapture().instanceVar++;
            int v = num + n;
            // The following is illegal because it
            // attempts to modify the value of num
            // num++
            return v;
        };

        // The following line would also cause an error,
        // because it would remove the effectively final status from num.
        // num = 9;
    }
}
