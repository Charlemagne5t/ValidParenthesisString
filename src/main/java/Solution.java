public class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] memo = new Boolean[s.length() + 1][s.length() + 1];
        return dfs(s, 0, 0, memo);
    }
    boolean dfs(String s, int i, int count, Boolean[][] memo){
        if(i == s.length()){
            return count == 0;
        }
        if(memo[i][count] != null){
            return memo[i][count];
        }


        if(s.charAt(i) == ')' && count > 0){
            return dfs(s, i + 1, count - 1, memo);
        }
        if(s.charAt(i) == '('){
            return dfs(s, i + 1, count + 1, memo);
        }
        if(s.charAt(i) == '*'){
            if(count > 0){
                if(dfs(s, i + 1, count - 1, memo)){
                    memo[i][count] = true;
                    return true;
                }
            }
            if(dfs(s, i + 1, count + 1, memo)){
                memo[i][count] = true;
                return true;
            }
            if(dfs(s, i + 1, count, memo)){
                memo[i][count] = true;
                return true;
            }

        }
        memo[i][count] = false;
        return false;
    }
}

