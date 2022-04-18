import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println(climbingStairs(4));
    }

    public static int climbingStairs(int n) {
        List<Integer> toReturn = new ArrayList<>();

        toReturn.add(n);
        boolean end = true;


        do{
            end = true;
            List<Integer> newArr = new ArrayList<>();
            for (int i = 0; i < toReturn.size(); i++) {
                if (toReturn.get(i) == 0) {
                    newArr.add(0);
                } else {
                    end = false;
                    if (toReturn.get(i) - 1 >= 0) {
                        newArr.add(toReturn.get(i) - 1);
                    }
                    if (toReturn.get(i) - 2 >= 0) {
                        newArr.add(toReturn.get(i) - 2);
                    }
                }




            }
            toReturn = newArr;
        }while (!end);
        return toReturn.size();
    }
}