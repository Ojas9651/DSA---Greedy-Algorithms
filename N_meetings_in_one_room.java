/*
    TC - O(2N) + O(N log N) -> O(N log N)
    SC - O(2N) -> O(N)

    Approach -
        make 2D array where arr[i] = [start, end];
        sort the arr by end 
        we cannot start meeting if arr[i][0] < freetime
*/

import java.util.Arrays;

public class N_meetings_in_one_room {
    public static int maxMeetings(int[] start, int[] end) {
       if(start.length == 1) return 1; 
       int[][] arr = new int[start.length][2];
       for(int i=0; i<end.length; i++){
        arr[i][0] = start[i];
        arr[i][1] = end[i];
       }
       Arrays.sort(arr, (a,b) -> a[1] - b[1]);
       int freeTime = arr[0][1];
       int count = 1;
       for(int i=1; i<arr.length; i++){
            if(arr[i][0] > freeTime){
                count++;
                freeTime = arr[i][1];
            }
       }
       return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end));
    
    }
}
