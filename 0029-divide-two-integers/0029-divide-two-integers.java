class Solution {
    public int divide(int dividend, int divisor) {
        // Handle edge case: division by 0
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        // Handle edge case: dividend is MIN_VALUE and divisor is -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        // Convert dividend and divisor to positive values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // Perform the division
        long result = 0;
        while (absDividend >= absDivisor) {
            long temp = absDivisor, count = 1;
            while ((temp << 1) <= absDividend) {
                temp <<= 1;
                count <<= 1;
            }
            absDividend -= temp;
            result += count;
        }

        // Apply the sign and handle overflow
        result = result * sign;
        return (int) Math.max(Math.min(result, Integer.MAX_VALUE), Integer.MIN_VALUE);
    }
}