import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorApplication {
    public static void main(String[] args) throws IOException, OperationException, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputArr = input.split(" ");
        int num1, num2;
        char operation = ' ';
        Boolean isRoman = false;

        if (isRomanNumber(inputArr[0]) && isRomanNumber(inputArr[2])) {
            num1 = turningToInt(inputArr[0]);
            num2 = turningToInt(inputArr[2]);
            isRoman = true;
        }
        else if (isTheNumber(inputArr[0]) && isTheNumber(inputArr[2])) {
            num1 = turningToInt(inputArr[0]);
            num2 = turningToInt(inputArr[2]);
        }
        else
            throw new NumberFormatException("Неверный формат ввода");

        operation = inputArr[1].charAt(0);

        if (!(operation == '+' | operation == '-' | operation == '/' | operation == '*'))
            throw new OperationException("Неверная операция");

        Calculator calculator = new Calculator(num1, num2, operation, isRoman);
        System.out.println(calculator.calculation());
    }

    public static int turningToInt(String num) {
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] Numerals = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int result = 1;
        for (int i = 0; i < romanNumerals.length; i++) {
            if (num.equals(romanNumerals[i]))
                result = i + 1;
            else if (num.equals(Numerals[i]))
                result = i + 1;
        }
        return result;
    }

    public static boolean isRomanNumber(String num) {
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String item : romanNumerals) {
            if (item.equals(num))
                return true;
        }
        return false;
    }

    public static boolean isTheNumber(String num) {
        String[] Numerals = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String item : Numerals) {
            if (item.equals(num))
                return true;
        }
        return false;
    }
}
