public class Insert_Interval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        int ind_s = -1;
        int ind_e = -1;
        for(int i=0; i<m; i++){
            if(start >= intervals[i][0] && start <= intervals[i][1]){
                ind_s = i;
            }
            if(end >= intervals[i][0] && end <= intervals[i][1]){
                ind_e = i;
            }
        }
        int index = 0;
        if(ind_e == -1) index = ind_s + 1;
        else index = ind_e - ind_s + 1;
        int n = m - index + 1;
        int[][] ans = new int[n][2];
        for(int i=0; i<ans.length; i++){
            if(i == ind_s){
               ans[i][0] = intervals[ind_s][0];
               if(ind_e == -1){
                    ans[i][1] = end; 
               }else{
                ans[i][1] = intervals[ind_e][1];
               }
               
            }else{
                if(i < ind_s){
                    ans[i][0] = intervals[i][0];
                    ans[i][1] = intervals[i][1];
                }
                if(i > ind_s && i > ind_e){
                    if(ind_e == -1){
                        ans[i][0] = intervals[ind_s+1][0];
                        ans[i][1] = intervals[ind_s+1][1];
                    }else{
                        ans[i][0] = intervals[ind_e+1][0];
                        ans[i][1] = intervals[ind_e+1][1];
                    }
                }
            }
        }
        System.out.println(ind_s);
        System.out.println(ind_e);
        return ans;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        insert(intervals, newInterval);
    }    
}
