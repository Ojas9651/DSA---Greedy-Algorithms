/*
    Optimal Solution -

    donw by using Slope

            .
        .       .                           .
      .            .                   .
    .                 .   .   .   .
  .
  
  */

class Candy {
    public static int candy(int[] ratings) {
        int i = 1;
        int n = ratings.length;
        int sum = 1;
        int peak = 0;
        int down = 0;
        while(i < n){
            if(ratings[i] == ratings[i-1]){
                sum += 1;
                i++;
                continue;
            }
            peak = 1;
            while(i< n && ratings[i] > ratings[i-1]){
                peak++;
                sum = sum + peak;
                i++;
            }
            down = 1;
            while(i < n && ratings[i] < ratings[i-1]){
                sum = sum + down;
                down++;
                i++;
            }
            if(down > peak) sum += down - peak;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }
}



// import java.util.HashMap;

// public class Candy {
//     public int candy(int[] ratings) {
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         int n = ratings.length;
//         hm.put(0, 1);
//         for(int i=1; i<n; i++){
//             if(ratings[i] > ratings[i-1]){
//                 hm.put(i, hm.get(i-1)+1);
//             }else{
//                 hm.put(i, 1);
//             }
//         }
//         int candy = hm.get(n-1);
//         for(int i=n-2; i>=0; i--){
//             if(ratings[i] > ratings[i+1] && hm.get(i) <= hm.get(i+1)){
//                 hm.put(i, hm.get(i+1)+1);
//                 candy += hm.get(i);
//             }else{
//                 candy += hm.get(i);
//             }
//         }
//         return candy;
//     }
// }
