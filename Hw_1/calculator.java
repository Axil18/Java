// Реализовать простой калькулятор
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.Arrays;


public class calculator {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("vvedite pervoe chislo: ");
            int num1 = scanner.nextInt();

            System.out.print("vvedite operaciyu: ");
            char operator = scanner.next().charAt(0);

            System.out.print("vvedite vtoroe chislo: ");
            int num2 =scanner.nextInt();

            int result;

            switch(operator) {
                case '+':
                result = num1 + num2;
                System.out.println("result: " + result);
                break;
                case '-':
                result = num1 - num2;
                System.out.println("result: " + result);
                break;
                case '*':
                result = num1 * num2;
                System.out.println("result: " + result);
                break;
                case '/':
                if (num2 != 0) {
                result = num1 / num2;
                System.out.println("result: " + result);
                }
                else {
                    System.out.println("erroe");
                }
                break;
                default:
                System.out.println("nevernaya operacia: ");
                break;
            
            
            }
        }
       
        
    }
    
}
