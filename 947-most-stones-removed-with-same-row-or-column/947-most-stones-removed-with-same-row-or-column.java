class Solution {
    
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb)
                return;

            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
                rank[pa] += rank[pb];
            } else {
                parent[pa] = pb;
                rank[pb] += rank[pa];
            }
        }

        public int find(int a) {
            if (parent[a] == -1)
                return a;
            return parent[a] = find(parent[a]);
        }
    }
    
    public int removeStones(int[][] stones) {
        
        DSU sets = new DSU(20005);
        
        for(int[] stone : stones){
            sets.union(stone[0], stone[1] + 10001);
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int[] stone : stones){
            set.add(sets.find(stone[0]));
        }
        
        return stones.length - set.size();
    }
}