import javax.crypto.MacSpi;
import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class Strings {

    //1

    static int camelcase(String s) {

        int sum = 1;

        for(int i = 0; i < s.length(); i++) {

            if(Character.isUpperCase(s.charAt(i))) {

                sum += 1;

            }

        }

        return sum;

    }

    //2

    static String superReducedString(String s) {

        for(int i = 1; i < s.length(); i++) {

            if(s.charAt(i) == s.charAt(i - 1)) {
                s = s.substring(0, i - 1) + s.substring(i + 1);
                i = 0;
            }

        }
        if(s.length() == 0) {
            return "Empty String";
        }
        else {
            return s;
        }
    }

    //3

    static String funnyString(String s) {

        List<Integer> asciiList = new ArrayList<>();
        List<Integer> asciiListReserve = new ArrayList<>();

        String res = "";

        for(int i = 0; i < s.length(); i++) {

            String resChar = Character.toString(s.charAt(s.length() - i - 1));

            res = res + resChar;

            int ascii = s.charAt(i);

            asciiList.add(ascii);

        }

        for(int i = 0; i < res.length(); i++) {

            int asciiR = res.charAt(i);

            asciiListReserve.add(asciiR);

        }

        List<Integer> asciiListDif = new ArrayList<>();
        List<Integer> asciiListDifR = new ArrayList<>();

        for(int o = 0; o < asciiList.size() - 1; o++) {

            int abss = Math.abs(asciiList.get(o) - asciiList.get(o + 1));

            asciiListDif.add(abss);
        }

        for(int o = 0; o < asciiListReserve.size() - 1; o++) {

            int abssR = Math.abs(asciiListReserve.get(o) - asciiListReserve.get(o + 1));

            asciiListDifR.add(abssR);
        }

        if(asciiListDif.equals(asciiListDifR)) {

            return "Funny";
        }

        else {

            return "Not Funny";

        }

    }

    //4

    static int stringConstruction(String s) {

        Set<String> ss = new HashSet<>();

        for(char c : s.toCharArray()) {

            ss.add(String.valueOf(c));

        }

        return ss.size();

    }

    //5

    static int alternatingCharacters(String s) {

        int sum = 0;

        for(int i = 1; i < s.length(); i++) {

            if(s.charAt(i - 1) == s.charAt(i)) {

                sum++;

            }

        }

        return sum;
    }

    //6

    static int marsExploration(String s) {

        String sosFirst = "SOS";
        int sumSum = 0;

        for(int i = 0; i < s.length() / 3; i++) {

            String sos = s.substring(i * 3, i * 3 + 3);

            System.out.println(sos + " SOS");

            for(int v = 0; v < sos.length(); v++) {

                if(sos.charAt(v) != sosFirst.charAt(v)) {

                    sumSum++;

                }

            }

        }

        return sumSum;

    }

    //7

    static String caesarCipher(String s, int k) {

        String alp = "abcdefghijklmnopqrstuvwxyz";
        String newAlp = "";
        k = k % alp.length();

        for(int i = k; i < alp.length(); i++) {

            newAlp += alp.charAt(i);

        }

        for(int j = 0; j < k; j++) {

            newAlp += alp.charAt(j);

        }

        Map<String, String> map = new HashMap<>();

        for(int u = 0; u < newAlp.length(); u++) {

            map.put(String.valueOf(alp.charAt(u)), String.valueOf(newAlp.charAt(u)));
        }

        String newS = "";

        for(int r = 0; r < s.length(); r++) {

            for(Map.Entry<String, String> entry : map.entrySet()) {

                if(String.valueOf(s.charAt(r))
                         .toLowerCase()
                         .equals(entry.getKey())) {

                    if(Character.isUpperCase(s.charAt(r))) {

                        newS += entry.getValue()
                                     .toUpperCase();

                    }
                    else {
                        newS += entry.getValue();

                    }

                }

            }

            if(!alp.contains(String.valueOf(s.charAt(r))
                                   .toLowerCase())) {

                newS += String.valueOf(s.charAt(r));
            }

        }

        return newS;

    }

    //8

    static int minimumNumber(int n, String password) {

        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasNumbers = false;
        boolean hasSpecial = false;

        int addings = 0;

        for(int i = 0; i < password.length(); i++) {

            if(lower_case.contains(String.valueOf(password.charAt(i)))) {

                hasLowerCase = true;

            }

            if(upper_case.contains(String.valueOf(password.charAt(i)))) {

                hasUpperCase = true;
            }

            if(numbers.contains(String.valueOf(password.charAt(i)))) {

                hasNumbers = true;
            }

            if(special_characters.contains(String.valueOf(password.charAt(i)))) {

                hasSpecial = true;
            }

        }

        if(n >= 6) {

            if(!hasLowerCase) {

                addings++;

            }

            if(!hasUpperCase) {

                addings++;

            }
            if(!hasNumbers) {

                addings++;

            }
            if(!hasSpecial) {

                addings++;

            }

            return addings;

        }

        else {

            if(!hasLowerCase) {

                addings++;

            }

            if(!hasUpperCase) {

                addings++;

            }
            if(!hasNumbers) {

                addings++;

            }
            if(!hasSpecial) {

                addings++;

            }

            if(password.length() + addings >= 6) {

                return addings;

            }

            else {

                return 6 - password.length();
            }

        }

    }

    //9

    static int anagram(String s) {

        int count = 0;

        if(s.length() % 2 != 0) {

            return -1;
        }

        else {

            String first = s.substring(0, s.length() / 2);
            String second = s.substring(s.length() / 2, s.length());
            char[] secChar = first.toCharArray();
            for(char c : secChar) {
                int index = second.indexOf(c);
                if(index == -1) {
                    count++;
                }
                else {
                    second = second.substring(0, index) + second.substring(index + 1);
                }

            }

        }

        return count;
    }

    //10

    static String pangrams(String s) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        s = s.replace(" ", "");

        String[] sList = s.split("");

        String[] alphabetList = alphabet.split("");

        int sum = 0;

        List<String> alpList = Arrays.asList(alphabetList);
        List<String> ssList = Arrays.asList(sList);

        String newString = "";

        for(String a : ssList) {

            newString += a.toLowerCase();

        }

        for(String aa : alpList) {

            if(!newString.contains(aa)) {

                sum++;
            }
        }

        if(sum == 0) {

            return "pangram";
        }

        else {

            return "not pangram";
        }

    }

    //11

    static int theLoveLetterMystery(String s) {
        String sSecondHalf = "";
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf;

        if(s.length() % 2 == 0) {

            secondHalf = s.substring(s.length() / 2);
            for(int i = 0; i < secondHalf.length(); i++) {

                sSecondHalf += secondHalf.charAt(secondHalf.length() - i - 1);

            }

        }

        else {

            secondHalf = s.substring(s.length() / 2 + 1);
            for(int i = 0; i < secondHalf.length(); i++) {

                sSecondHalf += secondHalf.charAt(secondHalf.length() - i - 1);

            }

        }

        int sum = 0;

        for(int i = 0; i < firstHalf.length(); i++) {

            sum += Math.abs(firstHalf.charAt(i) - sSecondHalf.charAt(i));

        }

        return sum;
    }

    //12

    static int gemstones(String[] arr) {

        List<String> list = new ArrayList<>(Arrays.asList(arr));

        String biggest = "";

        for(String b : arr) {

            if(b.length() >= biggest.length()) {

                biggest = b;

            }

        }

        Set<String> bigListSet = new HashSet<>(new ArrayList<>(Arrays.asList(biggest.split(""))));

        int bigSum = 0;

        for(String c : bigListSet) {

            int sum = 0;

            for(int i = 0; i < list.size(); i++) {

                if(list.get(i)
                       .contains(String.valueOf(c))) {

                    sum++;

                }

            }

            if(sum == list.size()) {

                bigSum++;
            }
        }

        return bigSum;
    }

    //13

    static String hackerrankInString(String s) {

        String newS = "";
        String hackerrank = "hackerrank";

        outer:
        for(int i = 0; i < hackerrank.length(); i++) {

            for(int j = 0; j < s.length(); j++) {

                if(hackerrank.charAt(i) == s.charAt(j)) {

                    newS += s.charAt(j);

                    s = s.substring(j + 1);

                    continue outer;

                }

            }

        }

        if(newS.equals(hackerrank)) {

            return "YES";
        }

        else {

            return "NO";
        }

    }

    //14

    static String twoStrings(String s1, String s2) {

        boolean result = false;
        String sub = "";

        outer:
        for(int i = 0; i < s1.length(); i++) {

            for(int j = i; j < s1.length(); j++) {

                sub = s1.substring(i, j + 1);

                if(s2.contains(sub)) {

                    result = true;
                    break outer;
                }

            }

        }

        if(result) {

            return "YES";
        }

        else {

            return "NO";
        }

    }

    //15

    static String gameOfThrones(String s) {

        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));

        Set<String> setL = new HashSet<>(list);

        List<String> listL = new ArrayList<>(setL);

        int sumC = 0;
        int sumT = 0;

        if(list.size() % 2 == 0) {

            for(int i = 0; i < setL.size(); i++) {

                int freq = Collections.frequency(list, listL.get(i));

                if(freq % 2 == 0) {

                    sumC++;

                }
            }

            if(sumC == setL.size()) {

                return "YES";
            }
            else {
                return "NO";
            }

        }

        else {

            for(int i = 0; i < setL.size(); i++) {

                int freq = Collections.frequency(list, listL.get(i));

                if(freq % 2 == 0) {

                    sumT++;

                }
            }

            if(sumT + 1 == setL.size()) {

                return "YES";
            }

            else {
                return "NO";
            }

        }

    }

    //16

    static int beautifulBinaryString(String b) {

        String bin = "010";

        int sum = 0;

        for(int i = 3; i < b.length() + 1; i++) {

            if(b.substring(i - 3, i)
                .equals(bin)) {

                sum++;
                i = i + 2;

            }

        }

        return sum;

    }

}
