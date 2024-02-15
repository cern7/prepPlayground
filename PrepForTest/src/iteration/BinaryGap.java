package iteration;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(new BinaryGap().function(561892));
    }

    int function(int N) {
        int res = 0;
        if (N == 1) {
            return 0;
        }
        String binaryRep = Integer.toBinaryString(N);
        char[] arr = binaryRep.toCharArray();
        int tempGap = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == '0') {
                tempGap++;
            } else if (arr[i] == '1') {
                if (tempGap > res) {
                    res = tempGap;
                }
                tempGap = 0;
            }
        }
        return res;
    }
}
