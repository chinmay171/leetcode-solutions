class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        
        // int ini = arr[0];
        // int diff = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i < arr.length; ++i){
            // diff = arr[i] - arr[i-1];
            set.add(arr[i] - arr[i-1]);
        }
        
        return set.size() < 2;
    }
}