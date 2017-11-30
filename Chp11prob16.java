import java.util.ArrayList;
import java.util.Scanner;
public class Chp11prob16 {
    public static void main(String[] args) {
        int n1 = (int)(Math.random() * 10);
        int n2 = (int)(Math.random() * 10);

        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> answers = new ArrayList<Integer>();

        System.out.print(
                "What is " + n1 + " + " + n2 + "? ");
        int user = scan.nextInt();

        while (n1 + n2 != user) {
            if (answers.contains(user))
                System.out.println("You previously answered: " + user);
            else {
                System.out.print("Wrong try again.");
                answers.add(user);
            }
            user = scan.nextInt();
        }
        System.out.println("You got it!");
    }
}
