class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            if (pre.length() == 0) return ""; // check for early return
            while (strs[i].indexOf(pre) != 0) { // pre is not a common prefix
                pre = pre.substring(0, pre.length() - 1); // trim the last char and try again
            }
        }
        
        return pre;
    }
}