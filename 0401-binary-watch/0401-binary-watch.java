class Solution {
     public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int hh = 0; hh < 12; hh++)
            for (int mn = 0; mn < 60; mn++)
                if (aux(hh, mn, num))
                    if (mn < 10)
                        result.add(String.format("%d:0%d", hh, mn));
                    else
                        result.add(String.format("%d:%d", hh, mn));
        return result;    
    }
    private boolean aux(int hh, int mn, int num){
        int temp = 0;
        while(hh != 0 || mn != 0){
            if (hh !=0 ){
                temp += hh % 2;
                hh /=2;
            }
            if (mn != 0){
                temp += mn % 2;
                mn /= 2;
            }
        }
        return temp == num;
    }
}