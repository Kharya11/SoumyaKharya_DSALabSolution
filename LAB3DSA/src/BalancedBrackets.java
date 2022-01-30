
import java.util.*;
import java.util.Stack;
public class BalancedBrackets {
 
    // function to check if brackets are balanced
    static boolean areBracketsBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Stack<Character> stack = new Stack<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
                char check;
            
            switch (x) 
            {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                    break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                    break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                    break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }
 
    // Driver code
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Please enter expression to check :");
    	    	
    	String expr=sc.next();
    	         
        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Given input Brackets are Balanced ");
        else
            System.out.println("Given input Brackets are Un-Balanced ");
    }
}