package prefixeval;

import java.util.Stack;

/**
 *
 * @author zacharybechhoefer
 */
public final class PrefixParser2 {

    String eval;
    Stack tokens = new Stack();
    Stack ops = new Stack();
    int solution;

    PrefixParser2(String argument) {
        tokenize(argument);
        while(tokens.size()>1){
            parse();
        }
    }

    void tokenize(String argument) {
        String args = argument + " ";
        char cargs[] = args.toCharArray();
        for (int i = 0; i < cargs.length - 1; i++) {
            if (cargs[i] != ' ') {
                String ntok = "";
                while (cargs[i] != ' ') {
                    ntok += String.valueOf(cargs[i]);
                    i++;
                }
                tokens.push(ntok);
            }
        }
        /*
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(i + ": " + tokens.get(i));
        }
        */
    }

    void parse() {
        for (int i = tokens.size() - 3; i >= 0; i--) {
            if (opSeq(i)) {
                //System.out.println(tokens.get(i));
                int len = tokens.size();
                for (int j = tokens.size() - 1; j > i+2; j--) {
                    ops.push(tokens.pop());
                }
                operate((String) tokens.pop(),(String) tokens.pop(),(String) tokens.pop());
                for(int k = 0; k < ops.size(); k++){
                    tokens.push(ops.pop());
                }
                return;
            }
        }
        System.out.println(ops);
    }

    void operate(String b, String a, String op) {
        switch (op) {
            case "*":
                tokens.push(Integer.toString(Integer.parseInt(a) * Integer.parseInt(b)));
                break;
            case "/":
                tokens.push(Integer.toString(Integer.parseInt(a) / Integer.parseInt(b)));
                break;
            case "+":
                tokens.push(Integer.toString(Integer.parseInt(a) + Integer.parseInt(b)));
                break;
            case "-":
                tokens.push(Integer.toString(Integer.parseInt(a) - Integer.parseInt(b)));
                break;
        }
        System.out.println(op+" "+a+" "+b);
        System.out.println(tokens);
    }

    boolean opSeq(int i) {
        if (isOperator((String) tokens.get(i)) && isNumeric((String) tokens.get(i + 1)) && isNumeric((String) tokens.get(i + 2))) {
            return true;
        } else {
            return false;
        }
    }

    Stack reverse(Stack oldstack) {
        Stack newstack = new Stack();
        int end = oldstack.size();
        for (int i = 0; i < end; i++) {
            newstack.push(oldstack.pop());
        }
        return newstack;
    }

    public void multipop(int k, Stack stack) {
        for (int i = 0; i <= k; i++) {
            stack.pop();
        }
    }

    boolean isOperator(String in) {
        if (in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/")) {
            return true;
        }
        return false;
    }

    //http://stackoverflow.com/questions/14206768/how-to-check-if-a-string-is-numeric
    public boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

}
