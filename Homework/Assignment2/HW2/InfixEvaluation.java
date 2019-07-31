package HW2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author SHAO
 */
public class InfixEvaluation {

    public static void main(String[] args) throws FileNotFoundException {
        
        //Read the data file
        Scanner fileInput = new Scanner(new File(InfixEvaluation.class.getResource("infix_expressions.txt").getFile()));
        
        //Judge whether has next line
        while (fileInput.hasNext()) {
            String e = fileInput.nextLine();
            //Split the line
            String[] expression = e.split(" ");
            
            //Declare two stacks to store operand and operator
            LinkedStack operand = new LinkedStack();
            LinkedStack operator = new LinkedStack();
            
            //Loop for every char in expression
            for (int i = 0; i < expression.length; i++) {
                if (expression[i].equals("(")) {
                    continue;
                } else if (expression[i].equals("+") || expression[i].equals("-")
                        || expression[i].equals("*") || expression[i].equals("/")) {
                    //Push operators into operator stack
                    operator.push(expression[i]);
                } else if (expression[i].equals(")")) {
                    //Make sure operator stack is not empty and operand stack size >= 2
                    if (!operator.isEmpty() && operand.size() >= 2) {
                        //Pop two values and operator
                        int a = Integer.parseInt(operand.pop().toString());
                        int b = Integer.parseInt(operand.pop().toString());
                        String o = operator.pop().toString();
                        //Declare result variable
                        int result = -1;
                        
                        //Check which operator it uses
                        if (o.equals("+")) {
                            result = b + a;
                        } else if (o.equals("-")) {
                            result = b - a;
                        } else if (o.equals("*")) {
                            result = b * a;
                        } else if (o.equals("/")) {
                            result = b / a;
                        }
                        //Push the result value into operand stack
                        operand.push(result);
                    }
                } else {
                    //Push all digital value into operand stack
                    operand.push(expression[i]);
                }
            }
            //Output for the program
            System.out.println("The value of " + e + " is " + operand.pop());
        }
    }
}
