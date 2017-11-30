import java.util.ArrayList;
import java.util.Scanner;
public class Chp11prob14 {
    public static void main(String[] args){
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        ArrayList<Integer> newlist1 = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println("give 5 ints");
        for(int i = 0; i<5; i++){
            newlist.add(scan.nextInt());
        }
        System.out.println("give 5 ints");
        for(int i = 0; i<5; i++){
            newlist1.add(scan.nextInt());
        }
        ArrayList<Integer> combinedlist = union(newlist1, newlist);
        for(int i = 0; i<combinedlist.size(); i++){
            System.out.println(combinedlist.get(i));
        }
    }
    public static ArrayList<Integer> union (ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> combined = new ArrayList<>(list1.size()+list2.size());

        for(int i = 0; i<list1.size(); i++){
            combined.add(list1.get(i));
        }
        for (int i =0; i < list2.size(); i++){
            combined.add(list2.get(i));
        }
        return combined;
    }
}
