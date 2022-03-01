import java.util.Scanner;

public class searchInsert1 {



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] nums = new int[4];
        for(int i = 0; i < nums.length; i++) {
            System.out.printf("Input number %s in array:\n", (i + 1));
            int input = scn.nextInt();
            nums[i] = input;
        }
        System.out.println("Input a target: ");
        int target = scn.nextInt();
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[]nums, int target){
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                index = i;
                break;
            }else if(nums[i] > target){
                index = i;
                break;
            }else{
                index = nums.length;
            }
        }
        return index;
    }


}