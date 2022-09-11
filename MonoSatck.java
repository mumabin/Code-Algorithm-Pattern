class Solution {
    public int sumSubarrayMins(int[] arr) {
        if (arr == null ) {
            return 0;
        }
        
        long sum = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= arr.length; i++) {
            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] > arr[i])) {
                int j = stack.peek();
                stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                
                sum += (long)arr[j] * (i - j) * (j - k);
                
                sum %= 1000000007;
            }
            stack.push(i);
            
        }
        return (int)sum;
    }
}
