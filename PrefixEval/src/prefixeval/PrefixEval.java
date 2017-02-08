
package prefixeval;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*
 * @author zacharybechhoefer
 */

public class PrefixEval {
    
    public static void main(String[] args) throws IOException{
        
        ArrayList<String> outs = new ArrayList();
        ArrayList<PrefixParser2> comps = new ArrayList();
        
        Path input = new File("src/prefixeval/sample_input.txt").toPath();
        //Path output = new File("src/prefixeval/sample_output.txt").toPath();
        Charset charset = Charset.defaultCharset();       
        List<String> stringList = Files.readAllLines(input, charset);
        String[] stringArray = stringList.toArray(new String[]{});
        for(int i = 0; i<stringArray.length; i++){
            outs.add(stringArray[i]);
        }
        //System.out.println(outs);
        for(int i = 0; i<outs.size(); i++){
            comps.add(new PrefixParser2(outs.get(i)));
        }
        
        //http://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-a-file-in-java
        File file = new File("src/prefixeval/sample_output.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        
        for(int i = 0; i<outs.size(); i++){
            bw.write(comps.get(i).getOuts() + "\n");

        }
        bw.close();
        //http://stackoverflow.com/questions/34954630/java-read-line-using-inputstream
        //FileWriter input = new FileWriter("src/prefixeval/sample_input.txt");
        //FileWriter output = new FileWriter("src/prefixeval/sample_output.txt",true);
        

    }
    
}
