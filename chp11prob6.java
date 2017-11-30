import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Date;

public class chp11prob6 {
    public static void main(String[] args){
        ArrayList<Object> stuff = new ArrayList<>();
        stuff.add(new String("helo"));
        stuff.add(new Date());
        stuff.add(new Circle());
//        stuff.add(new Loan());


        for(int i = 0; i< stuff.size(); i++){
            System.out.println(stuff.get(i).toString());
        }

    }
}
