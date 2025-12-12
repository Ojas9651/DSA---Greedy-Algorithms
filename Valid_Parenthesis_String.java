/*
    Approach is that is there were no * then we take a counter and do count++ if s[i] = '(' and do count-- if s[i] = ')' and if count is 0 we return true.

    Solution -

    Maintaing a range min - max
    1. if s[i] == '(' --> min++ and max++
    2. if s[i] == ')' --> min-- and max--
    3. if s[i] == "*" then there are 3 posibilities * can be '(' , * can be ')' or * can be a empty string but keep in mind that min can never be -1 so if we always set it to 0 if goes below 0 and so will do --> min-- and max++
    4. Edge Cases --> if min < 0 -> min = 0; and if max < 0 -> return false 
    5. when loop ends return true if min == 0
*/

public class Valid_Parenthesis_String {
    public static boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }else if(s.charAt(i) == ')'){
                min--;
                max--;
            }else{
                min--;
                max++;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        if(min == 0) return true; 
        return false;
    }
    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s));
    }
}
