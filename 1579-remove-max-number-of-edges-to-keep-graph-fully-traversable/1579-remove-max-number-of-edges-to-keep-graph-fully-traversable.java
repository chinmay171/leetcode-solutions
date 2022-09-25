class Solution {
    
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            for(int i = 0; i < n; ++i) parent[i] = i;
            rank = new int[n];
            Arrays.fill(rank, 1);
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
                rank[pa] += rank[pb];
            } else {
                parent[pa] = pb;
                rank[pb] += rank[pa];
            }
            
            return true;
        }

        public int find(int a) {
            if (parent[a] == a) return a;
            return parent[a] = find(parent[a]);
        }
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        
        DSU set1 = new DSU(n+1);
        DSU set2 = new DSU(n+1);
        
        int sizeSet1 = 1;
        int sizeSet2 = 1;
        
        int ans = 0;
        
        for(int[] edge : edges){
            if(edge[0] == 3){
                boolean union1 = set1.union(edge[1], edge[2]);
                boolean union2 = set2.union(edge[1], edge[2]);
                
                if(union1 == true) sizeSet1++;
                if(union2 == true) sizeSet2++;
                if(union1 == false && union2 == false) ans++;

            }else if(edge[0] == 2){
                boolean union2 = set2.union(edge[1], edge[2]);
                
                if(union2 == true) sizeSet2++;
                else ans++;
            }else{
                boolean union1 = set1.union(edge[1], edge[2]);
                
                if(union1 == true) sizeSet1++;
                else ans++;
            }
        }
        
        if(sizeSet1 != n || sizeSet2 != n){
            return -1;
        }
        
        return ans;
    }
}