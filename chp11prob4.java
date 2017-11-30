import java.util.ArrayList;

public class chp11prob4 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(99);
        System.out.println(max(list));
    }

    public static Integer max(ArrayList<Integer> list){
        int max = list.get(0);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)>max){
                max = list.get(i);
            }

        }
        return max;
    }

}