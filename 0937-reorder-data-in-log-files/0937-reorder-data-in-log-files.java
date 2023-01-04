class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitArray = new ArrayList<>();
        List<String[]> letterArray = new ArrayList<>();
        int n = logs.length;
        String[] ans = new String[n];
        
        
        for (String log: logs) {
            String[] contents = log.split(" ");
            
            try {
                Double.valueOf(contents[1]);
                digitArray.add(log);
            } catch (Exception e) {
                String[] letterLog = new String[2];
                letterLog[0] = contents[0];
                letterLog[1] = log.substring(contents[0].length() + 1);
                letterArray.add(letterLog);
            }
        }
        
        Collections.sort(letterArray, new Comparator<String[]> () {
            @Override
            public int compare(String[] a, String[] b) {
                if (a[1].compareTo(b[1]) == 0) return a[0].compareTo(b[0]);
                return a[1].compareTo(b[1]);
            }
        });
        
        int idx = 0;
        for(String[] x: letterArray) {
            String log = String.join(" ", x);
            ans[idx] = log;
            idx++;
        }
        
        for (String y: digitArray) {
            ans[idx] = y;
            idx++;
        }
        
        
        
        return ans;
    }
}