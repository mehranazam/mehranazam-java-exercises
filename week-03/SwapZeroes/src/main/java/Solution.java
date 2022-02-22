public class Solution {


    public static void main(String[] args) {
        int []nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }



    public static void moveZeroes(int[] nums) {
        int j = 0;
        int sumOfZeroes = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++){
            System.out.print(nums[i] + ", ");
            if(nums[i] == 0){
                sumOfZeroes++;


            }

        }

        for(int i = 0; i < length; i++){
            if(nums[i] == 0){
                while(nums[i] == 0 && i < (length - sumOfZeroes)){
                    for(int k = i; k + 1 < length; k++){
                        nums[k] = nums[k + 1];
                    }
                    nums[length - 1] = 0;
                }
            }
        }
        System.out.println();
        for(int i = 0; i < length; i++) {

            System.out.print(nums[i] + ", ");
        }
    }
}