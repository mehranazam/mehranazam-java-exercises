import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4};
        int[] arrNext = {1, 1, 2, 1, 1};
        int[] arrNextNext = {1, 1, 1, 1, 1};

        System.out.println(CountClumps(arr));
        System.out.println(CountClumps(arrNext));
        System.out.println(CountClumps(arrNextNext));

    }


    public static int CountClumps(int[] arr){

        int count = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(i == 0 && arr[i] == arr[i + 1]){
                count++;
            }else if(arr[i + 1] == arr[i] && arr[i - 1] != arr[i]){
                count++;
            }
        }
        return count;
    }
}
