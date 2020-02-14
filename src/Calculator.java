import java.util.HashMap;
import java.util.Map;

public class Calculator<T> {
    private int num1;
    private int num2;
    private char operation;
    private Object result;
    private Boolean isRoman;
    private Map<Character, Operation> operationMap = new HashMap<>();

    public Calculator(int num1, int num2, char operation, Boolean isRoman) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.isRoman = isRoman;

        operationMap.put('+', new Addition());
        operationMap.put('-', new Subtraction());
        operationMap.put('*', new Multiplication());
        operationMap.put('/', new Division());
    }

    public Object calculation() {
        Operation operationMapValue = operationMap.get(operation);
        double num = operationMapValue.calculateResult(num1, num2);
        if (operation == '/')
            result = num;
        if (num % 1 == 0)
            result = (int)num;
        if (isRoman) {
            result = turningToRoman(num);
        }
        return result;

    }
    public String turningToRoman(double N) {
        String romanNum = "";
        if (N == 100)
            romanNum += "C";
        else if (N >= 90) {
            romanNum += "XC";
            romanNum += lessX(N - 90);
        }
        else if (N >= 80) {
            romanNum += "LXXX";
            romanNum += lessX(N - 80);
        }
        else if (N >= 70) {
            romanNum += "LXX";
            romanNum += lessX(N - 70);
        }
        else if (N >= 60) {
            romanNum += "LX";
            romanNum += lessX(N - 60);
        }
        else if (N >= 50) {
            romanNum += "L";
            romanNum += lessX(N - 50);
        }
        else if (N >= 40) {
            romanNum += "XL";
            romanNum += lessX(N - 40);
        }
        else if (N >= 30) {
            romanNum += "XXX";
            romanNum += lessX(N - 30);
        }
        else if (N >= 20) {
            romanNum += "XX";
            romanNum += lessX(N - 20);
        }
        else if (N >= 10) {
            romanNum += "X";
            romanNum += lessX(N - 10);
        }
        else
            romanNum += lessX(N);
        return romanNum;
    }
    public String lessX(double num) {
        String result = "";
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < romanNumerals.length; i++) {
            if ((i + 1) == (int) num)
                result = romanNumerals[i];
        }
        return result;
    }
}
