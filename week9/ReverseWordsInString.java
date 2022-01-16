class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        Collections.reverse(Arrays.asList(arr));
        
        return String.join(" ", arr).trim();
    }
}