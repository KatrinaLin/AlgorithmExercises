class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(sc)) {
                if (map.containsValue(tc)) return false; // tc is already mapped by another character
                map.put(sc, tc);
            } else if (map.get(sc) != tc) {
                return false;   // sc is already mapped to another character
            }
        }
        
        return true;
    }
}