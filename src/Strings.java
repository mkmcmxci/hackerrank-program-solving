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

}
