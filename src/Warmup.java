import java.util.*;

public class Warmup {

    //1

    static int solveMeFirst(int a, int b) {

        return a + b;

    }

    //2

    static int simpleArraySum(int[] ar) {

        int sum = 0;

        for(int i : ar) {

            sum += i;

        }

        return sum;

    }

    //3

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> list = new ArrayList<>();

        int player1 = 0;
        int player2 = 0;

        if(a.get(0) > b.get(0)) {

            player1 += 1;
        }

        else if(a.get(0) < b.get(0)) {

            player2 += 1;
        }
        else {

            // player1 = player1;
            // player2 = player2;

        }

        if(a.get(1) > b.get(1)) {

            player1 += 1;
        }

        else if(a.get(1) < b.get(1)) {

            player2 += 1;
        }
        else {

            //player1 = player1;
            // player2 = player2;

        }

        if(a.get(2) > b.get(2)) {

            player1 += 1;
        }

        else if(a.get(2) < b.get(2)) {

            player2 += 1;
        }
        else {

            // player1 = player1;
            //  player2 = player2;

        }

        list.add(player1);
        list.add(player2);

        return list;

    }

    //4

    static long aVeryBigSum(long[] ar) {

        long sum = 0L;

        for(long l : ar) {

            sum += l;

        }

        return sum;

    }

    //5

    public static int diagonalDifference(List<List<Integer>> arr) {

        int len = arr.size();
        int len2 = arr.size();

        int x = 0;
        int y = 0;
        int sumD1 = 0;
        int sumD2 = 0;

        for(int i = 0; i < len; i++) {

            int firstD = arr.get(x)
                            .get(y);

            len2--;

            int secD = arr.get(x)
                          .get(len2);

            x++;
            y++;

            sumD1 += firstD;
            sumD2 += secD;

        }

        return Math.abs(sumD1 - sumD2);

    }

    //6

    static void plusMinus(int[] arr) {

        List<Integer> ne = new ArrayList<>();
        List<Integer> po = new ArrayList<>();
        List<Integer> eq = new ArrayList<>();

        for(int i : arr) {

            if(i < 0) {

                ne.add(i);
            }

            else if(i > 0) {

                po.add(i);
            }

            else {

                eq.add(i);
            }

        }

        double ne_po = (double) ne.size() / arr.length;
        double po_po = (double) po.size() / arr.length;
        double eq_po = (double) eq.size() / arr.length;

        System.out.println(po_po);
        System.out.println(ne_po);
        System.out.println(eq_po);

    }

    //7

    static void staircase(int n) {

        String blank = " ";
        String item = "#";

        int blankCount = n - 1;
        int itemCount = 1;

        for(int i = 1; i < n + 1; i++) {

            for(int j = 1; j < blankCount + 1; j++) {

                System.out.print(blank);

            }

            blankCount--;

            for(int m = 1; m < itemCount + 1; m++) {

                System.out.print(item);

            }

            itemCount++;

            System.out.print("\n");

        }

    }

    //8

    static void miniMaxSum(int[] arr) {

        List<Integer> list = new ArrayList<>();

        for(int i : arr) {

            list.add(i);

        }

        Collections.sort(list);

        List<Integer> forMin = new ArrayList<>(list);
        List<Integer> forMax = new ArrayList<>(list);

        forMin.remove(list.get(list.size() - 1));
        forMax.remove(list.get(0));

        long minSum = 0;
        for(int k : forMin) {

            minSum += k;
        }

        long maxSum = 0;
        for(int k : forMax) {

            maxSum += k;
        }

        System.out.println(minSum + " " + maxSum);

    }

    //9

    public static int birthdayCakeCandles(List<Integer> candles) {

        Set<Integer> list = new HashSet<>(candles);

        int maxVal = Collections.max(list);

        int ret = Collections.frequency(candles, maxVal);

        return ret;

    }

    //10

    static String timeConversion(String s) {

        String hour = s.substring(0, 2);
        String minute = s.substring(3, 5);
        String second = s.substring(6, 8);
        String format = s.substring(8, 10);

        int intOfHour = Integer.parseInt(hour);
        int plusPM = intOfHour + 12;

        String pmString = String.valueOf(plusPM);
        String amString = hour;

        if(format.equals("PM")) {

            if(hour.equals("12")) {

                return intOfHour + ":" + minute + ":" + second;

            }

            return pmString + ":" + minute + ":" + second;

        }
        else {

            if(amString.equals("12")) {

                amString = "00";
            }

            return amString + ":" + minute + ":" + second;

        }

    }

}
