class Solution {
    
    public void reverse(int[] arr, int i){
        if(i == 0) return ;
        int j = 0;
        
        while(i > j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i--;
            j++;
        }
    }
    
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> ans = new ArrayList<>();
        
        int idx = arr.length - 1;
        for(int i = idx; i >= 0; --i){
            if(arr[i] != i+1){
                for(int j = 0; j < i; ++j){
                    if(arr[j] == i+1 && j != 0){
                        ans.add(j+1);
                        reverse(arr, j);
                    }
                }
                ans.add(i+1);
                reverse(arr, i);
            }
        }
        
        return ans;
    }
}