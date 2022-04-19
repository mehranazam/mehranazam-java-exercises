public class App {
    public static void main(String[] args) {
        int[] numsOne = {2, 3, 1, 1, 4};
        int[] numsTwo = {3, 2, 1, 0, 4};
        System.out.println(canJump(numsOne));
        System.out.println(canJump(numsTwo));
    }


    public static boolean canJump(int[] nums) {
        boolean toReturn = false;
        if(nums.length == 1){
            toReturn = true;
            return toReturn;
        }


        for (int i = 0; i < nums.length; i++) {
            // i += nums[i];
            System.out.println("outer loop i: " + i);

            if(nums[i] == 0){
                return toReturn;
            }

            if(nums[i] == 0){
                continue;
            }

            for (int j = nums[i]; j > 0; j--) {
                System.out.println(j);
                if (i + j == nums.length - 1) {
                    toReturn = true;
                    return toReturn;
                }
                // call canJump
            }
        }
        // if i = nums.length - 1 return true
        return toReturn;
    }


}