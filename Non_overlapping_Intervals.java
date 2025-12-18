/*
    TC - O(N log N) + O(N)
    SC - O(log N) - due to auxilary space while sorting a 2D array
    
    Approach -
        Sort the intervals array based on ending index of intervals[i]
        If intervals[i][1] > intervals[i][0] - its a overlaping interal and we can remove it
*/

import java.util.Arrays;

public class Non_overlapping_Intervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int n = intervals.length;
        if(n <= 1) return 0;
        int count = 0;
        int i = 1;
        int end = intervals[0][1];
        while(i < n){
            if(end > intervals[i][0]){
                count++;
            }else{
                end = intervals[i][1];
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}

