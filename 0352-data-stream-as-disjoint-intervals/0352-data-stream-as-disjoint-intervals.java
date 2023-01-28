class SummaryRanges {
    private Set<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();
    }
    
    public void addNum(int value) {
        set.add(value); // O(lgn)
    }
    
    public int[][] getIntervals() {
        Set<Integer> visited = new HashSet<>();
        List<int[]> tempAns = new ArrayList<>();
        for (int value: set) {
            if (visited.contains(value)) continue;
            int[] pair = new int[2];
            pair[0] = value;
            for (int i = value; set.contains(i); i++) {
                pair[1] = i;
                visited.add(i);
            }
            tempAns.add(pair);
        }
        
        return tempAns.toArray(new int[tempAns.size()][2]);
    } 
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */