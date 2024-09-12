class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLength = 0;
        boolean[] check = new boolean[127];

        for(int right = 0; right < n; right++) {
            if(!check[s.charAt(right)]){
                check[s.charAt(right)] = true;
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while(check[s.charAt(right)]) {
                    check[s.charAt(left)] = false;
                    left++;
                }

                check[s.charAt(right)] = true;
            }
        }

        return maxLength;
    }
}