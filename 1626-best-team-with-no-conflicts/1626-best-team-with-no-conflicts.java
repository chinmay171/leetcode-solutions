class Solution {
    public class Pair{
        int age;
        int score;
        
        Pair(int age, int score){
            this.age = age;
            this.score = score;
        }
    }
    
    public int bestTeamScore(int[] scores, int[] ages) {
        
        int n = ages.length;
        Pair[] player = new Pair[n];
        
        for(int i = 0; i < n; ++i){
            player[i] = new Pair(ages[i], scores[i]);
        }
        
        Arrays.sort(player, (a, b) -> 
                   a.age != b.age ? b.age - a.age : b.score - a.score);
        
        int[] dp = new int[n];
        int max = player[0].score;
        dp[0] = player[0].score;
        for(int i = 1; i < n; ++i){
            dp[i] = player[i].score;
            
            for(int j = i-1; j >= 0; --j){
                if(player[i].score <= player[j].score){
                    dp[i] = Math.max(dp[i], player[i].score + dp[j]);
                }
                max = Math.max(dp[i], max);
            }
        }
        
        return max;
        
    }
}