import java.util.Scanner;
// n! (произведение чисел от 1 до n)

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("vvedite chislo n: ");
        int n = scanner.nextInt();

        long factorial = calculateFactorial(n);

        System.out.println("factorial chisla " + n + " raven: " + factorial);

        scanner.close();

    }
    public static long calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } 
        else {
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
    
}
