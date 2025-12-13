/*
    Find the rage by traversing left to right while r < n-1
*/

public class Jump_Game_II {
    public static int jump(int[] nums) {
        int r = 0;
        int l = 0;
        int n = nums.length;
        int jumps = 0;
        while(r < n-1){
            int farthest = 0;
            for(int i=l; i<=r; i++){
                farthest = Math.max(nums[i]+i, farthest);
            }
            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
