class Solution {
    public int findComplement(int num) {
        int not = ~num;
        int prev = Integer.highestOneBit(num) - 1;
        return not & prev;
    }
}