class Solution {
    public int strStr(String str1, String str2) {
        if(str2.length() > str1.length()) return -1;
        for(int i = 0; i < str1.length(); ++i){
            int j = 0;
            int k = i;
            while(k < str1.length() && j < str2.length() && str1.charAt(k) == str2.charAt(j)){
                j++;
                k++;
            }
            if(j == str2.length()) return k - j;
        }
        return -1;
    }
}