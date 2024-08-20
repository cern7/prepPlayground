package lambda.herbertSchildt;

public class InstanceMethWithObjectRefDemo {
    static <T> int counter(T[] values, MyFunc<T> f, T v) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (f.func(values[i], v)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int count;
        HighTemp[] weekDayHighs = {new HighTemp(100), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83)};

        // Use counter() with arrays of the class HighTemp
        // Notice that a reference to the instance method
        // sameTemp() is passed as the second argument

        count = counter(weekDayHighs,
                HighTemp::sameTemp, new HighTemp(89));
        System.out.println(count + " days had a high of 89");
        count = counter(weekDayHighs,
                HighTemp::lessThanTemp, new HighTemp(85));
        System.out.println(count + " days had a less of 85");
    }
}
