class Solution {
    public boolean detectCapitalUse(String word) {
        if (!Character.isUpperCase(word.charAt(0))) {
            int countLowercase = 1;
            for (int i = 1; i < word.length();i++ ){
                if (!Character.isUpperCase(word.charAt(i))) countLowercase++;
            }
        
            return (countLowercase == word.length());
        }
        int countUppercase = 1;
        for (int i = 1; i < word.length();i++ ){
            if (Character.isUpperCase(word.charAt(i))) countUppercase++;
        }
        
        return (countUppercase == 1 || countUppercase == word.length());
    }
}