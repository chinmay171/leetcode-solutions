class Solution {
    public int compress(char[] chars) {
        
        int currIdx = 0;
        int idx = 0;
        
        while(idx < chars.length){
            char currChar = chars[idx];
            int count = 0;
            while(idx < chars.length && chars[idx] == currChar){
                count++;
                idx++;
            }
            
            chars[currIdx++] = currChar;
            if(count != 1){
                for(char ch : Integer.toString(count).toCharArray()){
                    chars[currIdx++] = ch;
                }
            }
        }
        
        return currIdx;
        
    }
}