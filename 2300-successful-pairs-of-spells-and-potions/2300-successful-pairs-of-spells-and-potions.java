class Solution {
    public int binarySearch(int[] arr, long success, int currSpell){
        int left = 0;
        int right = arr.length;
        
        while(left < right){
            int mid = left + (right - left)/2;
            
            if((long)arr[mid] * currSpell >= success) right = mid;
            else left = mid + 1;
        }
        return arr.length - left;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans  = new int[spells.length];
        Arrays.sort(potions);
        
        for(int i = 0; i < spells.length; ++i) 
            ans[i] = binarySearch(potions, success, spells[i]);
        
        return ans;
    }
}