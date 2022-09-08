class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int[] cuboid : cuboids){
            Arrays.sort(cuboid);
        }
        
        // Arrays.sort(cuboids, new Comparator<int[]>(){
        //    public int compare(int[] first, int[] second){
        //        if(first[0] == second[0]){
        //            return (first[1] - second[1]);
        //         }else{
        //            return (first[0] - second[0]);
        //        }
        //    } 
        // });
        
        Arrays.sort(cuboids, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        
        int n = cuboids.length;
        
//         for(int i = 0; i < n; ++i){
//             System.out.println(cuboids[i][0] + " " + cuboids[i][1] + " " + cuboids[i][2]);
//         }
         
        int[] dp = new int[n];
        int heights = 0;
        
        for(int i = 0; i < n; ++i){
            int currHeight = 0;
            
            for(int j = 0; j < i; ++j){
                if(cuboids[i][1] >= cuboids[j][1] && cuboids[i][0] >= cuboids[j][0] && cuboids[i][2] >= cuboids[j][2]){
                    currHeight = Math.max(currHeight, dp[j]);
                }
            }
            
            dp[i] = currHeight + cuboids[i][2]; 
            
            heights = Math.max(heights , dp[i]);
        }
        
        return heights;
    }
}