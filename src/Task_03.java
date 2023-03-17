
//простой калькулятор
import java.lang.System;

public class Task_03 {
    public static void main(String[] args) {
        boolean inputNotValid = true;
        String inputStr = "";
        String operators = "";
        String[] inputSplit = {};
        while (inputNotValid) {
            System.out.println("Введите математическое выражение. Поддерживаются знаки: [ + - * / ], порядок действий игнорируется.");
            inputStr = System.console().readLine().replaceAll("[^0-9\\+\\-\\*\\/]", "");
            if (inputStr == "" || inputStr == null){
                System.out.println("Ошибка ввода!");
                continue;
            }
            inputSplit = inputStr.split("\\D");
            operators = inputStr.replaceAll("\\d", "");
            if (inputSplit.length > 0 && operators.length() > 0){
                inputNotValid =false;
            }
            else
                System.out.println("Ошибка ввода!");

        }

        int[] arguments = new int[inputSplit.length];
        for (int i = 0; i < arguments.length; i++) {
            arguments[i] = Integer.parseInt(inputSplit[i]);
        }

        double result = arguments[0];
        for (int i = 1; i < arguments.length; i++) {
            if (operators.charAt(i - 1) == '+') {
                result += arguments[i];
            } else {
                if (operators.charAt(i - 1) == '-') {
                    result -= arguments[i];
                } else {
                    if (operators.charAt(i - 1) == '*') {
                        result *= arguments[i];
                    } else {
                        if (operators.charAt(i - 1) == '/') {
                            if (arguments[i] == 0){
                                System.out.println("Ошибка. Деление на 0.");
                                System.exit(0);
                            }
                            result /= arguments[i];
                        } else {
                            System.out.println("Ошибка ввода.");
                            java.lang.System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}