import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy {

    //1

    static long marcsCakewalk(int[] calorie) {

        List<Integer> list = new ArrayList<>();

        for(int i : calorie) {

            list.add(i);
        }

        Collections.sort(list);

        Collections.reverse(list);

        long sum = 0L;

        for(int i = 0; i < list.size(); i++) {

            sum += Math.pow(2, i) * list.get(i);

        }

        return sum;

    }

}
