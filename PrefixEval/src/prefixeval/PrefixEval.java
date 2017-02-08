
package prefixeval;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * @author zacharybechhoefer
 */

public class PrefixEval {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayList<String> outs = new ArrayList();
        
        //http://stackoverflow.com/questions/34954630/java-read-line-using-inputstream
        Scanner scan = new Scanner(new File("src/prefixeval/sample_input.txt"));
        while(scan.hasNextLine()){
         String line = scan.nextLine();
         
        }
        PrefixParser2 arg1 = new PrefixParser2("+ * + 1 3 - 16 12 / 12 * 3 2");
        PrefixParser2 arg2 = new PrefixParser2("* / 16 4 - 10 + 3 2");
        PrefixParser2 arg3 = new PrefixParser2("- + / 80 2 / 80 2 * 12 3");
    }
    
}
