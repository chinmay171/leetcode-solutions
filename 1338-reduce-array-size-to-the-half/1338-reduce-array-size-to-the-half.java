class Solution {
    public int minSetSize(int[] arr) {
        //hashmap<unique val in arr, and its freq>
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < arr.length; ++i){
            if(hm.containsKey(arr[i]) == false){
                hm.put(arr[i], 0);
            }
            hm.put(arr[i], hm.get(arr[i])+1);
        }
        
        int[] freq = new int[hm.size()];
        int i = 0;
        for(int freqInHm : hm.values()){
            freq[i] = freqInHm;
            i++;
        }
        Arrays.sort(freq);
        
        int sum = 0;
        for(int j = freq.length-1; j >= 0; --j){
            sum += freq[j];
            if(sum >= arr.length/2){
                return (freq.length - j);
            }
        }
        return 0;
    }
}