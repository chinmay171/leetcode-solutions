class Solution {
    public int maxOfArray(int[] books, int N){
        int max = 0;
        for(int i = 0; i<N; ++i){
            max = Math.max(max, books[i]);
        }
        return max;
    }
    
    public int sumOfArray(int[] books, int N){
        int sum = 0;
        for(int i = 0; i<N; ++i){
            sum += books[i];
        }
        return sum;
    }
    
    public boolean isPossible(int[] pages, int maxLoads, int books, int totalStudents){
        int currStudents = 1;
        int currPages = 0;
        for(int i = 0;currStudents<= totalStudents && i<books; i++){
            if(currPages+pages[i] <= maxLoads){
                currPages += pages[i];
            }else{
                currStudents++;
                currPages = pages[i];
            }
        }
        if(currStudents > totalStudents) return false;
        return true;
    }
    
    public int findPages(int[]A,int N,int M)
    {
        //Your code here
        int left = maxOfArray(A, N);
        int right = sumOfArray(A, N);
        int ans = right;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(isPossible(A,mid,N,M) == true){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    public int shipWithinDays(int[] weights, int days) {
        return findPages(weights, weights.length, days);
    }
}