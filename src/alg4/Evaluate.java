package alg4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * Created by leon on 16/4/4.
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        String s = "";
        if (s.equals("(")) ;
        else if (s.equals("+")) ops.push(s);
        else if (s.equals("-")) ops.push(s);
        else if (s.equals("*")) ops.push(s);
        else if (s.equals("/")) ops.push(s);
        else if (s.equals("sqrt")) ops.push(s);
        else if (s.equals(")")) {
            String op = ops.pop();
            double v = vals.pop();
            if (op.equals("+")) v = vals.pop() + v;
            if (op.equals("-")) v = vals.pop() - v;
            if (op.equals("*")) v = vals.pop() * v;
            if (op.equals("/")) v = vals.pop() / v;
            if (op.equals("sqrt")) v = Math.sqrt(v);
            vals.push(v);
        } else vals.push(Double.parseDouble(s));
        System.out.println(vals.pop());
    }
}
