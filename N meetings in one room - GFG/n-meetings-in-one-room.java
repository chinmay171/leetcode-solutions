//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static class pair{
        int strt;
        int last;
        int idx;

        public pair(int strt, int last, int idx){
            this.strt = strt;
            this.last = last;
            this.idx = idx;
        }
    }
    public static int maxMeetings(int start[], int end[], int n)
    {
        pair[] duration = new pair[n];
        for(int i = 0; i < n; ++i){
            pair curr = new pair(start[i], end[i], i + 1);
            duration[i] = curr;
        }

        Arrays.sort(duration, (pair a, pair b) ->
                        (a.last != b.last) ? a.last - b.last :
                            a.idx - b.idx);

        int count = 0;
        int lastEndTime = -1;
        for(int i = 0; i < n; ++i){
            if(duration[i].strt > lastEndTime){
                count++;
                lastEndTime = duration[i].last;
            }
        }

        return count;
    }
}
