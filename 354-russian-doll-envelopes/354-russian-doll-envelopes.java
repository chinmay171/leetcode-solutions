class Solution {
    public int lowerBound(ArrayList<Integer> arr, int target){
        int low = 0;
        int high = arr.size()-1;
        int idx = arr.size();
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(arr.get(mid) < target){
                low = mid+1;
            }else{
                high = mid-1;
                idx = mid;
            }
        }
        return idx;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] first, int[] second) ->{
            return (first[0] != second[0]) ? first[0] - second[0]
                :second[1]-first[1];
        });
        int n = envelopes.length;
        ArrayList<Integer> sorted = new ArrayList<>();
        for(int i = 0; i<envelopes.length; ++i){
            int lb = lowerBound(sorted, envelopes[i][1]);
            if(lb == sorted.size()){
                sorted.add(envelopes[i][1]);
            }else{
                sorted.set(lb, envelopes[i][1]);
            }
        }
        return sorted.size();
    }
}