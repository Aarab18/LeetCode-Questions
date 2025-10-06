class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq=new HashMap<>();
        for(char ch : magazine.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }
        int count=0;
        for(char ch : ransomNote.toCharArray()) {
            if(!freq.containsKey(ch)) {
                return false;
            }
            freq.put(ch, freq.get(ch)-1);
            if(freq.get(ch)<0) {
                return false;
            }
            count++;
        }
        if(count==ransomNote.length()) {
            return true;
        }
        return false;
    }
}