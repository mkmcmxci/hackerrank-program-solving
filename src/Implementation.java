import java.util.*;

public class Implementation {

    //1

    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> list = new ArrayList<>();

        for(int g : grades) {

            if(g >= 38 && (g % 5) >= 3) {

                if((g % 5) == 4) {

                    g = g + 1;

                }

                else if((g % 5) == 3) {

                    g = g + 2;

                }

                list.add(g);

            }
            else if(g >= 38 && g % 5 < 3) {

                list.add(g);

            }
            else {

                list.add(g);
            }

        }

        return list;

    }

    //2

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

        List<Integer> applesList = new ArrayList<>();
        List<Integer> orangesList = new ArrayList<>();

        for(int apple : apples) {

            applesList.add(apple + a);

        }

        for(int orange : oranges) {

            orangesList.add(orange + b);

        }

        int orangeCount = 0;
        int appleCount = 0;

        for(int ap : applesList) {

            if(ap >= s && ap <= t) {

                appleCount += 1;
            }

        }

        for(int or : orangesList) {

            if(or >= s && or <= t) {

                orangeCount += 1;
            }

        }

        System.out.println(appleCount);
        System.out.println(orangeCount);

    }

    //3

    static String kangaroo(int x1, int v1, int x2, int v2) {

        if((x2 > x1 && v2 > v1) || (x1 > x2 && v1 > v2) || (v1 == v2)) {

            return "NO";
        }

        else if((x1 - x2) % (v2 - v1) == 0) {

            return "YES";
        }
        else {

            return "NO";
        }

    }

    //4

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        List<Integer> list = new ArrayList<>();

        for(int i = a.get(a.size() - 1); i < b.get(0) + 1; i++) {

            for(int k : a) {

                if(i % k == 0) {

                    list.add(i);

                }

            }
        }

        List<Integer> nList = new ArrayList<>();

        for(int y : list) {

            int j = Collections.frequency(list, y);

            if(j == a.size()) {

                nList.add(y);
            }

        }

        Set<Integer> s = new HashSet<>(nList);

        List<Integer> ss = new ArrayList<>(s);

        List<Integer> list1 = new ArrayList<>();

        for(int u : ss) {

            for(int uu : b) {

                if(uu % u == 0) {

                    list1.add(u);

                }
            }

        }

        List<Integer> hh = new ArrayList<>();

        for(int t : list1) {

            int jj = Collections.frequency(list1, t);

            if(jj == b.size()) {

                hh.add(t);
            }

        }

        Set<Integer> sss = new HashSet<>(hh);

        return sss.size();
    }

    //5

    static int[] breakingRecords(int[] scores) {

        List<Integer> list2 = new ArrayList<>();

        int[] list = new int[2];

        int highest = 0;

        int breakMax;

        if(scores[0] != 0) {

            breakMax = -1;

        }
        else {

            breakMax = 0;

        }

        for(int i = 0; i < scores.length; i++) {

            if(scores[i] > highest) {

                highest = scores[i];
                breakMax += 1;

            }

        }

        int lowest = scores[0];
        int breakMin = 0;

        for(int i = 0; i < scores.length; i++) {

            if(scores[i] < lowest) {

                lowest = scores[i];
                breakMin += 1;

            }

        }

        list2.add(breakMax);
        list2.add(breakMin);

        list[0] = list2.get(0);
        list[1] = list2.get(1);

        return list;

    }

    //6

    static int birthday(List<Integer> s, int d, int m) {

        int counter = 0;
        int sum = 0;

        if(s.size() == 1 && m == 1 && s.get(0) == d) {

            counter = 1;

        }

        else {

            for(int i = 0; i < s.size() - m + 1; i++) {

                List<Integer> subList = s.subList(i, i + m);

                System.out.println(subList);

                for(int k : subList) {

                    sum += k;

                }

                if(sum == d) {

                    counter++;

                }

                sum = 0;

            }

        }

        return counter;
    }

    //7

    static int divisibleSumPairs(int n, int k, int[] ar) {

        int sum = 0;

        if(ar.length == n) {

            for(int i = 0; i < ar.length; i++) {

                for(int j = 0; j < ar.length; j++) {

                    if(i < j && (ar[i] + ar[j]) % k == 0) {

                        sum++;

                    }

                }

            }

            return sum;

        }
        else {

            return 0;
        }

    }

    //8

    static int migratoryBirds(List<Integer> arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.size(); i++) {

            int freq = Collections.frequency(arr, arr.get(i));

            map.put(arr.get(i), freq);

        }

        int mostFreq = 0;

        for(Map.Entry<Integer, Integer> m : map.entrySet()) {

            if(m.getValue() >= mostFreq) {

                mostFreq = m.getValue();

            }

        }

        List<Integer> list2 = new ArrayList<>();

        for(Map.Entry<Integer, Integer> u : map.entrySet()) {

            if(mostFreq == u.getValue()) {

                list2.add(u.getKey());

            }

        }

        return Collections.min(list2);

    }

    //9

    static String dayOfProgrammer(int year) {

        if(year < 1918) {

            if(year % 4 == 0) {

                return "12.09." + year;

            }

            else {

                return "13.09." + year;

            }

        }

        else if(year == 1918) {

            return "26.09." + year;

        }

        else {

            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {

                return "12.09." + year;

            }

            else {

                return "13.09." + year;
            }
        }

    }

    //10

    static void bonAppetit(List<Integer> bill, int k, int b) {

        int billSum = 0;
        int annaPrice = bill.get(k);

        for(int bb : bill) {

            billSum += bb;

        }

        int actual = (billSum - annaPrice) / 2;

        int wrong = b - actual;

        if(wrong == 0) {

            System.out.println("Bon Appetit");
        }

        else {

            System.out.println(wrong);

        }

    }

}
