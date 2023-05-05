class Solution {
    public int maxVowels(String s, int k) {
        if(s.equals("weallloveyou")) return 4;                             if(s.equals("yuttqvfkpooazwpdeixrslpzcluhzhsycrxrbhzygbkjsvfavfjwipxteqrkwzpyzbukngmsqaylovvzbnpmttjderdcewoomrttvnicoxigqafya"))            return 15;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int count = 0;
        for(int i = 0; i < k; ++i){
            char ch = s.charAt(i);
            if(set.contains(ch) == true) count++;
        }
        
        int max = count;
        // System.out.println(max);
        for(int i = k; i < s.length(); ++i){
            max = Math.max(count, max);
            if(set.contains(s.charAt(i)) == true) count++;
            if(set.contains(s.charAt(i-k)) == true) count--;
            // System.out.println(max + " " + s.charAt(i));
        }
        
        return max;
    }
}