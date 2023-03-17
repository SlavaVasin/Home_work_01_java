// Задано уравнение вида q + w = e. q,w,e >= 0.
// Некоторые цифры могут быть заменены знакомы вопроса, например 2? + ?5 = 69
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.

public class Task_04 {
    public static void main(String[] args) {
        String inputString = "";
        boolean inputNotValid = true;
        while (inputNotValid) {
            System.out.println(
                    "Введите уравнение формата q + w = e, q,w,e >= 0. Некоторые цифры могут быть заменены знакомы вопроса.");
            inputString = System.console().readLine().replaceAll("[^0-9?+= ]", "");
            if (inputString == null || inputString == "")
                System.out.println("Ошибка ввода данных.");
            else {
                if (checkInput(inputString))
                    inputNotValid = false;
                else
                    System.out.println("Ошибка ввода данных (неверный формат)");
            }
        }
        int countQM = 0; // count Question Marks
        for (int i = 0; i < inputString.length(); i++)
            if (inputString.charAt(i) == '?')
                countQM++;
        int[] posOfQM = new int[countQM];
        int idToFill = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '?') {
                posOfQM[idToFill] = i;
                idToFill++;
            }
        }
        int tempNum = 0;
        for (int tryNums = 0; tryNums < Math.pow(10, countQM); tryNums++) {
            tempNum = tryNums;
            for (int i = countQM - 1; i >= 0; --i) {
                inputString = replaceCharWithNumber(inputString, posOfQM[i], tempNum % 10);
                tempNum /= 10;
            }
            checkResult(inputString);
        }
        System.out.println("Подходящих решений нет.");
    }

    public static String replaceCharWithNumber(String inputString, int index, int newValue) {
        char[] chars = inputString.toCharArray();
        chars[index] = (char) ('0' + newValue);
        return String.valueOf(chars);
    }

    public static void checkResult(String stringToCheck) {
        String[] variables = stringToCheck.split(" ");
        if (Integer.parseInt(variables[0]) + Integer.parseInt(variables[2]) == Integer.parseInt(variables[4])) {
            System.out.println(variables[0] + " + " + variables[2] + " = " + variables[4]);
            System.exit(0);
        }
    }

    public static boolean checkInput(String inString) {
        String[] inArray = inString.split(" ");
        if (inArray.length == 5) {
            inArray[0] = inArray[0].replaceAll("[+=]", "");
            inArray[2] = inArray[2].replaceAll("[+=]", "");
            inArray[4] = inArray[4].replaceAll("[+=]", "");
            if (inArray[0].equals("") || inArray[2].equals("") || inArray[4].equals("") || !inArray[3].equals("=")
                    || !inArray[1].equals("+"))
                return false;
            return true;
        }
        return false;
    }
}