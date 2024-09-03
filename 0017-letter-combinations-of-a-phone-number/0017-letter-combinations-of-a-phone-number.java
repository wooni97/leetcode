class Solution {
    List<List<String>> numbers;
    List<String> answer;
    public List<String> letterCombinations(String digits) {
        init();
        int length = digits.length();

        if(digits.length() == 0) return answer;

        backTracking(new StringBuilder(""), length, 0, digits);
        return answer;
    }

    public void backTracking(StringBuilder combination, int length, int index, String digits) {
        if(combination.length() == length) {
            answer.add(combination.toString());
            return;
        }

        char c = digits.charAt(index);
        int number = Character.getNumericValue(c);

        List<String> letters = numbers.get(number);

        for(int i = 0; i < letters.size(); i++) {
            combination.append(letters.get(i));
            backTracking(combination, length, index+1, digits);
            combination.deleteCharAt(combination.length() - 1);
        }

    }

    public void init() {
        answer = new ArrayList<>();

        numbers = new ArrayList<>();
        for(int i = 0; i <= 10; i++) {
            numbers.add(new ArrayList<String>());
        }

        numbers.get(2).addAll(Arrays.asList("a", "b", "c"));
        numbers.get(3).addAll(Arrays.asList("d", "e", "f"));
        numbers.get(4).addAll(Arrays.asList("g", "h", "i"));
        numbers.get(5).addAll(Arrays.asList("j", "k", "l"));
        numbers.get(6).addAll(Arrays.asList("m", "n", "o"));
        numbers.get(7).addAll(Arrays.asList("p", "q", "r", "s"));
        numbers.get(8).addAll(Arrays.asList("t", "u", "v"));
        numbers.get(9).addAll(Arrays.asList("w", "x", "y", "z"));
    }
}