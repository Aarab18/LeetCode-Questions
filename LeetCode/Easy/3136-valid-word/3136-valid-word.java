class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) {
            return false;
        }
        int vowels=0, consonants=0;
        for (char ch : word.toCharArray()) {
            if(!Character.isDigit(ch) && !Character.isLetter(ch)) {
                return false;
            }
            else if(Character.isLetter(ch)) {
                char c=Character.toLowerCase(ch);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                    vowels++;
                }
                else {
                    consonants++;
                }
            }
        }
        if(vowels!=0 && consonants!=0) {
            return true;
        }
        return false;
    }
}