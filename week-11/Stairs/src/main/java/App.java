import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int climbingStairs(int n){
        List<Integer> toReturn = new ArrayList<>();

        toReturn.add(n);


        for(int i = 0; i < toReturn.size(); i++){

            List<Integer> newArr = new ArrayList<>();

            if(toReturn.get(i) == 0){
                continue;
            }else{
                if(toReturn.get(i) - 1 >= 0){
                    newArr.add(toReturn.get(i) - 1);
                }
                if(toReturn.get(i) - 2 >= 0){
                    newArr.add(toReturn.get(i) - 2);
                }
            }

            toReturn = newArr;
        }
    }
}
