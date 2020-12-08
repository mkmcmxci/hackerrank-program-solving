import java.util.ArrayList;
import java.util.List;

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



}
