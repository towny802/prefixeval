package prefixeval;

/*
    void parse() {
        int a;
        int b;
        Stack newstack = new Stack();
        while (tokens.size() > 1) {
            for (int i = tokens.size() - 2; i > 1; i--) {
                System.out.println(tokens);
                if (isOperator((String) tokens.get(i)) && isNumeric((String) tokens.get(i + 1)) && isNumeric((String) tokens.get(i + 2))) {
                    //tokens.push(operate((String) tokens.pop(), (String) tokens.pop(), (String) tokens.pop()));
                    newstack.push(operate((String) tokens.get(i+2),(String) tokens.get(i+1),(String) tokens.get(i)));
                }
            }
        }
    }
*/
    /*
    int parse(int index){
        int out = 0;
        if(isNumeric((String) tokens.get(index))){
            return Integer.parseInt((String) tokens.get(index));
        }
        else if(isOperator((String) tokens.get(index))){
            switch((String) tokens.get(index)){
                case "+":
                    out = parse(index-1) + parse((index-1)/2);
                    break;
                case "-":
                    out = parse(index-1) - parse((index-1)/2);
                    break;
                case "*":
                    out = parse(index-1) * parse((index-1)/2);
                    break;
                case "/":
                    out = parse(index-1) / parse((index-1)/2);
                    break;
            }
        }
        System.out.println(out);
        return out;
    }
    */

import java.util.Stack;

/**
 *
 * @author zacharybechhoefer
 */
public final class PrefixParser {

    String eval;
    Stack tokens = new Stack();
    Stack ops = new Stack();
    int solution;

    PrefixParser(String argument) {
        tokenize(argument);
        //parse(0);
        parse();
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
        System.out.println("Init: "+tokens);
    }
    void parse(){
        Stack ops = new Stack();
        while(tokens.size()>1){
            for(int i = 0; i <= tokens.size()-2; i++){
                if(opSeq(i)){
                    splitop(i);
                }
            }
        }
    }
    
    void splitop(int i){
        int iters = i-3;
        for(int j = 0; j<=iters; j++){
            ops.push(tokens.pop());
        }
        //System.out.println(tokens);
        tokens.push(ops);
        ops.clear();
    }

    boolean opSeq(int i){
        if (isOperator((String) tokens.get(i)) && isNumeric((String) tokens.get(i + 1)) && isNumeric((String) tokens.get(i + 2))) {
            return true;
        } else {
        return false;
        }
    }
    
    Stack reverse(Stack oldstack){
        Stack newstack = new Stack();
        int end = oldstack.size();
        for(int i = 0; i < end;i++){
            newstack.push(oldstack.pop());
        }
        return newstack;
    }
    
    public void multipop(int k, Stack stack) {
        for(int i = 0; i<=k; i++){
            stack.pop();
        }
    }
    
    boolean isOperator(String in) {
        if (in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/")) {
            return true;
        }
        return false;
    }

    String operate(String op, String a, String b) {
        int out = 0;
        switch (op) {
            case "*":
                out = Integer.parseInt(a) * Integer.parseInt(b);
                break;
            case "/":
                out = Integer.parseInt(a) / Integer.parseInt(b);
                break;
            case "+":
                out = Integer.parseInt(a) + Integer.parseInt(b);
                break;
            case "-":
                out = Integer.parseInt(a) - Integer.parseInt(b);
                break;
        }
        System.out.println(a+" "+op+" "+b+"="+out);
        return Integer.toString(out);
    }

    
    //http://stackoverflow.com/questions/14206768/how-to-check-if-a-string-is-numeric
    public boolean isNumeric(String s) {  
        return s.matches("[-+]?\\d*\\.?\\d+");  
    } 
     
}
