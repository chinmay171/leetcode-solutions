class Node{
    int sum, low, high;
    Node left, right;
    
    Node(int sum, int low, int high){
        this.sum = sum;
        this.low = low;
        this.high = high;
    }
}

class Tree{
    static Node build(int low, int high, int[] nums){
        if(low > high) return new Node(0, low, high);
        if(low == high) return new Node(nums[low], low, high);
        
        Node root = new Node(0, low, high);
        int mid = low + (high - low) / 2;
        root.left = build(low, mid, nums);
        root.right = build(mid+1, high, nums);
        
        root.sum = root.left.sum ^ root.right.sum;
        return root;
    }
    
    static void update(Node root, int index, int value){
        if(root.low == root.high){
            root.sum = value;
            return;
        }
        
        int mid = root.low + (root.high - root.low) / 2;
        if(index <= mid) update(root.left, index, value);
        else update(root.right, index, value);
        root.sum = root.left.sum ^ root.right.sum;
    }
    
    static int query(Node root, int low, int high){
        if(root.low > high || root.high < low) return 0;
        if(root.low >= low && root.high <= high) return root.sum;
        
        return query(root.left, low, high) ^ 
               query(root.right, low, high);
    }
}

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        Node root = Tree.build(0, arr.length-1, arr);
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; ++i){
            int left = queries[i][0];
            int right = queries[i][1];
            
            ans[i] = Tree.query(root, left, right);
        }
        
        return ans;
    }
}