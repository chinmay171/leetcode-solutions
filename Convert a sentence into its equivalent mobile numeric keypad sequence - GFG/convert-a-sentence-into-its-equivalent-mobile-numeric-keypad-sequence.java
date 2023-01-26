//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String printSequence(String S) 
    { 
        HashMap<Character, String> map = new HashMap<>();
        map.put('A', "2");
        map.put('B', "22");
        map.put('C', "222");
        map.put('D', "3");
        map.put('E', "33");
        map.put('F', "333");
        map.put('G', "4");
        map.put('H', "44");
        map.put('I', "444");
        map.put('J', "5");
        map.put('K', "55");
        map.put('L', "555");
        map.put('M', "6");
        map.put('N', "66");
        map.put('O', "666");
        map.put('P', "7");
        map.put('Q', "77");
        map.put('R', "777");
        map.put('S', "7777");
        map.put('T', "8");
        map.put('U', "88");
        map.put('V', "888");
        map.put('W', "9");
        map.put('X', "99");
        map.put('Y', "999");
        map.put('Z', "9999");
        map.put(' ', "0");
        
        String ans = "";
        for(char ch : S.toCharArray()){
            ans = ans + map.get(ch);
        }
        return ans;
    }
}