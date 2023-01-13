class Solution {
    //Copy Pasted discussion
    public int longestPath(int[] parents, String s) {
        char[] a = s.toCharArray();
        int n = a.length, res = 1; // res is what we return
        
        // topo sort, count in-degree first (in=degree here means child -> parent)
        int[] degree = new int[n];
        for (int i = 1; i < n; i++) degree[parents[i]]++; // skip root
        
        // q: seed queue for topo sort, start with leaf nodes(in-degree = 0)
        int[] q = new int[n];
        int qIdx = -1; // index for q (Actually a stack?)
        for (int i = 1; i < n; i++) // skip root
            if (degree[i] == 0) q[++qIdx] = i;
        
        int[] path = new int[n]; // max length of path for each node
        Arrays.fill(path, 1); // every node is a path of length 1
        
        while (qIdx >= 0) { // topo sort till the end
            int c = q[qIdx--]; // c: child index
            int p = parents[c]; // p: parent index
            if (--degree[p] == 0 && p != 0) q[++qIdx] = p; // do not process root
            
            if (a[p] == a[c]) continue; // nothing to update
            
            // we must update res first, otherwise we may double count the same path
            res = Math.max(res, path[p] + path[c]);
            path[p] = Math.max(path[p], path[c] + 1);
        }

        return res;
    }
}
