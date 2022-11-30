class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            int occurance = map.get(key);
            if (set.contains(occurance)) return false;
            set.add(occurance);
        }
        return true;
    }
}