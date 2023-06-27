package Hw_3;

import java.util.ArrayList;
import java.util.List;

public class random {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(4);
        numbers.add(9);
        numbers.add(16);
        numbers.add(2);

        List<Integer> delNumbers = removeEvenNumbers(numbers);
        System.out.println("Список после удаления: " + delNumbers);

        int min = findMinValue(numbers);
        System.out.println("Минимальное значение: " + min);

        int max = findMaxValue(numbers);
        System.out.println("Максимальное значение: " + max);

        double average = findAverageValue(numbers);
        System.out.println("Среднее значение: " + average);
    }
        public static List<Integer> removeEvenNumbers(List<Integer> numbers) {
        List<Integer> delNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 != 0) {
                delNumbers.add(number);
            }
        }
        return delNumbers;
    }
    public static int findMinValue(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
    public static int findMaxValue(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
    public static double findAverageValue(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }
}

    
