package com.dailyinterviewprojava.google;
import java.util.Stack;
import java.util.Scanner; 

/**
 * 
 * @author ema
 * Given a mathematical expression with just single digits, plus signs, negative signs, and brackets, evaluate the expression. 
 * Assume the expression is properly formed.
 *
 * Example:
 * Input: - ( 3 + ( 2 - 1 ) )
 * Output: -4
 *
 */

public class CreateASimpleCalculator {

    static Stack<Integer> numbersStack = new Stack<>();
    static Stack<String> operationStack = new Stack<>();

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter expression");
        String userExpression = myObj.nextLine();  // Read user input
        System.out.println("Expression is: " + userExpression); 
        System.out.println(eval(userExpression));
    }

    private static int eval(String expression) {
        String[] splittedArr = expression.split(" ");
        for (int i = 0; i < splittedArr.length; i++) {
            String val = splittedArr[i];
            if (isNum(val)) {
                numbersStack.push(Integer.valueOf(val));
            } else if (val.equals("(")) {
                operationStack.push(val);
            } else if (val.equals(")")) {
                while (operationStack.size() > 0 && !operationStack.get(operationStack.size() - 1).equals("(")) {
                    doOperation();
                }
                operationStack.pop();
            } else if (isOperator(val)) {
                if (operationStack.size() > 0 && priority(operationStack.get(operationStack.size() - 1)) > priority(val)) {
                    doOperation();
                }
                operationStack.push(val);
            }

        }

        // here we done with operations between ( )
        if (numbersStack.size() > 1) {
            while (operationStack.size() > 0) {
                doOperation();
            }
        } else if (numbersStack.size() == 1) {
            doOperationSingleNum();

        }
        return numbersStack.pop();
    }

    private static void doOperationSingleNum() {
        String operator = operationStack.pop();
        Integer num = numbersStack.pop();

        if (operator.equals("-")) {
            num = -num;
        }
        numbersStack.push(num);
    }

    private static int priority(String val) {
        int priority;
        switch (val) {
            case "+":
            case "-":
                priority = 1;
                break;
            case "*":
            case "/":
                priority = 2;
                break;
            default:
                priority = 0;
                break;
        }
        return priority;
    }

    private static boolean isOperator(String val) {
        return val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/");
    }

    private static void doOperation() {
        if (numbersStack.size() == 1) {
            doOperationSingleNum();
        } else {
            Integer firstNum = numbersStack.pop();
            Integer lastNum = numbersStack.pop();
            String operator = operationStack.pop();

            int result = 0;
            switch (operator) {
                case "+":
                    result = lastNum + firstNum;
                    break;
                case "-":
                    result = lastNum - firstNum;
                    break;
                case "*":
                    result = lastNum * firstNum;
                    break;
                case "/":
                    result = lastNum / firstNum;
                    break;
            }
            numbersStack.push(result);
        }

    }

    private static boolean isNum(String val) {
        return "0123456789".contains(val);
    }
}

