import java.util.ArrayList;
import java.util.Collections;

public class practice {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(7);

        int count = Collections.frequency(list, 4);
        System.out.println(count);
    }
}

