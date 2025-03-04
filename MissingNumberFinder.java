import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

public class MissingNumberFinder {

    public static int findMissingNumber(int[] nums, int n) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int expectedSum = (n * (n + 1)) / 2;
        return expectedSum - totalSum;
    }

    public static boolean isPrime(int num) {
        // Base case: Numbers less than 2 are not prime
        if (num <= 1) {
            return false;
        }
        
        // Check divisibility from 2 to sqrt(num)
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;  // num is divisible by i, so it's not prime
            }
        }
        
        return true;  // num is prime
    }

    public static boolean reverseString(String text) {

        if (StringUtils.isBlank(text)) {
            return false;
        }

        return new StringBuilder(text).reverse().toString().equals(text);
    }

    public static int nearToZero(int[] arr) {
        int value = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (Math.abs(value)>=Math.abs(arr[i])) {
                value = arr[i];
            }
        }
        return value;
    }

    public static int findMaxGain(int[] arr) {
        int sum = Integer.MIN_VALUE;
        int minStartValue = arr[0];
        for (int i=1; i<arr.length; i++) {
            int currentSum = arr[i]-minStartValue;
            sum = Math.max(currentSum, sum);
            minStartValue = Math.min(minStartValue, arr[i]);
        }
        return sum;
    }

    public static boolean findClauses(String text) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = text.toCharArray();
        
        if (charArr[0] == '}' || charArr[0] == ')' || charArr[0] == ']') {
            return false;
        }

        for (char c:charArr) {

            if (c == '{' || c== '[' || c=='(') {
                stack.push(c);
            }
            if (c=='}' || c==']' || c==')') {
                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '(')) {
                    return false;
            }
        }
    }
        return stack.isEmpty();
    }

    public static void checkNullArray(int[] arr) {
        try {
            if (arr.length==0) {
                System.out.println("The array has o length");
            }
        } catch(NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void findDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        for (int num:arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Duplicates: " + duplicates);
    }

    public static void findMaxMinValue(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num:arr) {
            min = Math.min(num, min);
            max = Math.max(max, num);
        }

        System.out.println(String.format("The min num is: %d and the max is: %d", min, max));
    }

    public static int reverseInteger(int num) {
        int reversedNum = 0;
        while (num!=0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return reversedNum;
    }

    public static String longestWord(String text) {
        String longst = "";
        String[] arr = text.split(" ");

        for (String str:arr){
            longst = str.length() > longst.length() ? str:longst;
        }

        return longst;
    }

    public static boolean sumOfElement(int[] arr, int num) {
        HashSet<Integer> set = new HashSet<>();
        for (int element:arr) {
            int val = num - element;
            if (set.contains(val)) {
                System.out.println("There is the sum of "+num+" is the addition of " + val+" plus the "+element);
                return true;
            }
            set.add(element);
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        // int[] nums = {1, 2, 4, 5}; // Missing number is 4
        // int n = 5; // Range 1 to 5
        // System.out.println("Missing number: " + findMissingNumber(nums, n)); // Output: 4

        // int number = 7;  // You can change this number to test other cases
        // if (isPrime(number)) {
        //     System.out.println(number + " is a prime number.");
        // } else {
        //     System.out.println(number + " is not a prime number.");
        // }

        // String givenName = "hannah";
        // System.out.println(String.format("The string: %s, is palindrome: %b", givenName, reverseString(givenName)));

        // int[] temp = {-2,-1,1,2,3,4,5,6};
        // System.out.println(nearToZero(temp));

        // int[] values = {2,1,3,4,5,6,7,9};
        // System.out.println(findMaxGain(values));

        // String text = "}[)()]}";
        // System.out.println(findClauses(text));

        // int[] arrWithZero = null;
        // checkNullArray(arrWithZero);

        // int[] arr = {1,2,2,3,3,4};
        // findDuplicates(arr);

        // int[] arr = {0, 1,2,3,4,5,6};
        // findMaxMinValue(arr);

        // int num = 102;
        // System.out.println(reverseInteger(num));

        // String text = "The highest standart value";
        // System.out.println(longestWord(text));

        int[] arr = {1,2,3,4,5};
        sumOfElement(arr, 7);
    }
}
