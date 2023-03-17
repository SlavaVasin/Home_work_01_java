import java.util.Scanner;

// Вычислить n-ое треугольного(?) число (Сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

public class Task_01 {
    public static void main(String[] args) {
        System.out.println("Вычисление n-го треугольного числа и n!.");
        int n = 0;
        boolean numNotValid = true;
        while (numNotValid) {
            System.out.print("Введите число n: ");
            n = getIntFromUser();
            if (n > 0)
                numNotValid = false;
            else
                System.out.println("Ошибка ввода данных.");
        }
        int sum = 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            factorial *= i;
        }
        System.out.println("Сумма чисел от 1 до " + n + ": " + sum);
        System.out.println(n + "! = " + factorial);
    }

    public static Integer getIntFromUser() {
        int inputInt = 0;
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        sc.close();
        try {
            inputInt = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода данных: " + e);
            return 0;
        }
        return inputInt;
    }
}