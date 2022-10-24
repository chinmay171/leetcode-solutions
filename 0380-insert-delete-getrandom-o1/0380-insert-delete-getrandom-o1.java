// class RandomizedSet { 
    
//     HashMap<Integer, Integer> map;
//     List<Integer> list;
//     // Random r;

//     public RandomizedSet() {
//         map = new HashMap<>();
//         list = new ArrayList<>();
//         // r = new Random();
//     }
    
//     public boolean insert(int val) {
//         if(map.containsKey(val) == true){
//             return false;
//         }
        
//         map.put(val, list.size());
//         list.add(val);
//         return true;
//     }
    
//     public boolean remove(int val) {
//         if(map.containsKey(val) == false){
//             return false;
//         }
        
//         int remIdx = map.get(val);
//         map.remove(remIdx);
        
//         if(remIdx == list.size() - 1){
//             list.remove(list.size() - 1);
//             return true;
//         }
        
//         list.set(remIdx, list.get(list.size() - 1));
//         list.remove(list.size() - 1);
        
//         map.put(list.get(remIdx), remIdx);
//         return true;
//     }
    
//     public int getRandom() {
//         // int randomIdx = r.nextInt(list.size());
//         // return list.get(randomIdx);
//         // return list.get( r.nextInt(list.size()) );
//         // int max = list.size();
//         // int min = 0;
//         // int ind = (int)(Math.random() * (max - min) + min);
//         // return list.get(ind);
//         Random random = new Random();
//         return list.get( random.nextInt(list.size()) );
//     }
// }
public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */