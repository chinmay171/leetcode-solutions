class Solution {
    public int bitwiseComplement(int num) {
        if(num == 0) return 1;
        int not = ~num;
        int prev = Integer.highestOneBit(num) - 1;
        return not & prev;
    }
}