/* 
    Goto below second solution for cleaner way -
    Below is the my sloution
    Solved - Yes
    2 edge cases - 
        1. if(n==1 && nums[0] = 0) return true;
        2. if(nums[n-1] == 0) store reach = i-1;

    Basically just find that if there is 0 so can some pass the 0

    public class Jump_Game {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1 && nums[0] == 0) return true;
        int reach = -1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] == 0){
                if(i==n-1) reach = i-1;
                if(reach == -1) reach = i;
            }else{
                if(nums[i]+i > reach) reach = -1;
            }
        }
        if(reach == -1) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
*/

/*
    Cleaner way -

*/

public class Jump_Game {
    public static boolean canJump(int[] nums) {
         int max = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(i > max) return false;
            max = Math.max(max, (i + nums[i]));
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}

