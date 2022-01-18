class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        int len = p.length();
        if (s.length() < len) return ans;
        
        int[] dict = new int[26];
        for (char c: p.toCharArray()) dict[c - 'a']++;
        
        char[] arr = s.toCharArray();
        
        int left = 0, right = 0, matchCount = 0;
        
        while (right < s.length()) {
            // move right for one step, if it is a match, add matchCount
            if (dict[arr[right] - 'a'] > 0) {
                matchCount++;
            }
            dict[arr[right] - 'a']--;
            right++;
            
            // check if it is valid ans
            if (matchCount == len) ans.add(left);
            
            // if at boundary then move left one step
            if (right - left == len) {
                // if left was in p, reverse the change
                if (dict[arr[left] - 'a'] >= 0) {
                    matchCount--;
                }
                
                dict[arr[left] - 'a']++;
                left++;
            }
        }
        
        return ans;
    }
}