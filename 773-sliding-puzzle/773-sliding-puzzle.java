class Pair{
    String str;
    int valueOf0;
    int moves;
    
    public Pair(String str, int valueOf0, int moves){
        this.str = str;
        this.valueOf0 = valueOf0;
        this.moves = moves;
    }
}

class Solution {
    
    int[][] adj = {{1, 3},{0, 2, 4},{1, 5},{0, 4},{3, 1, 5},{4, 2}};
    
    public String swap(String str, int i, int j){
        
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
        
    }
    
    public int slidingPuzzle(int[][] board) {
        
        String req = "123450";
        
        StringBuilder s = new StringBuilder("");
        int idx = 0;
        boolean flag = false;
        for(int i = 0 ; i < 2; ++i){
            for(int j = 0; j < 3; ++j){
                if(flag == false){
                    if(board[i][j] == 0){
                        flag = true;
                    }else{
                        idx++;
                    }
                }
                s.append(Integer.toString(board[i][j]));
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s.toString(), idx, 0));
        
        HashMap<String, Integer> vis = new HashMap<>();
        
        int maxMoves = -1;
        while(q.size() > 0){
            Pair top = q.remove();
            
            // System.out.println(top.str + " " + top.moves);
            
            if(vis.get(top.str) != null){
                continue;
            }
            vis.put(top.str, 1);
            
            maxMoves = Math.max(maxMoves, top.moves);
            
            if(req.equals(top.str)){
                return maxMoves;
            }
            
            for(int nValueOf0: adj[top.valueOf0]){
                String nStr = swap(top.str, top.valueOf0, nValueOf0);
                
                q.add(new Pair(nStr, nValueOf0, top.moves + 1));
            }
        }
        return -1;
    }
}