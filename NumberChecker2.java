import java.util.ArrayList;
import java.util.List;

public class NumberChecker2 {

    public static void main(String[] args) {
        int number = 1729;

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + countDigits(number));

        int[] digits = getDigitsArray(number);
        System.out.print("Digits array: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));
        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));

        int[][] frequency = digitFrequency(digits);
        System.out.println("Digit Frequency:");
        for (int[] row : frequency) {
            System.out.println("Digit: " + row[0] + " Frequency: " + row[1]);
        }
    }

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number) {
        List<Integer> digitsList = new ArrayList<>();
        while (number > 0) {
            digitsList.add(0, number % 10);
            number /= 10;
        }
        return digitsList.stream().mapToInt(i -> i).toArray();
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }
        List<int[]> frequencyList = new ArrayList<>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                frequencyList.add(new int[]{i, frequency[i]});
            }
        }
        return frequencyList.toArray(new int[0][]);
    }
}
