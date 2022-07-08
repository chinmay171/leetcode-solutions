class Solution {
    public int nthUglyNumber(int n) {
        int ptr2 = 1;
        int ptr3 = 1;
        int ptr5 = 1;
        ArrayList<Integer> uglyNumber = new ArrayList<>();
        uglyNumber.add(-1);
        uglyNumber.add(1);
        for(int i = 2; i<=n; ++i){
            int a = uglyNumber.get(ptr2)*2;
            int b = uglyNumber.get(ptr3)*3;
            int c = uglyNumber.get(ptr5)*5;
            
            int min = Math.min(a, Math.min(b, c));
            uglyNumber.add(min);
            if(min == a) ptr2++;
            if(min == b) ptr3++;
            if(min == c) ptr5++;
        }
        return uglyNumber.get(n);
    }
}