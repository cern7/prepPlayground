import java.lang.reflect.ParameterizedType;
import java.util.*;

public class MinNumberOfTables {
    public static void main(String[] args) {
        List<Reservation> list = new ArrayList<>();
        list.add(new Reservation(0, 5));
        list.add(new Reservation(1, 2));
        list.add(new Reservation(1, 10));
        list.add(new Reservation(2, 6));
        list.add(new Reservation(3, 9));
        System.out.println(new MinNumberOfTables().minTables2(list));
    }

    static class Reservation {
        long startTime;
        long endTime;

        public Reservation(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }
    }
    // write a function that can take an arbitrary number of table
    // reservations that returns the minimum number of tables
    // required to support these reservations
    // 0..........10
    /*
     * ###
     *    ###
     *        ###
     * requires 1 table
     * ###
     *  ###
     *    ###
     * requires 2 tables
     */

    public int minTables(List<Reservation> reservations) {
        // if no reservation return 0
        if (reservations.isEmpty()) {
            return 0;
        }
        // 2D array first value indicates the start/end time
        // of the reservation the second value is 1 or 0 i.e starts/extends
        class Pair {
            long first;
            long second;

            Pair(long x, long y) {
                first = x;
                second = y;
            }
        }

        List<Pair> time = new ArrayList<>();
        for (Reservation rs : reservations) {
            time.add(new Pair(rs.startTime, 1));
            time.add(new Pair(rs.endTime + 1, -1));
        }

        Collections.sort(time, Comparator.comparing(pair -> pair.first));

        long counter = 0;
        long sum = 0;
        // loop through time list
        // update the sum and counter variable

        for (Pair t : time) {
            sum += t.second;
            counter = Math.max(counter, sum);
        }
        return (int) counter;
    }


    public int minTables2(List<Reservation> reservations) {
        if (reservations.isEmpty()) {
            return 0;
        }

        long[] startTime = new long[reservations.size()];
        long[] endTime = new long[reservations.size()];

        for (int i = 0; i < reservations.size(); i++) {
            startTime[i] = reservations.get(i).startTime;
            endTime[i] = reservations.get(i).endTime;
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int startPoint = 0;
        int endPoint = 0;

        int minTables = 0;
        int overlapTables = 0;
        while (startPoint < startTime.length
                && endPoint < endTime.length) {
            if (startTime[startPoint] < endTime[endPoint]) {
                overlapTables++;
                startPoint++;
                minTables = Math.max(minTables, overlapTables);
            } else {
                overlapTables--;
                endPoint++;
            }
        }
        return minTables;
    }
}
