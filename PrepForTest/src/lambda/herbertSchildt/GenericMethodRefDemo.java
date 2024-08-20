package lambda.herbertSchildt;

public class GenericMethodRefDemo {
    static <T> int myOp(MyFunc2<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 5, 4, 4};
        String[] strs = {"One", "Two", "Three", "Two"};
        int count;

        count = myOp(MyArraysOps::<Integer>countMatching, vals, 4);
        count = myOp(MyArraysOps::<String>countMatching, strs, "Two");

    }
}
