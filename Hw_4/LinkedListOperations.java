package Hw_4;

import java.util.LinkedList;

public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList<Integer> num1 = new LinkedList<>();
        LinkedList<Integer> num2 = new LinkedList<>();

        
        num1.addLast(2);
        num1.addLast(4);
        num1.addLast(3);

        num2.addLast(5);
        num2.addLast(6);
        num2.addLast(4);

        
        LinkedList<Integer> multiplicationResult = multiply(num1, num2);
        System.out.println("Результат умножения: " + multiplicationResult);

        
        LinkedList<Integer> additionResult = add(num1, num2);
        System.out.println("Результат сложения: " + additionResult);
    }

    public static LinkedList<Integer> multiply(LinkedList<Integer> num1, LinkedList<Integer> num2) {
        int carry = 0;
        LinkedList<Integer> result = new LinkedList<>();

        for (int digit2 : num2) {
            LinkedList<Integer> tempResult = new LinkedList<>();

            
            for (int i = 0; i < carry; i++) {
                tempResult.addFirst(0);
            }

            for (int digit1 : num1) {
                int product = digit1 * digit2 + carry;
                tempResult.addFirst(product % 10);
                carry = product / 10;
            }

            if (carry > 0) {
                tempResult.addFirst(carry);
                carry = 0;
            }

            result = add(result, tempResult);
            carry++;
        }

        return result;
    }

    public static LinkedList<Integer> add(LinkedList<Integer> num1, LinkedList<Integer> num2) {
        int carry = 0;
        LinkedList<Integer> result = new LinkedList<>();

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int digit1 = num1.isEmpty() ? 0 : num1.removeFirst();
            int digit2 = num2.isEmpty() ? 0 : num2.removeFirst();

            int sum = digit1 + digit2 + carry;
            result.addLast(sum % 10);
            carry = sum / 10;
        }

        return result;
    }
}