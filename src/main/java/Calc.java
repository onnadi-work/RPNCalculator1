import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class Calc {
    String inputString;
    private ArrayList<String> tokens;

    public Calc(String input) {
        this.inputString = input;
        tokens = new ArrayList<>();
        Collections.addAll(tokens, inputString.split(" "));
    }

    public Double eval() {
        Stack<Double> stack = new Stack<>();
        HashMap<String, BinaryOperator<Double>> binaryOperators = new HashMap<>();
        binaryOperators.put("+", Calc::sum);
        binaryOperators.put("-", Calc::subtract);
        binaryOperators.put("*", Calc::multiply);
        binaryOperators.put("/", Calc::divide);

        for (String token : tokens) {
            if (binaryOperators.containsKey(token)) {
                Double expression1 = stack.pop();
                Double expression2 = stack.pop();
                stack.add(binaryOperators.get(token).apply(expression2, expression1));
            } else if (token.equals("SQRT")) {
                stack.add(Math.sqrt(stack.pop()));
            } else {
                stack.add(Double.parseDouble(token));
            }
        }

        return stack.pop();
    }

    private static Double divide(Double a, Double b) {
        return a / b;
    }

    private static Double multiply(Double a, Double b) {
        return a * b;
    }

    private static Double subtract(Double a, Double b) {
        return a - b;
    }

    private static Double sum(Double a, Double b) {
        return a + b;
    }
}
