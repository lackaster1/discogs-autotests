package tests;

public class Calculator {
    static Double calculate(Integer num1, Integer num2, String opt) {
        switch (opt) {
            case "sum":
                return Double.valueOf(num1 + num2);
            case "divide":
                return Double.valueOf((double) num1 / num2);
            case "multiply":
                return Double.valueOf(num1 * num2);
            case "subtract":
                return Double.valueOf(num1 - num2);
            default:
                throw new UnsupportedOperationException("You entered invalid option");
        }
    }
}
