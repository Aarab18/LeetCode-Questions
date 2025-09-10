import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> userLangMap = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            userLangMap.put(i + 1, new HashSet<>());
            for (int lang : languages[i]) {
                userLangMap.get(i + 1).add(lang);
            }
        }
        Set<Integer> usersToTeach = new HashSet<>();
        for (int[] pair : friendships) {
            int u = pair[0], v = pair[1];
            Set<Integer> langsU = userLangMap.get(u);
            Set<Integer> langsV = userLangMap.get(v);
            boolean canCommunicate = false;
            for (int lang : langsU) {
                if (langsV.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                usersToTeach.add(u);
                usersToTeach.add(v);
            }
        }
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : usersToTeach) {
                if (!userLangMap.get(user).contains(lang)) {
                    count++;
                }
            }
            minTeach = Math.min(minTeach, count);
        }
        return minTeach;
    }
}