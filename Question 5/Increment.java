import java.util.Arrays;

public class Increment {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        
       
        digits[n - 1] += 1;
        
        
        int carry = digits[n - 1] / 10;
        digits[n - 1] %= 10;
        
        
        for (int i = n - 2; i >= 0; i--) {
            if (carry == 0)
                break;
            
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        
       
        if (carry > 0) {
            int[] result = new int[n + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, n);
            return result;
        }
        
        return digits;
    }
    
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
