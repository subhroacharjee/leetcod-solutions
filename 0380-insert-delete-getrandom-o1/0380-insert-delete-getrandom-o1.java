class RandomizedSet {
    HashSet<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        Integer[] arr = set.toArray(new Integer[set.size()]);
        Random rand = new Random();
        
        return (int)arr[rand.nextInt(arr.length)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */