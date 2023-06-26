package Hw_2;

// К калькулятору из предыдущего дз добавить логирование.
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class calc {
     private static final Logger LOGGER = Logger.getLogger(calc.class.getName());
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        try {
            FileHandler fileHandler = new FileHandler("calculator.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "mistake", e);
        }

        LOGGER.setLevel(Level.INFO);
        LOGGER.info("started.");
        
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
            LOGGER.info(num1 + " + " + num2 + " = " + result);
            System.out.println("result: " + result);
            break;
            case '-':
            result = num1 - num2;
            LOGGER.info(num1 + " - " + num2 + " = " + result);
            System.out.println("result: " + result);
            break;
            case '*':
            result = num1 * num2;
            LOGGER.info(num1 + " * " + num2 + " = " + result);
            System.out.println("result: " + result);
            break;
            case '/':
            if (num2 != 0) {
            result = num1 / num2;
            LOGGER.info(num1 + " / " + num2 + " = " + result);
            System.out.println("result: " + result);
            }
            else {
                LOGGER.warning("error");
                System.out.println("error");
            }
            break;
            default:
            LOGGER.warning("nevernaya operacia: ");
            System.out.println("nevernaya operacia: ");
            break;

        }
        LOGGER.info("Программа калькулятора завершена.");

        scanner.close();

    }
    
}
