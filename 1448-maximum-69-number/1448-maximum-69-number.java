class Solution {
    public int maximum69Number (int num) {
        Stack<Integer> stack = new Stack<>();
        while(num != 0) {
            stack.push(num % 10);
            num /= 10;
        }

        int result = 0;
        boolean isChanged = false;
        while(!stack.isEmpty()) {
            result *= 10;
            
            int n = stack.pop();
            if(!isChanged && n == 6) {
                n = 9;
                isChanged = true;
            }
            result += n;
        }
        return result;
    }
}