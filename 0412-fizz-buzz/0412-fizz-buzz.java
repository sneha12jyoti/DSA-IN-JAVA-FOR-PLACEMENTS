class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            boolean isDivisibleBy3 = (i % 3 == 0);
            boolean isDivisibleBy5 = (i % 5 == 0);
            
            if (isDivisibleBy3 && isDivisibleBy5) {
                ans.add("FizzBuzz");
            } else if (isDivisibleBy3) {
                ans.add("Fizz");
            } else if (isDivisibleBy5) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        
        return ans;
    }
}