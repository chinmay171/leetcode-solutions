class Solution {
    
    public static int find(int x, int parent[]) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }

    public static boolean union(int x, int y, int parent[], int rank[]) {
        int lx = find(x, parent);
        int ly = find(y, parent);
 
        if (lx != ly) {
            if (rank[x] > rank[y]) {
                parent[ly] = lx;
            } else if (rank[x] < rank[y]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
        else return false;
        return true;
    }
    
    public static int[] findRedundantConnection(int[][] edges,int ex) {
        int ans[]=new int[0];
        int parent[]=new int[edges.length+1];
        int rank[]=new int[edges.length+1];
        Arrays.fill(rank,1);
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++){
            if(i==ex) continue;
            boolean b=union(edges[i][0],edges[i][1],parent,rank);
            if(b==false) return edges[i];
        }
        
        return ans;
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int indig[]=new int[edges.length+1];
        Arrays.fill(indig,-1);
        int bl1=-1;
        int bl2=-1;
        for(int i=0;i<edges.length;i++){
            if(indig[edges[i][1]]!=-1){
                bl2=indig[edges[i][1]];
                bl1=i;
                break;  
            }
            else indig[edges[i][1]]=i;
        }
        if(bl1==-1 && bl2==-1){
          return findRedundantConnection(edges,-1);
        }else{
            int ans[]= findRedundantConnection(edges,bl1);
            if(ans.length==0) return edges[bl1];
            else return edges[bl2];
        }
    }
}