package numbers;

import java.util.List;

public class RisingNumbers {

    public int getNumberOfSixDigitRisingNumbers(List<Integer> numbers) {
        validateParameter(numbers);
        return (int) numbers.stream()
            .filter(this::isNumberToConsider)
            .count();
    }

    // --- private methods ----------------------------------------------------

    private boolean isSixDigitNumber(int number) {
        return 99_999 < number && number < 1_000_000;
    }

    private boolean isRisingNumber(int number) {
        int auxNumber = number;
        int lastDigit;
        int beforeLastDigit;
        boolean isRising = true;
        while (auxNumber > 0) {
            lastDigit = auxNumber % 10;
            auxNumber /= 10;
            beforeLastDigit = auxNumber % 10;
            if (beforeLastDigit >= lastDigit) {
                isRising = false;
                break;
            }
        }
        return isRising;
    }

    private boolean isNumberToConsider(int number) {
        return isSixDigitNumber(number) && isRisingNumber(number);
    }

    private void validateParameter(List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException("There are no numbers!");
        }
    }
}