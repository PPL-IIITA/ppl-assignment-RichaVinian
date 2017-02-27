
package ppl_assignment;

import java.io.IOException;


public class q1_main {
    
    /**
     * <h1>Main file for question1 </h1>
     * <p>
     * This file prints the girls who are committed along with their partners
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        
       girl g[] = new girl[500];
       boy b[] = new boy[500];
       input inp = new input(g,b,args);
       System.out.println("girl" + " " + "boyfriend" );
       for(int i=0;i<inp.n_g;i++){
           if(inp.couple[i]!=-1)
               System.out.println(g[i].name + " " + b[inp.couple[i]].name );
        }
      
    }
    
    
}
