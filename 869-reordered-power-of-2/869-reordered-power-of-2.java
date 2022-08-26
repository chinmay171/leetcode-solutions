class Solution {
    
    public boolean compareFreqs(int[] freq1, int[] freq2){
        for(int i = 0; i < 10; ++i){
            if(freq1[i] != freq2[i])return false;
        }
        return true;
    }
    
    public int[] getFreqArray(int n){
        int[] freq = new int[10];
        while(n > 0){
            freq[n%10]++;
            n = n/10;
        }
        return freq;
    }
    
    public boolean reorderedPowerOf2(int n) {
        int[] inputFreq = getFreqArray(n);
        
        for(int i = 0; i < 31; ++i){
            int powerOf2 = (int)Math.pow(2, i);
            int[] powerFreq = getFreqArray(powerOf2);
            
            if(compareFreqs(powerFreq, inputFreq) == true)return true;
        }
        
        return false;
    }
}